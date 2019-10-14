package com.mx.genotipos.dao.model;

import com.mx.genotipos.dao.model.Importaciones;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-12T11:15:43")
@StaticMetamodel(Fuentes.class)
public class Fuentes_ { 

    public static volatile SingularAttribute<Fuentes, String> fntIdentificadorExterno;
    public static volatile SingularAttribute<Fuentes, String> fntTelefonoContacto;
    public static volatile SingularAttribute<Fuentes, String> fntOtroTelefonoContacto;
    public static volatile SingularAttribute<Fuentes, String> fntNombreContacto;
    public static volatile SingularAttribute<Fuentes, String> fntCorreoContacto;
    public static volatile SingularAttribute<Fuentes, Integer> fntId;
    public static volatile SingularAttribute<Fuentes, String> fntNombreFuente;
    public static volatile ListAttribute<Fuentes, Importaciones> importacionesList;
    public static volatile SingularAttribute<Fuentes, Integer> fntBajaLogica;
    public static volatile SingularAttribute<Fuentes, String> fntIdentificadorInterno;
    public static volatile SingularAttribute<Fuentes, Date> fntFechaRegistro;

}