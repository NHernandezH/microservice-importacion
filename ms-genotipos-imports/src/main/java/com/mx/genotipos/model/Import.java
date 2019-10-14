/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.genotipos.model;

import java.util.List;
import lombok.*;

/**
 *
 * @author NS-448
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Import {
    
    private Integer id;
    private String source;
    private String sample;
    private String observations;
    private String importId;
    private String importDate;
    private Integer importedProfiles;
    private String user;
    private String title;
    private boolean active;
//    private List<Integer> labels;
    private Integer sourceId;

}
