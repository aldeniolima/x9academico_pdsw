package br.edu.ifpe.recife.pdsw.model;

import br.edu.ifpe.recife.pdsw.model.Turma;
import br.edu.ifpe.recife.pdsw.model.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-23T19:51:26")
@StaticMetamodel(Professor.class)
public class Professor_ extends Usuario_ {

    public static volatile SingularAttribute<Professor, Turma> idturma;
    public static volatile SingularAttribute<Professor, Usuario> usuario;

}