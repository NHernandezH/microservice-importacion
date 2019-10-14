/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.genotipos.dao;

import com.mx.genotipos.dao.model.MarkerProfile;
import com.mx.genotipos.dao.model.Profile;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author NS-448
 */
@Transactional
@Repository
public class ProfilesDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveProfiles(List<Profile> profiles) {
        StringBuilder sqlQueryInsert = new StringBuilder();
        sqlQueryInsert.append("DECLARE @a int;\n");
        sqlQueryInsert.append(createQueryInsertAllProfiles(profiles));
//        System.out.println(sqlQueryInsert);
        Long init = System.currentTimeMillis();
        jdbcTemplate.update(sqlQueryInsert.toString());
        Long end = System.currentTimeMillis();
        System.out.println("Time ms : "+(end-init));

    }

    private String createQueryInsertAllProfiles(List<Profile> profiles) {
        StringBuilder queryInsert = new StringBuilder();
        profiles.stream()
                .map(this::createQueryInsertProfile)
                .forEach(queryInsert::append);
        return queryInsert.toString();
    }

    private String createQueryInsertProfile(Profile profile) {
        StringBuilder queryInsert = new StringBuilder();
//        queryInsert.append("DECLARE @a int\n");
        queryInsert.append("INSERT INTO PERFILES (per_identificador,per_tipo,per_baja_logica,per_fecha_registro,per_id_importacion)\nVALUES\n");
        queryInsert.append(produceInsertProfile(profile));
        queryInsert.append("SELECT @a = @@IDENTITY;\n");

        if (profile.getMarcadores().size() > 0) {
            queryInsert.append("\nINSERT INTO MARCADORES_PERFILES (mp_id_perfil,mp_id_marcador,mp_alelo_uno,mp_alelo_dos,mp_baja_logica,mp_fecha_registro)\nVALUES\n");
            profile.getMarcadores().stream()
                    .map(this::produceInsertMarkersProfiles)
                    .forEach(queryInsert::append);
            String sQuery = queryInsert.toString();
            sQuery = sQuery.substring(0, sQuery.length() - 3).concat(";\n");
            return sQuery;
        }
        return queryInsert.toString();
    }

    private String produceInsertProfile(Profile profile) {
        return String.format("('%s', 1, 1, getDate(),%s);%n", profile.getIdentifier(), profile.getImportId());
    }

    private String produceInsertMarkersProfiles(MarkerProfile markerProfile) {
        return String.format("(@a,%s,'%s','%s',1,getdate()),%n",
                markerProfile.getMpIdMarcador(), markerProfile.getMpAleloUno(), markerProfile.getMpAleloDos());
    }
}
