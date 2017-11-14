/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "productos_bloqueados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductosBloqueados.findAll", query = "SELECT p FROM ProductosBloqueados p")
    , @NamedQuery(name = "ProductosBloqueados.findByIdProducto", query = "SELECT p FROM ProductosBloqueados p WHERE p.idProducto = :idProducto")
    , @NamedQuery(name = "ProductosBloqueados.findByIdUsuario", query = "SELECT p FROM ProductosBloqueados p WHERE p.idUsuario = :idUsuario")
    , @NamedQuery(name = "ProductosBloqueados.findByFechaBloqueo", query = "SELECT p FROM ProductosBloqueados p WHERE p.fechaBloqueo = :fechaBloqueo")
    , @NamedQuery(name = "ProductosBloqueados.findByIdBloqueo", query = "SELECT p FROM ProductosBloqueados p WHERE p.idBloqueo = :idBloqueo")})
public class ProductosBloqueados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_producto")
    private int idProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario")
    private int idUsuario;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcion_bloqueo")
    private String descripcionBloqueo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_bloqueo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaBloqueo;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_bloqueo")
    private Integer idBloqueo;

    public ProductosBloqueados() {
    }

    public ProductosBloqueados(Integer idBloqueo) {
        this.idBloqueo = idBloqueo;
    }

    public ProductosBloqueados(Integer idBloqueo, int idProducto, int idUsuario, String descripcionBloqueo, Date fechaBloqueo) {
        this.idBloqueo = idBloqueo;
        this.idProducto = idProducto;
        this.idUsuario = idUsuario;
        this.descripcionBloqueo = descripcionBloqueo;
        this.fechaBloqueo = fechaBloqueo;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDescripcionBloqueo() {
        return descripcionBloqueo;
    }

    public void setDescripcionBloqueo(String descripcionBloqueo) {
        this.descripcionBloqueo = descripcionBloqueo;
    }

    public Date getFechaBloqueo() {
        return fechaBloqueo;
    }

    public void setFechaBloqueo(Date fechaBloqueo) {
        this.fechaBloqueo = fechaBloqueo;
    }

    public Integer getIdBloqueo() {
        return idBloqueo;
    }

    public void setIdBloqueo(Integer idBloqueo) {
        this.idBloqueo = idBloqueo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBloqueo != null ? idBloqueo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductosBloqueados)) {
            return false;
        }
        ProductosBloqueados other = (ProductosBloqueados) object;
        if ((this.idBloqueo == null && other.idBloqueo != null) || (this.idBloqueo != null && !this.idBloqueo.equals(other.idBloqueo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.ProductosBloqueados[ idBloqueo=" + idBloqueo + " ]";
    }
    
}
