/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial_02_pojo_1;

import java.util.logging.Level;
import java.util.logging.Logger;
import ws_solicita_autorizacion.ExcepcionNegocio;
import ws_solicita_autorizacion.ExcepcionNegocio_Exception;

/**
 *
 * @author rgamb
 * Modificado para prueba 2.2
 */
public class Parcial_02_POJO_Sol implements interfazdesacoplada.InterfazDesacoplada {

    long quienSoy;
    String host = null;

    java.util.List<ws_solicita_autorizacion.Cliente> listaCltes = new java.util.ArrayList<>();
    java.util.List<ws_solicita_autorizacion.Proveedor> listaProvs = new java.util.ArrayList<>();

    int num_cltes;
    int num_provs;

    @Override
    public void prepara(long quienSoy) {
        this.quienSoy = quienSoy;

        listaCltes = catalogoClientes();
        listaProvs = catalogoProveedores();
        num_cltes = listaCltes.size();
        num_provs = listaProvs.size();
    }

    @Override
    public long solicitaServicio(int vez) {
        long t0, t1, dt = 0;
        
        // Usar clientes y proveedores de forma secuencial
        int idClte = listaCltes.get((vez - 1) % num_cltes).getId();
        int idProv = listaProvs.get(0).getId();

        double monto;

        // Lógica de prueba solicitada:
        // 5 clientes con cantidades OK
        // 5 con cantidades que no proceden
        
        if (vez <= 5) {
            monto = 5000.0; // OK: Menor al monto_max (10,000)
        } else {
            monto = 20000.0; // ERROR: Mayor al monto_max (10,000)
        }

        int num_aut = -1;
        t0 = System.currentTimeMillis();
        try {
            System.out.println("Solicitando -> Vez: " + vez + " | Monto: " + monto + " (Esperado: " + (vez<=5 ? "OK" : "Error") + ")");
            
            num_aut = solicitaAutorizacion(idClte, idProv, monto);

            t1 = System.currentTimeMillis();
            dt = t1 - t0;

            System.out.println("EXITO: ObjetoDeServicio " + this.quienSoy + " vez:" + vez +
                    " idClte:" + idClte + ", idProv:" + idProv +
                    " Monto:" + monto + " num Autorización:" + num_aut +
                    " deltaT:" + dt);
        } catch (ExcepcionNegocio_Exception ex) {
            t1 = System.currentTimeMillis();
            dt = t1 - t0;
            System.out.println("FALLO CONTROLADO (ExcepcionNegocio): Para el cliente " + idClte + " con monto " + monto + ": " + ex.getLocalizedMessage());
        }

        return dt;
    }

    @Override
    public void cierra() {
        System.out.println("Objeto de servicio " + this.quienSoy + " terminando hilo de carga.");
    }

    public static void main(String[] args) {
        long quienEres = 25;
        // Ejecutar 10 veces (5 OK, 5 Error)
        int VECES = 10;
        
        interfazdesacoplada.InterfazDesacoplada objServ = new Parcial_02_POJO_Sol();
        objServ.prepara(quienEres);

        for (int vez = 1; vez <= VECES; vez++) {
            objServ.solicitaServicio(vez);
             try { Thread.sleep(200); } catch (Exception e) {}
        }

        objServ.cierra();
    }

    // Métodos utilitarios WS (Sin cambios)
    private static java.util.List<ws_solicita_autorizacion.Cliente> catalogoClientes() {
        ws_solicita_autorizacion.WSSolicitaAutorizacion_Service service = new ws_solicita_autorizacion.WSSolicitaAutorizacion_Service();
        ws_solicita_autorizacion.WSSolicitaAutorizacion port = service.getWSSolicitaAutorizacionPort();
        return port.catalogoClientes();
    }

    private static java.util.List<ws_solicita_autorizacion.Proveedor> catalogoProveedores() {
        ws_solicita_autorizacion.WSSolicitaAutorizacion_Service service = new ws_solicita_autorizacion.WSSolicitaAutorizacion_Service();
        ws_solicita_autorizacion.WSSolicitaAutorizacion port = service.getWSSolicitaAutorizacionPort();
        return port.catalogoProveedores();
    }

    private static int solicitaAutorizacion(int idClte, int idProv, double dblMonto) throws ExcepcionNegocio_Exception {
        ws_solicita_autorizacion.WSSolicitaAutorizacion_Service service = new ws_solicita_autorizacion.WSSolicitaAutorizacion_Service();
        ws_solicita_autorizacion.WSSolicitaAutorizacion port = service.getWSSolicitaAutorizacionPort();
        return port.solicitaAutorizacion(idClte, idProv, dblMonto);
    }
}