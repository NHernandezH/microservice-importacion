/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.genotipos.dao.model;

import java.util.ArrayList;
import java.util.List;
import lombok.*;

/**
 *
 * @author NS-448
 */

@Data
//@NoArgsConstructor
@AllArgsConstructor
public class Profile {
    
    private String identifier;
    private Integer homocigotos;
    private Integer tipoPerfil;
    private Integer importId;
    private List<MarkerProfile> marcadores;

    public Profile() {
        this.marcadores= new ArrayList<>();
    }
    
}
