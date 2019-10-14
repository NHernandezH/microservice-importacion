/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.genotipos.dao.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author NS-448
 */
@Entity
@Table(name = "VISTA_IMPORTACIONES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VistaImportaciones.findAll", query = "SELECT v FROM VistaImportaciones v")
    , @NamedQuery(name = "VistaImportaciones.findByFntNombreFuente", query = "SELECT v FROM VistaImportaciones v WHERE v.fntNombreFuente = :fntNombreFuente")
    , @NamedQuery(name = "VistaImportaciones.findByImpId", query = "SELECT v FROM VistaImportaciones v WHERE v.impId = :impId")
    , @NamedQuery(name = "VistaImportaciones.findByImpIdentificador", query = "SELECT v FROM VistaImportaciones v WHERE v.impIdentificador = :impIdentificador")
    , @NamedQuery(name = "VistaImportaciones.findByImpBajaLogica", query = "SELECT v FROM VistaImportaciones v WHERE v.impBajaLogica = :impBajaLogica")
    , @NamedQuery(name = "VistaImportaciones.findByPerfiles", query = "SELECT v FROM VistaImportaciones v WHERE v.perfiles = :perfiles")
    , @NamedQuery(name = "VistaImportaciones.findByUsuario", query = "SELECT v FROM VistaImportaciones v WHERE v.usuario = :usuario")
    , @NamedQuery(name = "VistaImportaciones.findByImpTitulo", query = "SELECT v FROM VistaImportaciones v WHERE v.impTitulo = :impTitulo")})
public class VistaImportaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "imp_id")
    @Id
    private Integer impId;
    @Column(name = "fnt_nombre_fuente")
    private String fntNombreFuente;
    @Column(name = "imp_identificador")
    private String impIdentificador;
    @Column(name = "imp_baja_logica")
    private Integer impBajaLogica;
    @Column(name = "perfiles")
    private Integer perfiles;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "imp_titulo")
    private String impTitulo;
    @Column(name = "imp_tipo_muestra")
    private String impTipoMuestra;
    @Column(name = "imp_observaciones")
    private String impObservaciones; 
    @Column(name = "fecha_importacion")
    private String fechaImportacion;
    @Column(name = "imp_fuente_id")
    private Integer idFuente;
    
    public VistaImportaciones() {
    }

    public String getFntNombreFuente() {
        return fntNombreFuente;
    }

    public void setFntNombreFuente(String fntNombreFuente) {
        this.fntNombreFuente = fntNombreFuente;
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

    public Integer getImpBajaLogica() {
        return impBajaLogica;
    }

    public void setImpBajaLogica(Integer impBajaLogica) {
        this.impBajaLogica = impBajaLogica;
    }

    public Integer getPerfiles() {
        return perfiles;
    }

    public void setPerfiles(Integer perfiles) {
        this.perfiles = perfiles;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getImpTitulo() {
        return impTitulo;
    }

    public void setImpTitulo(String impTitulo) {
        this.impTitulo = impTitulo;
    }

    public String getImpTipoMuestra() {
        return impTipoMuestra;
    }

    public void setImpTipoMuestra(String impTipoMuestra) {
        this.impTipoMuestra = impTipoMuestra;
    }

    public String getImpObservaciones() {
        return impObservaciones;
    }

    public void setImpObservaciones(String impObservaciones) {
        this.impObservaciones = impObservaciones;
    }

    public String getFechaImportacion() {
        return fechaImportacion;
    }

    public void setFechaImportacion(String fechaImportacion) {
        this.fechaImportacion = fechaImportacion;
    }

    public Integer getIdFuente() {
        return idFuente;
    }

    public void setIdFuente(Integer idFuente) {
        this.idFuente = idFuente;
    }
    
    
}
