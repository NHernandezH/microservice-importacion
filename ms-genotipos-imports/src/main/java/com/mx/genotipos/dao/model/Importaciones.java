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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "IMPORTACIONES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Importaciones.findAll", query = "SELECT i FROM Importaciones i")
    , @NamedQuery(name = "Importaciones.findByImpId", query = "SELECT i FROM Importaciones i WHERE i.impId = :impId")
    , @NamedQuery(name = "Importaciones.findByImpIdentificador", query = "SELECT i FROM Importaciones i WHERE i.impIdentificador = :impIdentificador")
    , @NamedQuery(name = "Importaciones.findByImpTitulo", query = "SELECT i FROM Importaciones i WHERE i.impTitulo = :impTitulo")
    , @NamedQuery(name = "Importaciones.findByImpFechaImportacion", query = "SELECT i FROM Importaciones i WHERE i.impFechaImportacion = :impFechaImportacion")
    , @NamedQuery(name = "Importaciones.findByImpUsuario", query = "SELECT i FROM Importaciones i WHERE i.impUsuario = :impUsuario")
    , @NamedQuery(name = "Importaciones.findByImpObservaciones", query = "SELECT i FROM Importaciones i WHERE i.impObservaciones = :impObservaciones")
    , @NamedQuery(name = "Importaciones.findByImpBajaLogica", query = "SELECT i FROM Importaciones i WHERE i.impBajaLogica = :impBajaLogica")
    , @NamedQuery(name = "Importaciones.findByImpTipoMuestra", query = "SELECT i FROM Importaciones i WHERE i.impTipoMuestra = :impTipoMuestra")
    , @NamedQuery(name = "Importaciones.findByImpRutaArchivo", query = "SELECT i FROM Importaciones i WHERE i.impRutaArchivo = :impRutaArchivo")})
public class Importaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "imp_id")
    private Integer impId;
    @Column(name = "imp_identificador")
    private String impIdentificador;
    @Column(name = "imp_titulo")
    private String impTitulo;
    @Column(name = "imp_fecha_importacion")
    @Temporal(TemporalType.DATE)
    private Date impFechaImportacion;
    @Column(name = "imp_usuario")
    private String impUsuario;
    @Column(name = "imp_observaciones")
    private String impObservaciones;
    @Column(name = "imp_baja_logica")
    private Integer impBajaLogica;
    @Column(name = "imp_tipo_muestra")
    private String impTipoMuestra;
    @Column(name = "imp_ruta_archivo")
    private String impRutaArchivo;
    @JoinColumn(name = "imp_fuente_id", referencedColumnName = "fnt_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Fuentes impFuenteId;
    @OneToMany(mappedBy = "perIdImportacion", fetch = FetchType.EAGER)
    private List<Perfiles> perfilesList;

    public Importaciones() {
    }

    public Importaciones(String impIdentificador, String impTitulo, String impUsuario, String impObservaciones, String impTipoMuestra, String impRutaArchivo, Fuentes impFuenteId) {
        this.impIdentificador = impIdentificador;
        this.impTitulo = impTitulo;
        this.impUsuario = impUsuario;
        this.impObservaciones = impObservaciones;
        this.impTipoMuestra = impTipoMuestra;
        this.impRutaArchivo = impRutaArchivo;
        this.impFuenteId = impFuenteId;
        this.impBajaLogica = 1;
        this.impFechaImportacion = new Date();
    }
    
    

    public Importaciones(Integer impId) {
        this.impId = impId;
    }

    public Integer getImpId() {
        return impId;
    }

    public void setImpId(Integer impId) {
        this.impId = impId;
    }

    public String getImpIdentificador() {
        return impIdentificador;
    }

    public void setImpIdentificador(String impIdentificador) {
        this.impIdentificador = impIdentificador;
    }

    public String getImpTitulo() {
        return impTitulo;
    }

    public void setImpTitulo(String impTitulo) {
        this.impTitulo = impTitulo;
    }

    public Date getImpFechaImportacion() {
        return impFechaImportacion;
    }

    public void setImpFechaImportacion(Date impFechaImportacion) {
        this.impFechaImportacion = impFechaImportacion;
    }

    public String getImpUsuario() {
        return impUsuario;
    }

    public void setImpUsuario(String impUsuario) {
        this.impUsuario = impUsuario;
    }

    public String getImpObservaciones() {
        return impObservaciones;
    }

    public void setImpObservaciones(String impObservaciones) {
        this.impObservaciones = impObservaciones;
    }

    public Integer getImpBajaLogica() {
        return impBajaLogica;
    }

    public void setImpBajaLogica(Integer impBajaLogica) {
        this.impBajaLogica = impBajaLogica;
    }

    public String getImpTipoMuestra() {
        return impTipoMuestra;
    }

    public void setImpTipoMuestra(String impTipoMuestra) {
        this.impTipoMuestra = impTipoMuestra;
    }

    public String getImpRutaArchivo() {
        return impRutaArchivo;
    }

    public void setImpRutaArchivo(String impRutaArchivo) {
        this.impRutaArchivo = impRutaArchivo;
    }

    public Fuentes getImpFuenteId() {
        return impFuenteId;
    }

    public void setImpFuenteId(Fuentes impFuenteId) {
        this.impFuenteId = impFuenteId;
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
        hash += (impId != null ? impId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Importaciones)) {
            return false;
        }
        Importaciones other = (Importaciones) object;
        if ((this.impId == null && other.impId != null) || (this.impId != null && !this.impId.equals(other.impId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.genotipos.dao.model.Importaciones[ impId=" + impId + " ]";
    }
    
}
