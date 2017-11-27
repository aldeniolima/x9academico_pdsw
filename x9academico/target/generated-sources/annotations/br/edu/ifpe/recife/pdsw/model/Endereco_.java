package br.edu.ifpe.recife.pdsw.model;

import br.edu.ifpe.recife.pdsw.model.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-27T15:27:53")
@StaticMetamodel(Endereco.class)
public class Endereco_ { 

    public static volatile SingularAttribute<Endereco, String> uf;
    public static volatile SingularAttribute<Endereco, String> cidade;
    public static volatile SingularAttribute<Endereco, Integer> numeroend;
    public static volatile SingularAttribute<Endereco, Usuario> usuario;
    public static volatile SingularAttribute<Endereco, Integer> idendereco;
    public static volatile SingularAttribute<Endereco, String> rua;
    public static volatile SingularAttribute<Endereco, String> cep;

}