package br.edu.ifpe.recife.pdsw.model;

import br.edu.ifpe.recife.pdsw.model.Aluno;
import br.edu.ifpe.recife.pdsw.model.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-23T19:51:26")
@StaticMetamodel(Responsavel.class)
public class Responsavel_ extends Usuario_ {

    public static volatile ListAttribute<Responsavel, Aluno> alunoList;
    public static volatile SingularAttribute<Responsavel, String> parentesco;
    public static volatile SingularAttribute<Responsavel, Usuario> usuario;

}