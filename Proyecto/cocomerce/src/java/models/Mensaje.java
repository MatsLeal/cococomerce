package models;
// Generated Nov 13, 2017 1:54:06 PM by Hibernate Tools 4.3.1



/**
 * Mensaje generated by hbm2java
 */
public class Mensaje  implements java.io.Serializable {


     private Integer idMensaje;
     private int idDonante;
     private int idSolicitante;
     private String mensaje;

    public Mensaje() {
    }

    public Mensaje(int idDonante, int idSolicitante, String mensaje) {
       this.idDonante = idDonante;
       this.idSolicitante = idSolicitante;
       this.mensaje = mensaje;
    }
   
    public Integer getIdMensaje() {
        return this.idMensaje;
    }
    
    public void setIdMensaje(Integer idMensaje) {
        this.idMensaje = idMensaje;
    }
    public int getIdDonante() {
        return this.idDonante;
    }
    
    public void setIdDonante(int idDonante) {
        this.idDonante = idDonante;
    }
    public int getIdSolicitante() {
        return this.idSolicitante;
    }
    
    public void setIdSolicitante(int idSolicitante) {
        this.idSolicitante = idSolicitante;
    }
    public String getMensaje() {
        return this.mensaje;
    }
    
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }




}


