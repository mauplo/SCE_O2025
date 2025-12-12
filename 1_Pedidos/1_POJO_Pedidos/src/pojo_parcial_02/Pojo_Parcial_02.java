/*
 * Pojo_Parcial_02.java
 * Cliente de prueba automatizado para validar:
 * 1. Descuentos de temporada.
 * 2. Restricción de Lotes.
 * 3. Sugerencia de sustitutos.
 */
package pojo_parcial_02;

import java.util.ArrayList;
import java.util.List;
import wspedido.ClsItem;

public class Pojo_Parcial_02 {

    // IDs basados en 1_Proj_bd_almacen.sql
    private static final int ID_PROD_TEMPORADA = 1; // "Merino Suave" (Precio 150, Desc 0.10) 
    private static final int ID_PROD_POCO_STOCK = 5; // "Super Saver" (Stock 10) 
    private static final int ID_CLIENTE = 1; // "Harry Gomar" 

    public static void main(String[] args) {
        Pojo_Parcial_02 test = new Pojo_Parcial_02();
        test.ejecutarEscenarios();
    }

    public void ejecutarEscenarios() {
        System.out.println("==================================================");
        System.out.println("   INICIANDO PRUEBAS DE INTEGRACIÓN (WS + BPEL)");
        System.out.println("==================================================\n");

        // ---------------------------------------------------------------------
        // CASO 1: PRUEBA DE DESCUENTO
        // Producto 1 cuesta 150.00 con 10% descuento. Precio esperado: 135.00
        // ---------------------------------------------------------------------
        System.out.println(">>> CASO 1: Validación de Descuento de Temporada");
        int cantDesc = 2;
        System.out.println("    Producto ID: " + ID_PROD_TEMPORADA + ", Cantidad: " + cantDesc);
        System.out.println("    Precio Unitario Base: $150.00, Descuento: 10%");
        System.out.println("    Esperado Total: (150 * 0.90) * 2 = $270.00");
        
        int pedidoDesc = realizarPedido(ID_CLIENTE, ID_PROD_TEMPORADA, cantDesc, false);
        
        if (pedidoDesc > 0) {
            double montoReal = obtenerMonto(pedidoDesc);
            System.out.println("    [EXITO] Pedido creado ID: " + pedidoDesc);
            System.out.println("    Monto registrado en BD: $" + montoReal);
            if (Math.abs(montoReal - 270.00) < 0.01) {
                System.out.println("    [VERIFICACIÓN] EL CÁLCULO DE DESCUENTO ES CORRECTO.");
            } else {
                System.out.println("    [ERROR] El monto no coincide con el descuento esperado.");
            }
        } else {
            System.out.println("    [FALLO] No se pudo crear el pedido de prueba 1.");
        }
        System.out.println("--------------------------------------------------\n");

        // ---------------------------------------------------------------------
        // CASO 2: PRUEBA DE RESTRICCIÓN DE LOTE
        // Intentamos comprar más de lo que existe en el lote específico.
        // ID 1 tiene 500 (menos los 2 de arriba = 498). Pedimos 1000.
        // Restricción = TRUE. Debe retornar 0.
        // ---------------------------------------------------------------------
        System.out.println(">>> CASO 2: Restricción de Lote / Calidad (Debe Fallar)");
        int cantLote = 1000; 
        System.out.println("    Solicitando: " + cantLote + " unidades del ID " + ID_PROD_TEMPORADA);
        System.out.println("    Restricción de Calidad: ACTIVADA (TRUE)");
        
        int pedidoLote = realizarPedido(ID_CLIENTE, ID_PROD_TEMPORADA, cantLote, true);
        
        if (pedidoLote == 0) {
            System.out.println("    [EXITO] El sistema rechazó el pedido correctamente (Return 0).");
            System.out.println("    Razón: No existe un lote único con " + cantLote + " unidades.");
        } else {
            System.out.println("    [FALLO] El sistema permitió el pedido ID: " + pedidoLote + " indebidamente.");
        }
        System.out.println("--------------------------------------------------\n");

        // ---------------------------------------------------------------------
        // CASO 3: STOCK INSUFICIENTE Y SUGERENCIA
        // ID 5 tiene 10 de stock. Pedimos 20.
        // El sistema debe fallar el pedido y nosotros invocamos sugerencias.
        // ---------------------------------------------------------------------
        System.out.println(">>> CASO 3: Falta de Stock y Sugerencia de Sustitutos");
        int cantSinStock = 20;
        System.out.println("    Producto ID: " + ID_PROD_POCO_STOCK + " (Super Saver), Stock actual ~10");
        System.out.println("    Solicitando: " + cantSinStock);
        
        int pedidoStock = realizarPedido(ID_CLIENTE, ID_PROD_POCO_STOCK, cantSinStock, false);
        
        if (pedidoStock == 0) {
            System.out.println("    [SISTEMA] Pedido rechazado por falta de stock.");
            System.out.println("    --> Invocando servicio 'sugerirSustitutos'...");
            
            // Llamada directa al método de sugerencia (Simulando lo que haría el BPEL en el Fault)
            solicitarSugerencia(ID_PROD_POCO_STOCK, cantSinStock);
        } else {
            System.out.println("    [FALLO] Se creó el pedido ID: " + pedidoStock + " inesperadamente.");
        }
        System.out.println("==================================================");
    }

    // --- MÉTODOS AUXILIARES ---

    private int realizarPedido(int idClte, int idProd, int cantidad, boolean restriccion) {
        List<ClsItem> items = new ArrayList<>();
        ClsItem it = new ClsItem();
        it.setIdProd(idProd);
        it.setCantidad(cantidad);
        items.add(it);

        try {
            return altaPedido(idClte, items, restriccion);
        } catch (Exception e) {
            System.out.println("    [EXCEPCION] " + e.getMessage());
            return 0;
        }
    }

    private void solicitarSugerencia(int idProd, int cantidad) {
        try {
            wspedido.WSPedido_Service service = new wspedido.WSPedido_Service();
            wspedido.WSPedido port = service.getWSPedidoPort();
            String respuesta = port.sugerirSustitutos(idProd, cantidad);
            
            System.out.println("\n    +++ RESPUESTA DEL WS (SUSTITUTOS) +++");
            System.out.println(respuesta);
            System.out.println("    +++++++++++++++++++++++++++++++++++++");
        } catch (Exception e) {
            System.out.println("    Error obteniendo sugerencias: " + e.getMessage());
        }
    }
    
    // --- WRAPPERS SOAP ---
    
    private static int altaPedido(int idClte, List<ClsItem> listaIt, boolean restriccionCalidad) {
        wspedido.WSPedido_Service service = new wspedido.WSPedido_Service();
        wspedido.WSPedido port = service.getWSPedidoPort();
        return port.altaPedido(idClte, listaIt, restriccionCalidad);
    }

    private static double obtenerMonto(int idPedido) {
        wspedido.WSPedido_Service service = new wspedido.WSPedido_Service();
        wspedido.WSPedido port = service.getWSPedidoPort();
        return port.montoCO(idPedido);
    }
}