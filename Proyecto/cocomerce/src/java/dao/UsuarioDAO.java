/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import cococomerce.HibernateUtil;
import java.util.List;
import models.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class UsuarioDAO {
    
    Session session =null;

    public UsuarioDAO() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    
    public Usuario register(Usuario incoming){
        
        org.hibernate.Transaction transaction= session.beginTransaction();

        try {
         
         incoming.setId( (Integer) session.save(incoming));  
         transaction.commit();
         return incoming;
         
      } catch (HibernateException e) {
         if (transaction!=null) transaction.rollback();
         e.printStackTrace(); 
      } 
        
       return null; 
        
        
                
        
    }
    
    public List getUsers(){
        List<Usuario> usuariolist=null;
        
        try{
            
            //Maka a transaction object and contruct it
            org.hibernate.Transaction transaction= session.beginTransaction();
            
            //Create a query
            Query query = session.createQuery("from Usuario");
            
            //Make query and asing to usuariolist
            
            usuariolist=(List<Usuario>) query.list();
            
            
        }
        catch(Exception e){
            throw e;
        }
        
        return usuariolist;
    }
    
    
    public Usuario login(Usuario incoming){
        Usuario user= null;
        
        try{
            org.hibernate.Transaction transaction= session.beginTransaction();
            
            Query query= session.createQuery("from Usuario where correo='"+incoming.getCorreo()+"' and clave='"+incoming.getClave()+"'");
            
            user= (Usuario) query.uniqueResult();
        }
        catch(Exception e){
            e.printStackTrace();
        }
            
        return user;
    }
    
    
    
}
