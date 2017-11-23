/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ValueChangeEvent;
import jpa.entities.Usuario;


/**
 *
 * @author andim
 */
@Named(value = "chat")
@RequestScoped
public class ChatController {
    private ConexionSQL con = new ConexionSQL(); //CONEXION A LA BASE
    private Usuario user= new Usuario(); //USUARIO ACTIVO
    private Usuario destinatario= new Usuario(); //USUARIO DESTINO
    private String destino = "--"; //VALUE DE SELECTONEMENU
    private String destino2 = "--"; //VALUE 
    private String conversacion = ""; //CONVERSACION A MOSTRAR
    private String nvomsj = ""; //NUEVO MENSAJE A ENVIAR
    private int id_conv;
    
    public ChatController() {
        user.setId(1); //CAMBIAR AL INTEGRAR PROYECTO
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Usuario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Usuario destinatario) {
        this.destinatario = destinatario;
    }
    
    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDestino2() {
        return destino2;
    }

    public void setDestino2(String destino2) {
        this.destino2 = destino2;
    }

    public String getConversacion() {
        return conversacion;
    }

    public void setConversacion(String conversacion) {
        this.conversacion = conversacion;
    }

    public String getNvomsj() {
        return nvomsj;
    }

    public void setNvomsj(String nvomsj) {
        this.nvomsj = nvomsj;
    }
    
    
    /**
     * MUESTRA LOS USUARIOS DEL COMBOX
     * @return ARREGLO DE CONSULTA 
     */
    public Map<String,String> getCountryInMap(){ 
        
        Map<String,String> destinatarios = new LinkedHashMap<String,String>();
        Connection con1 = con.Conectar();
        String label, value;
       
 try{
      
           PreparedStatement ps = con1.prepareStatement("Select usuarios.nombre, usuarios.id_persona from usuarios inner join conversacion on conversacion.id_destinatario = usuarios.id_persona and conversacion.id_remitente = "+ user.getId() );
    
           ResultSet rs = ps.executeQuery();
            while(rs.next()){
                label = rs.getString("nombre");
                value = rs.getString("id_persona");
                destinatarios.put(label, value);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChatController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
  
        return destinatarios;
     }
    
    /**
     * FUNCION QUE ES LLAMA AL SELECCIONAR OTRO USUARIO PARA CONVERSAR 
     * @param e VALOR SELECCIONADO DEL COMBOX
     */
         public void ConversacionChanged(ValueChangeEvent e){
		//assign new value to localeCode
                
                String contacto = e.getNewValue().toString();
                String aux = "";
                Connection con1 = con.Conectar();
                 try{
             PreparedStatement ps = con1.prepareStatement("select id_conversacion from conversacion where id_destinatario = " + contacto + " and id_remitente = "+ user.getId());
           ResultSet rs = ps.executeQuery();
            while(rs.next()){
                id_conv = rs.getInt("id_conversacion");
            }         
            
            ps = con1.prepareStatement("Select mensaje from mensaje inner join conversacion on conversacion.id_destinatario = " + contacto + " and conversacion.id_remitente = "+ user.getId() + " and conversacion.id_conversacion = mensaje.id_conversacion");
            rs = ps.executeQuery();
           
            while(rs.next()){
                aux = aux + "<br/>"+ rs.getString("mensaje") ;
            }  
        } catch (SQLException ex) {
            Logger.getLogger(ChatController.class.getName()).log(Level.SEVERE, null, ex);
        } 
                setConversacion(aux);
	}
    
         
        /**
         * FUNCION QUE INSERTA MENSAJE EN LA BASE
         */
         public void mostrar(){
            Connection con1 = con.Conectar();
            PreparedStatement ps; 
            
        try {
            ps = con1.prepareStatement("insert into mensaje (id_conversacion, mensaje) values ( " + id_conv + ",'" + nvomsj + "')");
            ps.executeUpdate();
            nvomsj = "";
            
        } catch (SQLException ex) {
            Logger.getLogger(ChatController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
         }
         
       
         

    
}
