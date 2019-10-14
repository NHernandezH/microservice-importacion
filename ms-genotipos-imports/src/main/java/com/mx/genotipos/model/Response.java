/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.genotipos.model;

import java.util.List;
import lombok.Data;

/**
 *
 * @author NS-448
 */
@Data
public class Response<T> {
    
    private boolean process;
    private Integer identifier;
    private String message;
    private T responseObject;
    private List<T> responseList;

    public Response() {
    }

    public Response(boolean process, Integer identifier, String message, T responseObject) {
        this.process = process;
        this.identifier = identifier;
        this.message = message;
        this.responseObject = responseObject;
    }

    public Response(boolean process, Integer identifier, String message, List<T> responseList) {
        this.process = process;
        this.identifier = identifier;
        this.message = message;
        this.responseList = responseList;
    }
    
    
    
}
