/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.genotipos.dao;

import com.mx.genotipos.dao.model.Marker;
import java.util.ArrayList;
import java.util.Date;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;
/**
 *
 * @author NS-448
 */

@Transactional
@Repository
public class MarkersDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    private static final String SQL_SELECT_ACTIVE_MARKERS="SELECT mar_id, mar_nombre, mar_tipo FROM CAT_MARCADORES";
    
    public List<Marker> getActiveMarkers(){
        List<Marker> markers = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL_SELECT_ACTIVE_MARKERS);
        rows.stream()
                .map(this::createMarker)
                .forEach(markers::add);
        return markers;
    }
    
    private Marker createMarker(Map<String, Object> map){
        Marker marker = new Marker();
        marker.setMarBajaLogica((Integer) map.get("mar_baja_logica"));
        marker.setMarFechaRegistro((Date) map.get("mar_fecha_registro"));
        marker.setMarId((Integer) map.get("mar_id"));
        marker.setMarNombre((String) map.get("mar_nombre"));
        marker.setMarTipo((Integer) map.get("mar_tipo"));
        marker.setMarUsuarioCreo((Integer) map.get("mar_usuario_creo"));
        marker.setMarUsuarioEdito((Integer) map.get("mar_usuario_edito"));
        return marker;
    }
    
}
