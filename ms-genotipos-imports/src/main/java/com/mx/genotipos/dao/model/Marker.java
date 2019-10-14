/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.genotipos.dao.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.*;

/**
 *
 * @author NS-448
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Marker {
    
    private Integer marId;
    private String marNombre;
    private Integer marBajaLogica;
    private Date marFechaRegistro;
    private Integer marUsuarioCreo;
    private Integer marUsuarioEdito;
    private Integer marTipo;
    
}
