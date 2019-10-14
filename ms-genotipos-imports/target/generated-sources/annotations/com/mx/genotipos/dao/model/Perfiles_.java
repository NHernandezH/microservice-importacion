package com.mx.genotipos.dao.model;

import com.mx.genotipos.dao.model.CatTipoPerfil;
import com.mx.genotipos.dao.model.Importaciones;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-12T11:15:43")
@StaticMetamodel(Perfiles.class)
public class Perfiles_ { 

    public static volatile SingularAttribute<Perfiles, Integer> perUsuarioCreo;
    public static volatile SingularAttribute<Perfiles, CatTipoPerfil> perTipo;
    public static volatile SingularAttribute<Perfiles, Integer> perId;
    public static volatile SingularAttribute<Perfiles, Integer> perPerfilOriginal;
    public static volatile SingularAttribute<Perfiles, Integer> perBajaLogica;
    public static volatile SingularAttribute<Perfiles, String> perIdentificador;
    public static volatile SingularAttribute<Perfiles, Date> perFechaRegistro;
    public static volatile SingularAttribute<Perfiles, Integer> perUsuarioReviso;
    public static volatile SingularAttribute<Perfiles, String> perMotivoDesestimacion;
    public static volatile SingularAttribute<Perfiles, Importaciones> perIdImportacion;

}