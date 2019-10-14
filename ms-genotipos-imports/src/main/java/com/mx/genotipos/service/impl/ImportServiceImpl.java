/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.genotipos.service.impl;

import com.mx.genotipos.dao.ImportsDAO;
import com.mx.genotipos.dao.MarkersDao;
import com.mx.genotipos.dao.ProfilesDao;
import com.mx.genotipos.dao.VistaImportacionesDAO;
import com.mx.genotipos.dao.model.Fuentes;
import com.mx.genotipos.dao.model.Importaciones;
import com.mx.genotipos.dao.model.Marker;
import com.mx.genotipos.dao.model.MarkerProfile;
import com.mx.genotipos.dao.model.Metadata;
import com.mx.genotipos.dao.model.Profile;
import com.mx.genotipos.dao.model.VistaImportaciones;
import com.mx.genotipos.model.Import;
import com.mx.genotipos.model.Response;
import com.mx.genotipos.service.IImportService;
import com.mx.genotipos.service.asyncProfileService;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.StreamSupport;

import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 *
 * @author NS-448
 */
@Service
public class ImportServiceImpl implements IImportService {

    @Autowired
    private ExecutorService executor;

    @Autowired
    private MarkersDao markersDao;

    @Autowired
    private ProfilesDao profilesDao;
    
    @Autowired
    private ImportsDAO importsDAO;
    
    @Autowired
    private VistaImportacionesDAO vistaImportacionesDAO;

    private List<String> columnNames;
    
    private Integer importId;

    /**
     * VARIABLES
     *
     */
    private HashMap<String, Marker> markersMap;

    @Override
    public Response getAllImports() {
        List<VistaImportaciones> imports = vistaImportacionesDAO.findAll();
        List<Import> importsResponse = new ArrayList();
        imports.stream().map(this::viewImportsToDTO).forEach(importsResponse::add);
        return new Response(true, 0, "Exito", importsResponse);
    }

//    @Override
//    public Response importProfiles(MultipartFile file) {
//        try {
//            Sheet sheet = getSheet(file, 0);
//            sheet.removeRow(sheet.getRow(0));
//            System.out.println("Hello world");
//            StringBuffer stringBuffer = new StringBuffer();
//            List<Future<String>> futures = new ArrayList<Future<String>>();
//            StreamSupport.stream(sheet.spliterator(), false)
//                    .parallel()
//                    //                    .filter(this::isFirstRow)
//                    //                    .map(this::compare)
//                    .forEach(e -> {
//                    });
//
//            return null;
//        } catch (IOException ex) {
//            Logger.getLogger(ImportServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
    @Override
    public Response importProfiles(MultipartFile file, Import importProfiles) {
        getMarcadoresMap();
//        Response response = new Response(true, 0, "Importacion eexitosa", null);
        try {
            importId= saveImport(importProfiles);
            Sheet sheet = getSheet(file, 0);
            Row firstRow = sheet.getRow(0);
            getColumnNames(firstRow);
            sheet.removeRow(firstRow);
            StringBuffer stringBuffer = new StringBuffer();
            List<Future<Profile>> futures = new ArrayList<Future<Profile>>();
            List<Profile> profiles = new ArrayList<>();
            StreamSupport.stream(sheet.spliterator(), false)
                    .forEach(e -> {
                        futures.add(createProfileWhithRow(e));
                    });
            futures.stream().forEach(
                    future -> {
                        try {
                            profiles.add(future.get());
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                            
                        } catch (ExecutionException ex) {
                            ex.printStackTrace();
                        }
                    }
            );
            int start;
            int end = 999;
            
            System.out.println("Total de perfiles " + profiles.size());
            for (start = 0; end < profiles.size(); start += 1000) {
                System.out.println(start + " - " + end);
                profilesDao.saveProfiles(profiles.subList(start, end));
                end += 1000;
            }
            System.out.println(start + " -> " + profiles.size());
            profilesDao.saveProfiles(profiles.subList(start, profiles.size()));
            
            return new Response(true, 0, "Importacion eexitosa", null);

        } catch (IOException ex) {
            ex.printStackTrace();
            Logger.getLogger(ImportServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return new Response(false, 0, "Error en la importacion", null);
        }
    }

    /**
     * PRIVATE METHODS
     *
     */
    private Sheet getSheet(MultipartFile file, int sheetIndex) throws IOException {
        InputStream stream = new ByteArrayInputStream(file.getBytes());
        Workbook workbook = null;
        if (file.getOriginalFilename().endsWith("xls")) {
            workbook = new HSSFWorkbook(stream);
        } else if (file.getOriginalFilename().endsWith("xlsx")) {
            workbook = new XSSFWorkbook(stream);
        }
        Sheet sheet = workbook.getSheetAt(sheetIndex);
        return sheet;
    }

    private Future<Profile> createProfileWhithRow(Row row) {
        Profile profile = new Profile();
        Cell cell = row.getCell(0);
        profile.setIdentifier(getCellValue(cell));
        profile.setHomocigotos(0);
        profile.setImportId(importId);
        return executor.submit(() -> {
            Integer homocigotos = 0;
            StreamSupport.stream(row.spliterator(), false)
                    .map(this::getMarkerOrMetadataFromCell)
                    .forEach(object -> {
                        if (object instanceof MarkerProfile) {
                            MarkerProfile markerProfile = (MarkerProfile) object;
                            profile.getMarcadores().add(markerProfile);
                            if (markerProfile.getMpAleloUno().equals(markerProfile.getMpAleloDos())) {
                                profile.setHomocigotos(profile.getHomocigotos() + 1);
                            }
                        }
                    });
//            System.out.println(row.getRowNum() + " -> Total de marcadores " + profile.getMarcadores().size());
            return profile;
        });

    }

    private String getCellValue(Cell cell) {
        if (cell != null) {
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_STRING:
                    return cell.getStringCellValue().toUpperCase().replaceAll(" ", "").replaceAll("\n", "");
                case Cell.CELL_TYPE_NUMERIC:
                    return String.valueOf(cell.toString()).replace(".0", "");
                default:
                    return cell.toString().toUpperCase().replaceAll(" ", "").replaceAll("\n", "");
            }
        }
        return "";
    }

    private Object getMarkerOrMetadataFromCell(Cell cell) {
        try {
            String cellValue = getCellValue(cell);
            if (!cellValue.equals("") && !cellValue.equals(",")) {
                String headerRow = columnNames.get(cell.getColumnIndex());
                if (markersMap.containsKey(headerRow)) {
                    String[] alleles = getAllelesForString(cellValue);
                    return asignAlellesToMarker(headerRow, alleles[0], alleles[1]);
//                    return new MarkerProfile("", "", markersMap.get(headerRow).getMarId());
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Metadata();
    }

    private String[] getAllelesForString(String string) {
        String[] alleles = string.split(",");

        if (alleles.length > 1) {
            if (alleles[0].equals("")) {
                return new String[]{alleles[1], alleles[1]};
            } else if (alleles[1].equals("")) {
                return new String[]{alleles[0], alleles[0]};
            } else {
                return new String[]{alleles[0], alleles[1]};
            }
        } else if (alleles.length == 1) {
            return new String[]{alleles[0], alleles[0]};
        }
        return new String[]{"", ""};
    }

    private MarkerProfile asignAlellesToMarker(String marker, String allele1, String allele2) {
        Integer markerType = markersMap.get(marker).getMarTipo();
        String markerName = markersMap.get(marker).getMarNombre();
        MarkerProfile markerProfile = new MarkerProfile();
        markerProfile.setMpIdMarcador(markersMap.get(marker).getMarId());
        if (markerName.equals("AMEL")) {
            if ((allele1.equals("X") && allele2.equals("X")) || (allele1.equals("X") && allele2.equals("Y"))) {
                markerProfile.setMpAleloUno(allele1);
                markerProfile.setMpAleloDos(allele2);
                return markerProfile;
            } else {

            }
        } else {
            switch (markerType) {
                case 1:
                    markerProfile.setMpAleloUno(allele1);
                    markerProfile.setMpAleloDos(allele2);
                    break;
                case 2:
                    markerProfile.setMpAleloUno(allele1);
                    break;
                case 3:
                    markerProfile.setMpAleloUno(allele1);
                    if (markerName.equals("DYS385")) {
                        markerProfile.setMpAleloDos(allele2);
                    }
                    break;
                default:
                    markerProfile.setMpAleloUno(allele1);
                    markerProfile.setMpAleloDos(allele2);
            }
        }
        return markerProfile;
    }

    /*
	 * genera un HashMap de los marcadores <Identificador, id>
     */
    private HashMap<String, Marker> getMarcadoresMap() {
        List<Marker> listMarkers = markersDao.getActiveMarkers();
        markersMap = new HashMap<String, Marker>();
        listMarkers.forEach(marker -> {
            markersMap.put(marker.getMarNombre(), marker);
//            System.out.println(marker.getMarId()+" nombre -> "+marker.getMarNombre()+" tipo-> "+marker.getMarTipo());
        });
        return markersMap;
    }

    /*
	 * genera un HashMap de los metadatos <nombre, id>
     */
//	private HashMap<String, Integer> getMetadatosMap() {
//		List<CatMetMetadatos> listaFormatoMetaDatos = matadatosDAO.findAll();
//		HashMap<String, Integer> metadatosMap = new HashMap<String, Integer>();
//		for (CatMetMetadatos metadato : listaFormatoMetaDatos) {
//			metadatosMap.put(metadato.getCatMetDescripcion().toUpperCase().replaceAll(" ", ""), metadato.getCatMetId());
//		}
//		return metadatosMap;
//	}
//	private HashMap<String, Integer> getPerfiles() {
//		List<PerPerfiles> perfiles = per_PerfilDao.findAllPerIdentifier();
//		HashMap<String, Integer> metadatosMap = new HashMap<String, Integer>();
//		for (PerPerfiles perfil : perfiles) {
//			metadatosMap.put(perfil.getPerIdentifier().toUpperCase().replaceAll(" ", ""), perfil.getPerId());
//		}
//		return metadatosMap;
//	}
    private void getColumnNames(Row row) {
        columnNames = new ArrayList<>();
        StreamSupport.stream(row.spliterator(), false)
                .map(this::getCellValue)
                .forEach(columnNames::add);
        System.out.println("total columnas" + columnNames.size());
        System.out.println(columnNames.toString());
    }
    
    private Integer saveImport(Import importProfiles){
        Importaciones imports= importsDAO.save(importsToEntity(importProfiles));
        imports.setImpIdentificador("I-1-"+imports.getImpId());
        importsDAO.save(imports);
        return imports.getImpId();
    }
    
    private Importaciones importsToEntity(Import importProfiles){
        return new Importaciones("", importProfiles.getTitle(),"Admin", importProfiles.getObservations(), 
                importProfiles.getSample(), "", new Fuentes(importProfiles.getSourceId()));
    }
    
    private Import viewImportsToDTO(VistaImportaciones importView){
        return new Import(
                importView.getImpId(),
                importView.getFntNombreFuente(),
                importView.getImpTipoMuestra(),
                importView.getImpObservaciones(),
                importView.getImpIdentificador(),
                importView.getFechaImportacion(),
                importView.getPerfiles(),
                importView.getUsuario(),
                importView.getImpTitulo(),
                importView.getImpBajaLogica()==1,
                importView.getIdFuente()
        );
    }
}
