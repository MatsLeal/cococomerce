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
@Table(name = "productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p")
    , @NamedQuery(name = "Productos.findById", query = "SELECT p FROM Productos p WHERE p.id = :id")
    , @NamedQuery(name = "Productos.findByNombre", query = "SELECT p FROM Productos p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Productos.findByBloqueada", query = "SELECT p FROM Productos p WHERE p.bloqueada = :bloqueada")
    , @NamedQuery(name = "Productos.findByFechaUpdateProducto", query = "SELECT p FROM Productos p WHERE p.fechaUpdateProducto = :fechaUpdateProducto")
    , @NamedQuery(name = "Productos.findByUsuarioOfertor", query = "SELECT p FROM Productos p WHERE p.usuarioOfertor = :usuarioOfertor")
    , @NamedQuery( name= "Productos.findImageById",query=" SELECT p FROM Productos p WHERE p.id=:id ")
})
public class Productos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "indiceimagen")
    private byte[] indiceimagen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bloqueada")
    private boolean bloqueada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_update_producto")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUpdateProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "usuario_ofertor")
    private String usuarioOfertor;

    public Productos() {
    }

    public Productos(Integer id) {
        this.id = id;
    }

    public Productos(Integer id, String nombre, String descripcion, byte[] indiceimagen, boolean bloqueada, Date fechaUpdateProducto, String usuarioOfertor) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.indiceimagen = indiceimagen;
        this.bloqueada = bloqueada;
        this.fechaUpdateProducto = fechaUpdateProducto;
        this.usuarioOfertor = usuarioOfertor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public byte[] getIndiceimagen() {
        return indiceimagen;
    }

    public void setIndiceimagen(byte[] indiceimagen) {
        this.indiceimagen = indiceimagen;
    }

    public boolean getBloqueada() {
        return bloqueada;
    }

    public void setBloqueada(boolean bloqueada) {
        this.bloqueada = bloqueada;
    }

    public Date getFechaUpdateProducto() {
        return fechaUpdateProducto;
    }

    public void setFechaUpdateProducto(Date fechaUpdateProducto) {
        this.fechaUpdateProducto = fechaUpdateProducto;
    }

    public String getUsuarioOfertor() {
        return usuarioOfertor;
    }

    public void setUsuarioOfertor(String usuarioOfertor) {
        this.usuarioOfertor = usuarioOfertor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Productos[ id=" + id + " ]";
    }
    
}
