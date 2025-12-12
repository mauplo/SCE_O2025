/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws_solicita_autorizacion;

import fachadas.ClienteFacade;
import fachadas.OperacionFacade;
import fachadas.ProveedorFacade;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.LockModeType;

/**
 *
 * @author rafael
 */
@WebService(serviceName = "WS_Solicita_Autorizacion")
public class WS_Solicita_Autorizacion {

    @EJB
    private ClienteFacade ejbClte;
    
    @EJB
    private ProveedorFacade ejbProv;
    
    @EJB
    private OperacionFacade ejbOper;
    
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaAutorizacion")
    public int solicitaAutorizacion(@WebParam(name = "idClte") int idClte, @WebParam(name = "idProv") int idProv, @WebParam(name = "dblMonto") double dblMonto) throws Excepcion_Negocio {
        
        dblMonto = 0.5 * Math.floor(dblMonto / 0.5 );
        
        int autorizacion    = 0;
        entidades.Cliente   clte;
        entidades.Proveedor prov;
        entidades.Operacion oper;
        
        //clte= ejbClte.find(new Integer(idClte));
        clte = ejbClte.bloquea(idClte);
        
        if(clte == null)
            //return autorizacion;
            throw new Excepcion_Negocio("El cliente con id " + idClte + " No EXISTE");
        
        prov = ejbProv.find(idProv);
        
        if(prov == null)
            //return autorizacion;
            throw new Excepcion_Negocio("El proveedor con id " + idProv + " No EXISTE");
        
        if(dblMonto <= 0.0)
            //return autorizacion;
            throw new Excepcion_Negocio("Se ha solicitado monto menor a 0.5");
        
        BigDecimal monto_solicitado = new BigDecimal(dblMonto);
        
        if( clte.getMontoMax().compareTo(monto_solicitado) == -1)
            //return autorizacion;
            throw new Excepcion_Negocio("El monto solicitado " + dblMonto + " es mayor que el máximo permitido");
        
        BigDecimal monto_disponible = clte.getMontoDisponible(); 
        
        if( monto_disponible.multiply(new BigDecimal(1.05)).compareTo(monto_solicitado) == -1 )
            //return autorizacion;
            throw new Excepcion_Negocio("El monto solicitado " + dblMonto + " sobrepassa el monto disponible "  );
        
        BigDecimal monto_utilizado = clte.getMontoUtilizado();
         
        clte.setMontoDisponible(monto_disponible.subtract(monto_solicitado));
        clte.setMontoUtilizado(monto_utilizado.add(monto_solicitado));
        
        ejbClte.edit(clte);
        
        autorizacion = ejbOper.next_autorization_number(); //(int)(100.0 + 5000.0 * Math.random());
        
        oper = new entidades.Operacion();
        
        java.util.Date d = new java.util.Date();
        
        oper.setIdCliente(clte);
        oper.setIdProveedor(prov);
        oper.setMonto(monto_solicitado);
        oper.setStatusOp("A");
        oper.setFechaOp(d);
        oper.setAutorizacion(autorizacion);
        
        ejbOper.create(oper);
        
        return autorizacion;
    }

    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "catalogoClientes")
    public java.util.List<entidades.Cliente> catalogoClientes() {
       
        return ejbClte.findAll();
    }
    
    @WebMethod(operationName = "catalogoProveedores")
    public java.util.List<entidades.Proveedor> catalogoProveedores() {
       
        return ejbProv.findAll();
    }
    
}
