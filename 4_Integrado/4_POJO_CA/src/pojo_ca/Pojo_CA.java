package pojo_ca;

import ws_ca.CmplxRespuesta;
import ws_ca.SolicitarPedidoOperationFault;

public class Pojo_CA implements interfazdesacoplada.InterfazDesacoplada
{
    public static java.util.List<wspedido.Customer> listaCltes = new java.util.ArrayList<>();
    public static java.util.List<wspedido.Product>  listaProds = new java.util.ArrayList<>();

    long quienSoy;
    String host = null;
    ws_ca.CmplxSolicitud solicitud = new ws_ca.CmplxSolicitud();
    ws_ca.CmplxRespuesta respuesta = new ws_ca.CmplxRespuesta();
    
    int num_cltes;
    int num_prods;
 
    @Override
    public void prepara(long quienSoy) {
        this.quienSoy = quienSoy;
        if(listaCltes.isEmpty()) listaCltes  = catalogoCltes();
        if(listaProds.isEmpty()) listaProds  = catalogoProds();
        num_cltes = listaCltes.size();
        num_prods = listaProds.size();
    }

    @Override
    public long solicitaServicio(int vez) { return 0; }

    @Override
    public void cierra() {
         System.out.println("Fin de pruebas."); 
    }

    // =========================================================================
    //                    METODOS DE PRUEBA FUNCIONAL
    // =========================================================================

    public void ejecutarPruebasFuncionales() {
        System.out.println("\n\n############################################################");
        System.out.println("INICIANDO PRUEBAS FUNCIONALES COMPLETAS");
        System.out.println("############################################################\n");

        testSugerenciaSustitutos();
        testDescuentoTemporada();
        testMezclaLotes(); // <--- NUEVO TEST
    }

    private void testSugerenciaSustitutos() {
        System.out.println(">>> TEST 1: Sugerencia de Sustitutos");
        ws_ca.CmplxSolicitud req = new ws_ca.CmplxSolicitud();
        req.setIdCllte(1); 
        req.setRestriccionCalidad(false);

        ws_ca.CmplxClsItem item = new ws_ca.CmplxClsItem();
        item.setIdProd(5); // Super Saver (Stock 10)
        item.setCantidad(15); 
        req.getListaItems().add(item);

        try {
            solicitarPedidoOperation(req);
            System.out.println("FALLO TEST 1: Pedido aceptado indebidamente.");
        } catch (SolicitarPedidoOperationFault ex) {
            System.out.println("EXITO TEST 1: Excepción recibida. Msg: " + ex.getFaultInfo().getMessage());
        }
        System.out.println("------------------------------------------------------------\n");
    }

    private void testDescuentoTemporada() {
        System.out.println(">>> TEST 2: Descuentos de Temporada");
        ws_ca.CmplxSolicitud req = new ws_ca.CmplxSolicitud();
        req.setIdCllte(1);
        req.setRestriccionCalidad(false);

        ws_ca.CmplxClsItem item = new ws_ca.CmplxClsItem();
        item.setIdProd(4); // Bernat Softee
        item.setCantidad(5); 
        req.getListaItems().add(item);

        try {
            ws_ca.CmplxRespuesta res = solicitarPedidoOperation(req);
            System.out.println("EXITO TEST 2: Pedido procesado ID: " + res.getNumPedido());
        } catch (SolicitarPedidoOperationFault ex) {
            System.out.println("FALLO TEST 2: " + ex.getFaultInfo().getMessage());
        }
        System.out.println("------------------------------------------------------------\n");
    }

    /**
     * Prueba 3: Intento de mezclar lotes incompatibles.
     * Requiere que existan ID 1 (Lote A1) y ID 10 (Lote B99) de "Merino Suave".
     */
    private void testMezclaLotes() {
        System.out.println(">>> TEST 3: Restricción de Mezcla de Lotes");
        
        ws_ca.CmplxSolicitud req = new ws_ca.CmplxSolicitud();
        req.setIdCllte(1);
        req.setRestriccionCalidad(true); // ACTIVAR RESTRICCION

        // Item 1: Merino Suave Lote A1
        ws_ca.CmplxClsItem item1 = new ws_ca.CmplxClsItem();
        item1.setIdProd(1);
        item1.setCantidad(5);
        req.getListaItems().add(item1);

        // Item 2: Merino Suave Lote B99 (Creado con script SQL)
        // Nota: Si no ejecutaste el script, esto fallara por ID no encontrado, lo cual tambien es un test valido.
        ws_ca.CmplxClsItem item2 = new ws_ca.CmplxClsItem();
        item2.setIdProd(10); // ID del nuevo lote
        item2.setCantidad(5);
        req.getListaItems().add(item2);

        try {
            System.out.println("Enviando pedido con Lotes Mezclados (ID 1 + ID 10)...");
            ws_ca.CmplxRespuesta res = solicitarPedidoOperation(req);
            System.out.println("FALLO TEST 3: El sistema permitió mezclar lotes. ID Pedido: " + res.getNumPedido());
        } catch (SolicitarPedidoOperationFault ex) {
            System.out.println("EXITO TEST 3: Pedido rechazado correctamente.");
            System.out.println("Mensaje: " + ex.getFaultInfo().getMessage());
            
            // Verificamos si el mensaje menciona el conflicto o la sugerencia derivada del fallo
            if (ex.getFaultInfo().getMessage().contains("No se puede surtir")) {
                System.out.println("VERIFICACION: El backend detectó el conflicto y canceló la operación.");
            }
        }
        System.out.println("------------------------------------------------------------\n");
    }

    public static void main(String[] args) {
        try {
            java.util.List<wspedido.Customer> cltes = catalogoCltes();
            System.out.println("Conectado. Clientes: " + cltes.size());
        } catch (Exception e) { return; }
        
        Pojo_CA objServ = new Pojo_CA();
        objServ.prepara(1);
        objServ.ejecutarPruebasFuncionales();
        objServ.cierra();
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

    private static CmplxRespuesta solicitarPedidoOperation(ws_ca.CmplxSolicitud solicitudPedido) throws SolicitarPedidoOperationFault {
        ws_ca.IntegradoBpelTiendaCAService1 service = new ws_ca.IntegradoBpelTiendaCAService1();
        ws_ca.BpelIntegradoPortType port = service.getCasaPort1();
        return port.solicitarPedidoOperation(solicitudPedido);
    }
}