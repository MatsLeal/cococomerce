package Controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Alain
 */
public class Consultas extends Conexion{
    public boolean autentificacion(String usuario, String contrasena){
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta ="select * from usuarios where usuario = ? and pass = ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, usuario);
            pst.setString(2, contrasena);
            rs = pst.executeQuery();
            if(rs.absolute(1)){
                return true;
            }
        } catch (Exception e) {
            System.err.println("ERROR:"+e);
        }finally{
            try {
                if(getConexion() != null) getConexion().close();
                if(pst != null) pst.close();
                if(rs != null) rs.close();
            } catch (Exception e) {
                System.err.println("ERROR:"+e);
            }
        }
        return false;
    }
    
    /*public static void main(String[] args){
        Consultas co = new Consultas();
        System.out.println(co.autentificacion("hola", "1548"));//prueba
    }*/
    
    public boolean registrar(String nombre, String apellido, String usuario, String contrasena){
        PreparedStatement pst = null;
        try {
            String consulta ="insert into usuarios (nombre, apellido, usuario, pass) values (?,?,?,?)";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, nombre);
            pst.setString(2, apellido);
            pst.setString(3, usuario);
            pst.setString(4, contrasena);
            if (pst.executeUpdate() == 1){
                return true;
            }
        } catch (Exception e) {
            System.err.println("ERROR:"+e);
        }finally{
            try {
                if(getConexion() != null) getConexion().close();
                if(pst != null) pst.close();
            } catch (Exception e) {
                System.err.println("ERROR:"+e);
            }
        }
        return false;
    }
    
    /*public static void main(String[] args){
        Consultas co = new Consultas();
        System.out.println(co.registrar("Juan", "Hernandez", "juanhernandez", "1234"));//prueba
    }*/
}

