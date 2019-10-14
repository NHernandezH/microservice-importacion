/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.genotipos.dao;

import com.mx.genotipos.dao.model.Importaciones;
import com.mx.genotipos.dao.model.VistaImportaciones;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author NS-448
 */
public interface VistaImportacionesDAO extends JpaRepository<VistaImportaciones,Integer>{
    
}
