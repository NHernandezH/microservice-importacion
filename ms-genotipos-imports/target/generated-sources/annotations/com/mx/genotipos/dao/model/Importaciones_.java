package com.mx.genotipos.dao.model;

import com.mx.genotipos.dao.model.Fuentes;
import com.mx.genotipos.dao.model.Perfiles;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-12T11:15:43")
@StaticMetamodel(Importaciones.class)
public class Importaciones_ { 

    public static volatile SingularAttribute<Importaciones, Date> impFechaImportacion;
    public static volatile SingularAttribute<Importaciones, String> impUsuario;
    public static volatile SingularAttribute<Importaciones, String> impRutaArchivo;
    public static volatile ListAttribute<Importaciones, Perfiles> perfilesList;
    public static volatile SingularAttribute<Importaciones, String> impTitulo;
    public static volatile SingularAttribute<Importaciones, String> impObservaciones;
    public static volatile SingularAttribute<Importaciones, Integer> impBajaLogica;
    public static volatile SingularAttribute<Importaciones, String> impIdentificador;
    public static volatile SingularAttribute<Importaciones, Fuentes> impFuenteId;
    public static volatile SingularAttribute<Importaciones, Integer> impId;
    public static volatile SingularAttribute<Importaciones, String> impTipoMuestra;

}