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
@Table(name = "CAT_TIPO_PERFIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatTipoPerfil.findAll", query = "SELECT c FROM CatTipoPerfil c")
    , @NamedQuery(name = "CatTipoPerfil.findByTpId", query = "SELECT c FROM CatTipoPerfil c WHERE c.tpId = :tpId")
    , @NamedQuery(name = "CatTipoPerfil.findByTpDescripcion", query = "SELECT c FROM CatTipoPerfil c WHERE c.tpDescripcion = :tpDescripcion")
    , @NamedQuery(name = "CatTipoPerfil.findByTpFechaRegistro", query = "SELECT c FROM CatTipoPerfil c WHERE c.tpFechaRegistro = :tpFechaRegistro")
    , @NamedQuery(name = "CatTipoPerfil.findByTpBajaLogica", query = "SELECT c FROM CatTipoPerfil c WHERE c.tpBajaLogica = :tpBajaLogica")})
public class CatTipoPerfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "tp_id")
    private Integer tpId;
    @Column(name = "tp_descripcion")
    private String tpDescripcion;
    @Column(name = "tp_fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date tpFechaRegistro;
    @Column(name = "tp_baja_logica")
    private Boolean tpBajaLogica;
    @OneToMany(mappedBy = "perTipo", fetch = FetchType.EAGER)
    private List<Perfiles> perfilesList;

    public CatTipoPerfil() {
    }

    public CatTipoPerfil(Integer tpId) {
        this.tpId = tpId;
    }

    public Integer getTpId() {
        return tpId;
    }

    public void setTpId(Integer tpId) {
        this.tpId = tpId;
    }

    public String getTpDescripcion() {
        return tpDescripcion;
    }

    public void setTpDescripcion(String tpDescripcion) {
        this.tpDescripcion = tpDescripcion;
    }

    public Date getTpFechaRegistro() {
        return tpFechaRegistro;
    }

    public void setTpFechaRegistro(Date tpFechaRegistro) {
        this.tpFechaRegistro = tpFechaRegistro;
    }

    public Boolean getTpBajaLogica() {
        return tpBajaLogica;
    }

    public void setTpBajaLogica(Boolean tpBajaLogica) {
        this.tpBajaLogica = tpBajaLogica;
    }

    @XmlTransient
    public List<Perfiles> getPerfilesList() {
        return perfilesList;
    }

    public void setPerfilesList(List<Perfiles> perfilesList) {
        this.perfilesList = perfilesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tpId != null ? tpId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatTipoPerfil)) {
            return false;
        }
        CatTipoPerfil other = (CatTipoPerfil) object;
        if ((this.tpId == null && other.tpId != null) || (this.tpId != null && !this.tpId.equals(other.tpId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.genotipos.dao.model.CatTipoPerfil[ tpId=" + tpId + " ]";
    }
    
}
