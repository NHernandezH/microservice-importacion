/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.genotipos.dao.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author NS-448
 */
@Entity
@Table(name = "FUENTES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fuentes.findAll", query = "SELECT f FROM Fuentes f")
    , @NamedQuery(name = "Fuentes.findByFntId", query = "SELECT f FROM Fuentes f WHERE f.fntId = :fntId")
    , @NamedQuery(name = "Fuentes.findByFntNombreFuente", query = "SELECT f FROM Fuentes f WHERE f.fntNombreFuente = :fntNombreFuente")
    , @NamedQuery(name = "Fuentes.findByFntIdentificadorInterno", query = "SELECT f FROM Fuentes f WHERE f.fntIdentificadorInterno = :fntIdentificadorInterno")
    , @NamedQuery(name = "Fuentes.findByFntNombreContacto", query = "SELECT f FROM Fuentes f WHERE f.fntNombreContacto = :fntNombreContacto")
    , @NamedQuery(name = "Fuentes.findByFntCorreoContacto", query = "SELECT f FROM Fuentes f WHERE f.fntCorreoContacto = :fntCorreoContacto")
    , @NamedQuery(name = "Fuentes.findByFntTelefonoContacto", query = "SELECT f FROM Fuentes f WHERE f.fntTelefonoContacto = :fntTelefonoContacto")
    , @NamedQuery(name = "Fuentes.findByFntOtroTelefonoContacto", query = "SELECT f FROM Fuentes f WHERE f.fntOtroTelefonoContacto = :fntOtroTelefonoContacto")
    , @NamedQuery(name = "Fuentes.findByFntBajaLogica", query = "SELECT f FROM Fuentes f WHERE f.fntBajaLogica = :fntBajaLogica")
    , @NamedQuery(name = "Fuentes.findByFntFechaRegistro", query = "SELECT f FROM Fuentes f WHERE f.fntFechaRegistro = :fntFechaRegistro")
    , @NamedQuery(name = "Fuentes.findByFntIdentificadorExterno", query = "SELECT f FROM Fuentes f WHERE f.fntIdentificadorExterno = :fntIdentificadorExterno")})
public class Fuentes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "fnt_id")
    private Integer fntId;
    @Column(name = "fnt_nombre_fuente")
    private String fntNombreFuente;
    @Column(name = "fnt_identificador_interno")
    private String fntIdentificadorInterno;
    @Column(name = "fnt_nombre_contacto")
    private String fntNombreContacto;
    @Column(name = "fnt_correo_contacto")
    private String fntCorreoContacto;
    @Column(name = "fnt_telefono_contacto")
    private String fntTelefonoContacto;
    @Column(name = "fnt_otro_telefono_contacto")
    private String fntOtroTelefonoContacto;
    @Column(name = "fnt_baja_logica")
    private Integer fntBajaLogica;
    @Column(name = "fnt_fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fntFechaRegistro;
    @Column(name = "fnt_identificador_externo")
    private String fntIdentificadorExterno;
    @OneToMany(mappedBy = "impFuenteId", fetch = FetchType.EAGER)
    private List<Importaciones> importacionesList;

    public Fuentes() {
    }

    public Fuentes(Integer fntId) {
        this.fntId = fntId;
    }

    public Integer getFntId() {
        return fntId;
    }

    public void setFntId(Integer fntId) {
        this.fntId = fntId;
    }

    public String getFntNombreFuente() {
        return fntNombreFuente;
    }

    public void setFntNombreFuente(String fntNombreFuente) {
        this.fntNombreFuente = fntNombreFuente;
    }

    public String getFntIdentificadorInterno() {
        return fntIdentificadorInterno;
    }

    public void setFntIdentificadorInterno(String fntIdentificadorInterno) {
        this.fntIdentificadorInterno = fntIdentificadorInterno;
    }

    public String getFntNombreContacto() {
        return fntNombreContacto;
    }

    public void setFntNombreContacto(String fntNombreContacto) {
        this.fntNombreContacto = fntNombreContacto;
    }

    public String getFntCorreoContacto() {
        return fntCorreoContacto;
    }

    public void setFntCorreoContacto(String fntCorreoContacto) {
        this.fntCorreoContacto = fntCorreoContacto;
    }

    public String getFntTelefonoContacto() {
        return fntTelefonoContacto;
    }

    public void setFntTelefonoContacto(String fntTelefonoContacto) {
        this.fntTelefonoContacto = fntTelefonoContacto;
    }

    public String getFntOtroTelefonoContacto() {
        return fntOtroTelefonoContacto;
    }

    public void setFntOtroTelefonoContacto(String fntOtroTelefonoContacto) {
        this.fntOtroTelefonoContacto = fntOtroTelefonoContacto;
    }

    public Integer getFntBajaLogica() {
        return fntBajaLogica;
    }

    public void setFntBajaLogica(Integer fntBajaLogica) {
        this.fntBajaLogica = fntBajaLogica;
    }

    public Date getFntFechaRegistro() {
        return fntFechaRegistro;
    }

    public void setFntFechaRegistro(Date fntFechaRegistro) {
        this.fntFechaRegistro = fntFechaRegistro;
    }

    public String getFntIdentificadorExterno() {
        return fntIdentificadorExterno;
    }

    public void setFntIdentificadorExterno(String fntIdentificadorExterno) {
        this.fntIdentificadorExterno = fntIdentificadorExterno;
    }

    @XmlTransient
    public List<Importaciones> getImportacionesList() {
        return importacionesList;
    }

    public void setImportacionesList(List<Importaciones> importacionesList) {
        this.importacionesList = importacionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fntId != null ? fntId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fuentes)) {
            return false;
        }
        Fuentes other = (Fuentes) object;
        if ((this.fntId == null && other.fntId != null) || (this.fntId != null && !this.fntId.equals(other.fntId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.genotipos.dao.model.Fuentes[ fntId=" + fntId + " ]";
    }
    
}
