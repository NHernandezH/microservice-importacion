/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.genotipos.dao;

import com.mx.genotipos.dao.model.Importaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author NS-448
 */
@Transactional
@Repository
public interface ImportsDAO extends JpaRepository<Importaciones,Integer>{
    
}
