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
@Table(name = "donaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Donaciones.findAll", query = "SELECT d FROM Donaciones d")
    , @NamedQuery(name = "Donaciones.findByIdDonador", query = "SELECT d FROM Donaciones d WHERE d.idDonador = :idDonador")
    , @NamedQuery(name = "Donaciones.findByIdBeneficiado", query = "SELECT d FROM Donaciones d WHERE d.idBeneficiado = :idBeneficiado")
    , @NamedQuery(name = "Donaciones.findByHoraDonacion", query = "SELECT d FROM Donaciones d WHERE d.horaDonacion = :horaDonacion")
    , @NamedQuery(name = "Donaciones.findByIdProducto", query = "SELECT d FROM Donaciones d WHERE d.idProducto = :idProducto")
    , @NamedQuery(name = "Donaciones.findByIdDonacion", query = "SELECT d FROM Donaciones d WHERE d.idDonacion = :idDonacion")
    , @NamedQuery(name = "Donaciones.ganador", query = "update Donaciones where id= :iddonacion set ganador=:idganador ")
}
    
)
public class Donaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_donador")
    private int idDonador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_beneficiado")
    private int idBeneficiado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_donacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaDonacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_producto")
    private int idProducto;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_donacion")
    private Integer idDonacion;

    public Donaciones() {
    }

    public Donaciones(Integer idDonacion) {
        this.idDonacion = idDonacion;
    }

    public Donaciones(Integer idDonacion, int idDonador, int idBeneficiado, Date horaDonacion, int idProducto) {
        this.idDonacion = idDonacion;
        this.idDonador = idDonador;
        this.idBeneficiado = idBeneficiado;
        this.horaDonacion = horaDonacion;
        this.idProducto = idProducto;
    }

    public int getIdDonador() {
        return idDonador;
    }

    public void setIdDonador(int idDonador) {
        this.idDonador = idDonador;
    }

    public int getIdBeneficiado() {
        return idBeneficiado;
    }

    public void setIdBeneficiado(int idBeneficiado) {
        this.idBeneficiado = idBeneficiado;
    }

    public Date getHoraDonacion() {
        return horaDonacion;
    }

    public void setHoraDonacion(Date horaDonacion) {
        this.horaDonacion = horaDonacion;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getIdDonacion() {
        return idDonacion;
    }

    public void setIdDonacion(Integer idDonacion) {
        this.idDonacion = idDonacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDonacion != null ? idDonacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Donaciones)) {
            return false;
        }
        Donaciones other = (Donaciones) object;
        if ((this.idDonacion == null && other.idDonacion != null) || (this.idDonacion != null && !this.idDonacion.equals(other.idDonacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Donaciones[ idDonacion=" + idDonacion + " ]";
    }
    
}
