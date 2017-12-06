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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "producto_pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoPedido.findAll", query = "SELECT p FROM ProductoPedido p")
    , @NamedQuery(name = "ProductoPedido.findByIdPedido", query = "SELECT p FROM ProductoPedido p WHERE p.idPedido = :idPedido")
    , @NamedQuery(name = "ProductoPedido.findByIdDonante", query = "SELECT p FROM ProductoPedido p WHERE p.idDonante = :idDonante")
    , @NamedQuery(name = "ProductoPedido.findByIdSolicitante", query = "SELECT p FROM ProductoPedido p WHERE p.idSolicitante = :idSolicitante")
    , @NamedQuery(name = "ProductoPedido.findByGanador", query = "SELECT p FROM ProductoPedido p WHERE p.ganador = :ganador")
    , @NamedQuery(name = "ProductoPedido.findByFechaPedido", query = "SELECT p FROM ProductoPedido p WHERE p.fechaPedido = :fechaPedido")
    , @NamedQuery(name = "ProductoPedido.findByIdProducto", query = "SELECT p FROM ProductoPedido p WHERE p.idProducto = :idProducto")
    , @NamedQuery(name = "ProductoPedido.asignaGanador", query="UPDATE ProductoPedido SET ganador=:idganador WHERE idPedido=:idpedido")
    , @NamedQuery(name = "ProductoPedido.donados", query="SELECT p FROM ProductoPedido p WHERE p.idDonante=:iddonante and p.ganador !=-1" )
    , @NamedQuery(name = "ProductoPedido.solicitudes", query="SELECT p FROM ProductoPedido p WHERE p.ganador=-1 and p.idDonante=:iddonante")    
    , @NamedQuery(name = "ProductoPedido.wishlist", query="SELECT p FROM ProductoPedido p WHERE p.ganador=-1 and p.idDonante=:idsolicitante")
}
    
)
public class ProductoPedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pedido")
    private Integer idPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_donante")
    private int idDonante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_solicitante")
    private int idSolicitante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ganador")
    private int ganador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_pedido")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_producto")
    private int idProducto;

    public ProductoPedido() {
    }

    public ProductoPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public ProductoPedido(Integer idPedido, int idDonante, int idSolicitante, int ganador, Date fechaPedido, int idProducto) {
        this.idPedido = idPedido;
        this.idDonante = idDonante;
        this.idSolicitante = idSolicitante;
        this.ganador = ganador;
        this.fechaPedido = fechaPedido;
        this.idProducto = idProducto;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdDonante() {
        return idDonante;
    }

    public void setIdDonante(int idDonante) {
        this.idDonante = idDonante;
    }

    public int getIdSolicitante() {
        return idSolicitante;
    }

    public void setIdSolicitante(int idSolicitante) {
        this.idSolicitante = idSolicitante;
    }

    public int getGanador() {
        return ganador;
    }

    public void setGanador(int ganador) {
        this.ganador = ganador;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPedido != null ? idPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoPedido)) {
            return false;
        }
        ProductoPedido other = (ProductoPedido) object;
        if ((this.idPedido == null && other.idPedido != null) || (this.idPedido != null && !this.idPedido.equals(other.idPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.ProductoPedido[ idPedido=" + idPedido + " ]";
    }
    
}
