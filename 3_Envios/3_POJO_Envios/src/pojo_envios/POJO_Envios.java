/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo_envios;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafael / rgamb
 * Modificado para prueba 2.3
 */
public class POJO_Envios implements interfazdesacoplada.InterfazDesacoplada {

    long quienSoy;
    int NUM_CLTES_SIMULADOS = 4; // Tenemos 4 clientes en la BD

    @Override
    public void prepara(long quienSoy) {
        this.quienSoy = quienSoy;
    }

    @Override
    public long solicitaServicio(int vez) {
        long t0, t1, dt = 0;
        int num_envio;
        
        // Datos controlados para probar 10 casos distintos
        int idClte = (vez % NUM_CLTES_SIMULADOS) + 1; // Rota entre cliente 1 y 4
        int num_pedido = 5000 + vez; // Pedidos 5001, 5002, ...
        int num_dias = (vez % 5) + 3; // Dias variables entre 3 y 7

        t0 = System.currentTimeMillis();

        num_envio = altaEnvio(idClte, num_pedido, num_dias);

        t1 = System.currentTimeMillis();

        dt = t1 - t0;

        System.out.println("ObjetoDeServicio " + this.quienSoy + " vez:" + vez +
                " idClte:" + idClte + ", num_pedido:" + num_pedido +
                " num_dias:" + num_dias + ", num_envio:" + num_envio +
                " deltaT:" + dt);

        return dt;
    }

    @Override
    public void cierra() {
        System.out.println("Objeto de servicio " + this.quienSoy + " terminando hilo de carga.");
    }

    public static void main(String[] args) {
        long quienEres = 25;
        // Solicitud explícita: 10 casos
        int VECES = 10;
        
        interfazdesacoplada.InterfazDesacoplada objServ = new POJO_Envios();
        objServ.prepara(quienEres);

        for (int vez = 1; vez <= VECES; vez++) {
            objServ.solicitaServicio(vez);
             try { Thread.sleep(100); } catch (Exception e) {}
        }

        objServ.cierra();
    }

    private static int altaEnvio(int idClte, int numPedido, int numDias) {
        ws_envios.WSEnvios_Service service = new ws_envios.WSEnvios_Service();
        ws_envios.WSEnvios port = service.getWSEnviosPort();
        return port.altaEnvio(idClte, numPedido, numDias);
    }
}