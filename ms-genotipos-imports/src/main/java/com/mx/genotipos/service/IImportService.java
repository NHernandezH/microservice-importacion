/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.genotipos.service;

import com.mx.genotipos.model.Import;
import com.mx.genotipos.model.Response;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author NS-448
 */
public interface IImportService {
    
    public Response getAllImports();
    public Response importProfiles(MultipartFile file, Import importProfiles);
//    public String importProfilesStr(MultipartFile file);
}
