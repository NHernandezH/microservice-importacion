/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.genotipos.dao.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author NS-448
 */
@Entity
@Table(name = "PERFILES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perfiles.findAll", query = "SELECT p FROM Perfiles p")
    , @NamedQuery(name = "Perfiles.findByPerId", query = "SELECT p FROM Perfiles p WHERE p.perId = :perId")
    , @NamedQuery(name = "Perfiles.findByPerIdentificador", query = "SELECT p FROM Perfiles p WHERE p.perIdentificador = :perIdentificador")
    , @NamedQuery(name = "Perfiles.findByPerBajaLogica", query = "SELECT p FROM Perfiles p WHERE p.perBajaLogica = :perBajaLogica")
    , @NamedQuery(name = "Perfiles.findByPerFechaRegistro", query = "SELECT p FROM Perfiles p WHERE p.perFechaRegistro = :perFechaRegistro")
    , @NamedQuery(name = "Perfiles.findByPerPerfilOriginal", query = "SELECT p FROM Perfiles p WHERE p.perPerfilOriginal = :perPerfilOriginal")
    , @NamedQuery(name = "Perfiles.findByPerUsuarioReviso", query = "SELECT p FROM Perfiles p WHERE p.perUsuarioReviso = :perUsuarioReviso")
    , @NamedQuery(name = "Perfiles.findByPerUsuarioCreo", query = "SELECT p FROM Perfiles p WHERE p.perUsuarioCreo = :perUsuarioCreo")
    , @NamedQuery(name = "Perfiles.findByPerMotivoDesestimacion", query = "SELECT p FROM Perfiles p WHERE p.perMotivoDesestimacion = :perMotivoDesestimacion")})
public class Perfiles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "per_id")
    private Integer perId;
    @Column(name = "per_identificador")
    private String perIdentificador;
    @Column(name = "per_baja_logica")
    private Integer perBajaLogica;
    @Column(name = "per_fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date perFechaRegistro;
    @Column(name = "per_perfil_original")
    private Integer perPerfilOriginal;
    @Column(name = "per_usuario_reviso")
    private Integer perUsuarioReviso;
    @Column(name = "per_usuario_creo")
    private Integer perUsuarioCreo;
    @Column(name = "per_motivo_desestimacion")
    private String perMotivoDesestimacion;
    @JoinColumn(name = "per_tipo", referencedColumnName = "tp_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private CatTipoPerfil perTipo;
    @JoinColumn(name = "per_id_importacion", referencedColumnName = "imp_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Importaciones perIdImportacion;

    public Perfiles() {
    }

    public Perfiles(Integer perId) {
        this.perId = perId;
    }

    public Integer getPerId() {
        return perId;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }

    public String getPerIdentificador() {
        return perIdentificador;
    }

    public void setPerIdentificador(String perIdentificador) {
        this.perIdentificador = perIdentificador;
    }

    public Integer getPerBajaLogica() {
        return perBajaLogica;
    }

    public void setPerBajaLogica(Integer perBajaLogica) {
        this.perBajaLogica = perBajaLogica;
    }

    public Date getPerFechaRegistro() {
        return perFechaRegistro;
    }

    public void setPerFechaRegistro(Date perFechaRegistro) {
        this.perFechaRegistro = perFechaRegistro;
    }

    public Integer getPerPerfilOriginal() {
        return perPerfilOriginal;
    }

    public void setPerPerfilOriginal(Integer perPerfilOriginal) {
        this.perPerfilOriginal = perPerfilOriginal;
    }

    public Integer getPerUsuarioReviso() {
        return perUsuarioReviso;
    }

    public void setPerUsuarioReviso(Integer perUsuarioReviso) {
        this.perUsuarioReviso = perUsuarioReviso;
    }

    public Integer getPerUsuarioCreo() {
        return perUsuarioCreo;
    }

    public void setPerUsuarioCreo(Integer perUsuarioCreo) {
        this.perUsuarioCreo = perUsuarioCreo;
    }

    public String getPerMotivoDesestimacion() {
        return perMotivoDesestimacion;
    }

    public void setPerMotivoDesestimacion(String perMotivoDesestimacion) {
        this.perMotivoDesestimacion = perMotivoDesestimacion;
    }

    public CatTipoPerfil getPerTipo() {
        return perTipo;
    }

    public void setPerTipo(CatTipoPerfil perTipo) {
        this.perTipo = perTipo;
    }

    public Importaciones getPerIdImportacion() {
        return perIdImportacion;
    }

    public void setPerIdImportacion(Importaciones perIdImportacion) {
        this.perIdImportacion = perIdImportacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perId != null ? perId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfiles)) {
            return false;
        }
        Perfiles other = (Perfiles) object;
        if ((this.perId == null && other.perId != null) || (this.perId != null && !this.perId.equals(other.perId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.genotipos.dao.model.Perfiles[ perId=" + perId + " ]";
    }
    
}
