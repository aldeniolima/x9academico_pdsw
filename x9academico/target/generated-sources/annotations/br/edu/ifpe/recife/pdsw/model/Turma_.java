package br.edu.ifpe.recife.pdsw.model;

import br.edu.ifpe.recife.pdsw.model.Aluno;
import br.edu.ifpe.recife.pdsw.model.Professor;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-27T15:27:53")
@StaticMetamodel(Turma.class)
public class Turma_ { 

    public static volatile ListAttribute<Turma, Aluno> alunoList;
    public static volatile SingularAttribute<Turma, Integer> idturma;
    public static volatile SingularAttribute<Turma, String> serie;
    public static volatile SingularAttribute<Turma, Integer> qtdAluno;
    public static volatile SingularAttribute<Turma, Integer> numerosala;
    public static volatile ListAttribute<Turma, Professor> professorList;

}