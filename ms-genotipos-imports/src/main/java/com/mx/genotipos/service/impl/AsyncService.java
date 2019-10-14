/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.genotipos.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 *
 * @author NS-448
 */
@Service
public class AsyncService {
    
    @Async
    public void asyncMethodWithNoReturnType(Row row) {
        for(Cell cell: row){
            System.out.print(cell);
            System.out.print(" - ");
        }
        System.out.println("");
    }
}
