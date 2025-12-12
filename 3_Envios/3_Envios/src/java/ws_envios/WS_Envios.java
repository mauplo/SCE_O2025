/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws_envios;

import entidades.Envio;
import fachadas.EnvioFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author rafael
 */
@WebService(serviceName = "WS_Envios")
public class WS_Envios {

    @EJB
    private EnvioFacade ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "create")
    @Oneway
    public void create(@WebParam(name = "entity") Envio entity) {
        ejbRef.create(entity);
    }

    @WebMethod(operationName = "edit")
    @Oneway
    public void edit(@WebParam(name = "entity") Envio entity) {
        ejbRef.edit(entity);
    }

    @WebMethod(operationName = "remove")
    @Oneway
    public void remove(@WebParam(name = "entity") Envio entity) {
        ejbRef.remove(entity);
    }

    @WebMethod(operationName = "find")
    public Envio find(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAll")
    public List<Envio> findAll() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRange")
    public List<Envio> findRange(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "count")
    public int count() {
        return ejbRef.count();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "alta_envio")
    public int alta_envio(@WebParam(name = "id_clte") int id_clte, @WebParam(name = "num_pedido") int num_pedido, @WebParam(name = "num_dias") int num_dias) {
       
        int num_envio;
        
        java.sql.Date fr = java.sql.Date.valueOf(java.time.LocalDate.now());
        java.sql.Date fe = java.sql.Date.valueOf(java.time.LocalDate.now().plusDays(num_dias));
        
        
        entidades.Envio envio = new entidades.Envio();
        
        envio.setIdCliente(id_clte);
        envio.setNumPedido(num_pedido);
        envio.setDias(num_dias);
        envio.setStatusEnvio("P");
        envio.setFechaRegistro(fr);
        envio.setFechaEntrega(fe);
        
        
        
        ejbRef.create(envio);
        
        num_envio = envio.getId();
        
        return num_envio;
    }
    
    
    
}
