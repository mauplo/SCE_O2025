/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fachadas;

import entidades.Operacion;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rafael
 */
@Stateless
public class OperacionFacade extends AbstractFacade<Operacion> {

    @PersistenceContext(unitName = "Parcial_202503_02PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OperacionFacade() {
        super(Operacion.class);
    }
    
    // ===========================================================================================
    public int next_autorization_number() {
        int intRes = (int) em.createNativeQuery("VALUES (NEXT VALUE FOR NUM_AUTORIZACION)").getSingleResult();
        Logger.getAnonymousLogger().log(Level.SEVERE, "El valor del número de autorización es:" + intRes);
        return intRes;
    }
    // ===========================================================================================

    
}
