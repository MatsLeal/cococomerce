/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author andim
 */
public class ConexionSQL {
    public String url = "jdbc:mysql://localhost/coquito"; //MODIFICAR DEPENDIENDO DEL NOMBRE DE LA BASE
    public String user = "root";
    public String pass = "";
    
    private java.sql.Connection con;
    
    public ConexionSQL() {
    }
    
    public java.sql.Connection Conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
               con= DriverManager.getConnection("jdbc:mysql://localhost/cocomarket", "root", "123456");
            } catch (SQLException e) {
                
            }
        } catch (ClassNotFoundException e) {
            
        }
        
        return con;
    }
    
  
            
}
