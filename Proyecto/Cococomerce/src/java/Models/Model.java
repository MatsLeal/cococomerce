/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Omar Silva
 */
public class Model {
     private String url="jdbc://mysql://localhost:3306/Gluck";
     private String user="root";
     private String password="";
     public Connection conn;
    
     public PreparedStatement stmt=null;
     public ResultSet rs=null;
     public String query;
     public void conectar() throws SQLException{
        conn = DriverManager.getConnection(url,user,password);
        System.out.println("Conectado con exito");
    }
}
