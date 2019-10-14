/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.genotipos.controller;

import com.google.gson.Gson;
import com.mx.genotipos.model.Import;
import com.mx.genotipos.model.Response;
import com.mx.genotipos.service.impl.ImportServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author NS-448
 */
@RestController
@RequestMapping("/api/import")
@CrossOrigin(origins = {"http://localhost:4200","http://3.17.128.176:4200","*"} , allowedHeaders = "*")
public class ImportController {
    
    private ImportServiceImpl importServiceImpl;

    public ImportController(ImportServiceImpl importServiceImpl) {
        this.importServiceImpl = importServiceImpl;
    }
    
    @GetMapping("")
    public Response getAllImports(){
        return importServiceImpl.getAllImports();
    }
    
//    @PostMapping(value="",produces = MediaType.TEXT_PLAIN_VALUE)
//    public Response mportProfiles(@RequestParam("file") MultipartFile file){
//        return importServiceImpl.importProfiles(file);
//    }
    
    @PostMapping("/{userId}")
    public Response mportProfiles(@RequestParam("file") MultipartFile file,@RequestParam("import") String importStr){
        Gson gson =  new Gson();
        System.out.println(importStr);
        Import imports=gson.fromJson(importStr, Import.class);
        imports.setSourceId(3);
        return importServiceImpl.importProfiles(file,imports);
    }
    
}
