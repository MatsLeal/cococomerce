/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.ProductoPedido;

/**
 *
 * @author admin
 */
@Stateless
public class ProductoPedidoFacade extends AbstractFacade<ProductoPedido> {

    
    
    
    @PersistenceContext(unitName = "cococomercePU")
    private EntityManager em;
    
    
    
    public EntityManager getEm(){
        return em;
    }
    

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoPedidoFacade() {
        super(ProductoPedido.class);
    }
    
}
