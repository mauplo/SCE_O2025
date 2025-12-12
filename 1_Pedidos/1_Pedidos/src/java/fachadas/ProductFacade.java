/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fachadas;

import entidades.Product;
import java.util.HashSet;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rafael
 */
@Stateless
public class ProductFacade extends AbstractFacade<Product> {

    @PersistenceContext(unitName = "WS_Parcial_02PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductFacade() {
        super(Product.class);
    }
   
    public int actualizaExistencia(int id_prod,int cant_solicitada)
    {
       int cant_posible = 0;
       int cant_existente;
       //Product prod   = this.find(new Integer(id_prod));
       //em.getTransaction().begin();
       Product prod   = em.find(Product.class, new Integer(id_prod), LockModeType.PESSIMISTIC_WRITE);
       if(prod == null)
       {
         cant_posible = 0;   
       }
       else
       {
         cant_existente = prod.getExistencia();
         cant_posible   = cant_solicitada < cant_existente ? cant_solicitada : cant_existente;
         cant_existente -= cant_posible;
         prod.setExistencia(cant_existente);
         this.edit(prod);
       }
       //em.getTransaction().commit();
       prod = null;
        return cant_posible;
    }
    
    public int agregaExistencia(int id_prod,int cant_a_agregar)
    {
       int cant_existente = 0;
       //Product prod   = this.find(new Integer(id_prod));
       //em.getTransaction().begin();
       Product prod   = em.find(Product.class, new Integer(id_prod), LockModeType.PESSIMISTIC_WRITE);
       if(prod != null)
       {
         cant_existente = prod.getExistencia();
         cant_existente += cant_a_agregar;
         prod.setExistencia(cant_existente);
         this.edit(prod);
       }
       //em.getTransaction().commit();
       prod = null;
        return cant_existente;
    }

    
}
