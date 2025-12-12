/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws_solicita_autorizacion;

/**
 *
 * @author rafael
 */
public class Excepcion_Negocio extends Exception
{
    private String msg;
    public Excepcion_Negocio(String mensaje)
    {
        this.msg = mensaje;
    }
    
    public String getMsg()
    {
        return this.msg;
    }
    
    public String toString()
    {
       return "Excepción de negocio:" + this.msg; 
    }
}
