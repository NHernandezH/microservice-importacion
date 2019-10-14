package com.mx.genotipos.dao.model;

import com.mx.genotipos.dao.model.Perfiles;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-12T11:15:43")
@StaticMetamodel(CatTipoPerfil.class)
public class CatTipoPerfil_ { 

    public static volatile SingularAttribute<CatTipoPerfil, Integer> tpId;
    public static volatile ListAttribute<CatTipoPerfil, Perfiles> perfilesList;
    public static volatile SingularAttribute<CatTipoPerfil, Boolean> tpBajaLogica;
    public static volatile SingularAttribute<CatTipoPerfil, Date> tpFechaRegistro;
    public static volatile SingularAttribute<CatTipoPerfil, String> tpDescripcion;

}