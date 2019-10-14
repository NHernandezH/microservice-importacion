/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.genotipos.dao.model;

import java.util.Date;
import lombok.*;

/**
 *
 * @author NS-448
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarkerProfile {
    
    private Integer mpId;
    private String mpAleloUno;
    private String mpAleloDos;
    private Integer mpBajaLogica;
    private Date mpFechaRegistro;
    private Integer mpIdMarcador;

    public MarkerProfile(String mpAleloUno, String mpAleloDos, Integer mpIdMarcador) {
        this.mpAleloUno = mpAleloUno;
        this.mpAleloDos = mpAleloDos;
        this.mpIdMarcador = mpIdMarcador;
    }

}
