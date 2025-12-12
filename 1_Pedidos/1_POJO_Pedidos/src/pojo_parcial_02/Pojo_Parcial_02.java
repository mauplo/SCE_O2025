/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo_parcial_02;

/**
 *
 * @author rafael
 * Modificado para prueba 2.1: 3 OK, 3 Error Clte, 1 Error Stock
 */
public class Pojo_Parcial_02 implements interfazdesacoplada.InterfazDesacoplada {

    long quienSoy;
    String host = null;

    java.util.List<wspedido.Customer> listaCltes = new java.util.ArrayList<>();
    java.util.List<wspedido.Product> listaProds = new java.util.ArrayList<>();

    int num_cltes;
    int num_prods;

    @Override
    public void prepara(long quienSoy) {
        this.quienSoy = quienSoy;
        this.host = host;

        listaCltes = catalogoCltes();
        listaProds = catalogoProds();
        num_cltes = listaCltes.size();
        num_prods = listaProds.size();
    }

    @Override
    public long solicitaServicio(int vez) {
        java.util.List<wspedido.ClsItem> listaIt = new java.util.ArrayList<>();
        long t0, t1, deltaT;
        int num_pedido;
        int id_clte;
        
        // Variables para la lógica de prueba
        int id_prod, cantidad;
        wspedido.ClsItem item;
        
        // --- LOGICA DE PRUEBA ESPECIFICA 2.1 ---
        
        if (vez <= 3) {
            // [CASO 1-3]: Pedidos OK
            // Tomamos un cliente válido de la lista
            int queClte = (vez - 1) % num_cltes; 
            id_clte = listaCltes.get(queClte).getId();
            cantidad = 10;
            System.out.println(">>> CASO OK (Vez " + vez + "): Cliente Válido, Cantidad Válida");
            
        } else if (vez <= 6) {
            // [CASO 4-6]: Pedidos rechazados por Cliente Inexistente
            // Forzamos un ID que no existe en la BD (ej. 99999)
            id_clte = 99999; 
            cantidad = 10;
            System.out.println(">>> CASO FALLO CLIENTE (Vez " + vez + "): Se envía ID Cliente " + id_clte + " (No existe)");
            
        } else {
            // [CASO 7]: Pedido rechazado por Inventario Insuficiente
            // Cliente válido, pero cantidad excesiva (2000 > 1000 stock)
            id_clte = listaCltes.get(0).getId();
            cantidad = 1100; 
            System.out.println(">>> CASO FALLO STOCK (Vez " + vez + "): Cantidad " + cantidad + " excede inventario");
        }

        // Siempre usamos el primer producto (id 1) para controlar el stock
        // Asumiendo que el producto 0 en la lista es el que reseteamos en SQL
        id_prod = listaProds.get(0).getId(); 

        item = new wspedido.ClsItem();
        item.setIdProd(id_prod);
        item.setCantidad(cantidad);
        listaIt.add(item);

        System.out.println("-----------------------------------------------");
        System.out.println("Estresador:" + this.quienSoy + ", vez:" + vez + ", Clte:" + id_clte);
        System.out.println("Solicitando Producto ID: " + id_prod + " con Cantidad: " + cantidad);
        System.out.println("-----------------------------------------------");

        //
        //   Se solicita registrar el pedido en el WS
        //
        t0 = System.currentTimeMillis();
        
        // La llamada al WS puede devolver -1 o 0 si falla, o lanzar excepción dependiendo de la implementación
        try {
            num_pedido = altaPedido(id_clte, listaIt);
        } catch (Exception e) {
            System.out.println("Excepción al llamar al WS: " + e.getMessage());
            num_pedido = -1;
        }
        
        t1 = System.currentTimeMillis();
        deltaT = t1 - t0;

        System.out.println("El número de pedido devuelto es: " + num_pedido);
        
        if(num_pedido <= 0) {
             System.out.println("RESULTADO: PEDIDO RECHAZADO / NO PROCESADO (Correcto para casos 4-7)");
        } else {
             System.out.println("RESULTADO: PEDIDO EXITOSO ID: " + num_pedido);
        }
        System.out.println("===============================================");

        return deltaT;
    }

    @Override
    public void cierra() {
        System.out.println("El thread de stress " + this.quienSoy + " ha terminado su trabajo");
    }

    // =========================================================================
    //                    main para probar el pojo  
    // =========================================================================
    public static void main(String[] args) {
        Pojo_Parcial_02 objServ = new Pojo_Parcial_02();

        objServ.prepara(25);
        
        // Ejecutar exactamente 7 veces
        int n_veces = 7; 
        
        for (int vez = 1; vez <= n_veces; vez++) {
            objServ.solicitaServicio(vez);
            try { Thread.sleep(500); } catch (Exception e) {} 
        }
        objServ.cierra();

    }
    // =========================================================================
    //                    Utilerías del WS 
    // =========================================================================
    private static int altaPedido(int idClte, java.util.List<wspedido.ClsItem> listaIt) {
        wspedido.WSPedido_Service service = new wspedido.WSPedido_Service();
        wspedido.WSPedido port = service.getWSPedidoPort();
        return port.altaPedido(idClte, listaIt);
    }

    private static java.util.List<wspedido.Customer> catalogoCltes() {
        wspedido.WSPedido_Service service = new wspedido.WSPedido_Service();
        wspedido.WSPedido port = service.getWSPedidoPort();
        return port.catalogoCltes();
    }

    private static java.util.List<wspedido.Product> catalogoProds() {
        wspedido.WSPedido_Service service = new wspedido.WSPedido_Service();
        wspedido.WSPedido port = service.getWSPedidoPort();
        return port.catalogoProds();
    }
}