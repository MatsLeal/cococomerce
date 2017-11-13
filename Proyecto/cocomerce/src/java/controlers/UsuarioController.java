/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import dao.UsuarioDAO;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import models.Usuario;

/**
 *
 * @author admin
 */

@Named("usuarioController")
@RequestScoped
public class UsuarioController {
    
    private Usuario user= new Usuario();

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
    
    
    public String login(){
        
        UsuarioDAO userDAO= new UsuarioDAO();
        
        Usuario user;
        
        try{
            user = userDAO.login(this.user);
            
            if(user!=null){
                FacesContext.getCurrentInstance().getExternalContext()
                        .getSessionMap().put("usuario", user);
                return "home";
            }
            
        }
        catch(Exception e){
            throw e;
        }
        
        return "index";
    }
    
}
