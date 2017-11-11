/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;
import Models.Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Omar Silva
 */
public class usuario extends Model {
    public void AgregaUsuario(String id, String nombre, String apellido, String correo, String clave){
        try {
            conectar();
        } catch (SQLException ex) {
            Logger.getLogger(usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            PreparedStatement stmt;
            query="INSERT INTO usuario(id,nombre,apellido,correo,clave) VALUES("+id+","+nombre+","+apellido+","+correo+","+clave+")";
            stmt= conn.prepareStatement(query);
            stmt.execute();
            System.out.println(query);
            System.out.println("Insert realizado");
        } catch (SQLException ex) {
            Logger.getLogger(usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ResultSet Login(Connection Con,String UserName) {
        try {
            conectar();
        } catch (SQLException ex) {
            Logger.getLogger(usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            query = "SELECT * FROM usuario ";
            System.out.println(query);
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            rs =null;
            System.out.println("query no realizada");
        }
        return rs;
    }
}