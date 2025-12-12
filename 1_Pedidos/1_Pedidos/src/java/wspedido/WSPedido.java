/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wspedido;

import entidades.Product;
import entidades.Customer;
import entidades.CustomerOrder;
import entidades.OrderedProduct;
import entidades.OrderedProductPK;
import fachadas.CustomerFacade;
import fachadas.CustomerOrderFacade;
import fachadas.OrderedProductFacade;
import fachadas.ProductFacade;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Web Service para gestión de Pedidos con Reglas de Negocio:
 * 1. Restricción de Lote (Calidad).
 * 2. Descuento de Temporada.
 * 3. Sugerencia de Sustitutos (en caso de falta de stock).
 */
@WebService(serviceName = "WSPedido")
public class WSPedido {

    @EJB
    private OrderedProductFacade orderedProductFacade;
    @EJB
    private CustomerOrderFacade customerOrderFacade;
    @EJB
    private ProductFacade productFacade;
    @EJB
    private CustomerFacade customerFacade;
    
    // Asegúrate de que este nombre coincida con tu persistence.xml
    @PersistenceContext(unitName = "WS_Parcial_02PU")
    private EntityManager em;

    /**
     * Web service operation: ALTA PEDIDO MEJORADA
     * Incluye control de lotes, descuentos de temporada y validación "Todo o Nada".
     */
    @WebMethod(operationName = "altaPedido")
    public int altaPedido(@WebParam(name = "id_clte") int id_clte, 
                          @WebParam(name = "lista_it") List<ClsItem> lista_it,
                          @WebParam(name = "restriccion_calidad") boolean restriccion_calidad) 
    {
        Customer clte = customerFacade.find(new Integer(id_clte));
        if(clte == null) {
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, "El cliente_id:" + id_clte + " NO EXISTE");
            return 0;
        }
        
        List<OrderedProduct> lista_orderedProducts = new ArrayList<>();
        OrderedProduct ordered_product;
        Product prod;
        int num_conf;
        int num_pedido = 0;
        
        BigDecimal bd_monto_pedido = BigDecimal.ZERO;
        
        // Bandera para cancelar todo el pedido si falta un ítem
        boolean pedidoValido = true;

        for (ClsItem it : lista_it) 
        {
            Logger.getLogger(this.getClass().getName()).log(Level.INFO,
                    "Procesando Product_id:" + it.getId_prod() + ", cantidad:" + it.getCantidad());
            
            prod = productFacade.find(new Integer(it.getId_prod()));
            
            if (prod != null) {
                // --- REGLA 1: VALIDACIÓN PREVIA DE STOCK ---
                // Si hay restricción de calidad o para evitar ventas parciales, verificamos antes.
                if (prod.getExistencia() < it.getCantidad()) {
                    Logger.getLogger(this.getClass().getName()).log(Level.WARNING, 
                            "Stock insuficiente para ID " + prod.getId() + ". Req: " + it.getCantidad() + ", Disp: " + prod.getExistencia());
                    pedidoValido = false;
                    break; 
                }

                // --- INTENTO DE APARTADO ---
                int cantidad_apartada = productFacade.actualizaExistencia(it.getId_prod(), it.getCantidad());
            
                // --- CORRECCIÓN CLAVE: LÓGICA "TODO O NADA" ---
                // Si el facade devolvió menos de lo pedido (venta parcial), revertimos y fallamos.
                if (cantidad_apartada < it.getCantidad()) {
                    // Reversión manual (Rollback) de lo que se haya podido apartar parcialmente
                    if (cantidad_apartada > 0) {
                        productFacade.agregaExistencia(it.getId_prod(), cantidad_apartada);
                    }
                    Logger.getLogger(this.getClass().getName()).log(Level.WARNING, 
                            "Venta parcial detectada y rechazada para mantener integridad del pedido.");
                    pedidoValido = false;
                    break;
                }

                // Si llegamos aquí, tenemos la cantidad COMPLETA asegurada.
                ordered_product = new OrderedProduct();
                ordered_product.setProduct(prod);
                ordered_product.setQuantity((short) cantidad_apartada);
                
                // --- REGLA 2: DESCUENTO DE TEMPORADA ---
                BigDecimal precioFinal = prod.getPrice();
                // En Derby/JavaDB boolean se mapea a SmallInt (0 o 1)
                if (prod.getEsTemporada() != null && prod.getEsTemporada() == 1) {
                        BigDecimal descuento = prod.getDescuento() != null ? prod.getDescuento() : BigDecimal.ZERO;
                        BigDecimal factor = BigDecimal.ONE.subtract(descuento);
                        precioFinal = precioFinal.multiply(factor);
                        Logger.getLogger(this.getClass().getName()).log(Level.INFO, 
                                "Descuento de temporada aplicado: " + descuento + " a " + prod.getName());
                }
                
                lista_orderedProducts.add(ordered_product);

                BigDecimal bd_monto_item = precioFinal.multiply(BigDecimal.valueOf(cantidad_apartada));
                // Redondeo estándar para moneda
                bd_monto_item = bd_monto_item.setScale(2, BigDecimal.ROUND_HALF_UP);
                bd_monto_pedido = bd_monto_pedido.add(bd_monto_item);  
            } else {
                pedidoValido = false; // Producto no encontrado
                break;
            }
        }
        
        // --- PERSISTENCIA (Solo si todo el pedido es válido) ---
        if(pedidoValido && !lista_orderedProducts.isEmpty()) 
        {
          CustomerOrder customer_order = new CustomerOrder();
          customer_order.setCustomerId(clte);
          customer_order.setDateCreated(new java.util.Date());
          customer_order.setAmount(bd_monto_pedido);
        
          num_conf = customerOrderFacade.next_conf_number();
          customer_order.setConfirmationNumber(num_conf);
          customerOrderFacade.create(customer_order);
          num_pedido = customer_order.getId();
          
          OrderedProductPK oppk;
          for (OrderedProduct op : lista_orderedProducts) 
          {
            oppk = new OrderedProductPK();
            oppk.setCustomerOrderId(customer_order.getId());
            oppk.setProductId(op.getProduct().getId());
            op.setOrderedProductPK(oppk);
            op.setCustomerOrder(customer_order);
            orderedProductFacade.create(op);
          }
        }
        else
        {
            // --- ROLLBACK MANUAL ---
            // Si el pedido no es válido pero ya habíamos apartado productos en la lista, los devolvemos.
            for(OrderedProduct op : lista_orderedProducts) {
                productFacade.agregaExistencia(op.getProduct().getId(), (int) op.getQuantity());
            }
            // Retornamos 0 para indicar fallo y que el cliente (o BPEL) busque sugerencias.
            return 0;
        }
        
        return num_pedido;
    }

    /**
     * Web service operation: SUGERIR SUSTITUTOS
     * Busca productos con mismo grosor y fibra pero diferente ID (Lote).
     */
    @WebMethod(operationName = "sugerirSustitutos")
    public String sugerirSustitutos(@WebParam(name = "id_prod_original") int id_prod, 
                                    @WebParam(name = "cantidad_requerida") int cantidad) {
        
        Product original = productFacade.find(id_prod);
        if (original == null) return "Producto original no encontrado.";

        try {
            // Consulta JPQL Dinámica
            // Busca productos con: Mismo Grosor, Misma Fibra, ID diferente, Stock suficiente
            String jpql = "SELECT p FROM Product p WHERE p.grosor = :grosor AND p.fibra = :fibra " +
                          "AND p.id <> :origId AND p.existencia >= :cant";
            
            Query q = em.createQuery(jpql);
            q.setParameter("grosor", original.getGrosor());
            q.setParameter("fibra", original.getFibra());
            q.setParameter("origId", original.getId());
            q.setParameter("cant", cantidad);
            
            List<Product> sustitutos = q.getResultList();
            
            StringBuilder sb = new StringBuilder();
            sb.append("STOCK INSUFICIENTE para: ").append(original.getName())
              .append(" (Lote: ").append(original.getLote()).append(").\n");
            
            if (sustitutos.isEmpty()) {
                sb.append("AVISO: No se encontraron sustitutos exactos (Mismo Grosor/Fibra) con stock suficiente.");
            } else {
                sb.append("SUGERENCIAS DISPONIBLES:\n");
                for (Product p : sustitutos) {
                    sb.append("- ID: ").append(p.getId())
                      .append(" | ").append(p.getName())
                      .append(" | Lote: ").append(p.getLote())
                      .append(" | Precio: $").append(p.getPrice())
                      .append(" | Stock: ").append(p.getExistencia()).append("\n");
                }
            }
            return sb.toString();
            
        } catch (Exception e) {
            return "Error buscando sustitutos: " + e.getMessage();
        }
    }

    // =========================================================================
    //         Restitución de productos al cancelarse un pedido (desde BPEL)
    // =========================================================================
    @WebMethod(operationName = "restituyeProductosCO")
    public String restituyeProductosCO(@WebParam(name="id_CO") int id_CO)
    {
      String strRes = "";
      CustomerOrder co = customerOrderFacade.find(id_CO);
      Product prod;
      if(co != null)
      {
        List<OrderedProduct> items = (List<OrderedProduct>) co.getOrderedProductList();
        strRes += "Restituyendo " + items.size()+ " items...\n";
        for( entidades.OrderedProduct op : items )
        {
            prod = productFacade.find(op.getProduct().getId());
            productFacade.agregaExistencia(prod.getId(), op.getQuantity());
            strRes += "ID: " + prod.getId() + " - Regresados: " + op.getQuantity() + "\n";
        }
        strRes += "Monto cancelado: " + co.getAmount();
      }
      return strRes;
    }

    // =========================================================================
    //             Para obtener el monto de un Customer Order
    // =========================================================================
    @WebMethod(operationName = "montoCO")
    public double montoCO(@WebParam(name="id_CO") int id_CO)
    {
      CustomerOrder co = customerOrderFacade.find(id_CO);
      return (co != null) ? co.getAmount().doubleValue() : 0.0;
    }

    // =========================================================================
    //             Catálogos (Utilizados por Cliente o BPEL)
    // =========================================================================
    @WebMethod(operationName = "catalogoCltes")
    public List<entidades.Customer> catalogoCltes() 
    {
        return customerFacade.findAll();
    }

    @WebMethod(operationName = "catalogoProds")
    public List<entidades.Product> catalogoProds() 
    {   
        return productFacade.findAll();
    }
}