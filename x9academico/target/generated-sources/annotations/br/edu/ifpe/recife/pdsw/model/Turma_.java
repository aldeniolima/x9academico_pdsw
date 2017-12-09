package br.edu.ifpe.recife.pdsw.model;

import br.edu.ifpe.recife.pdsw.model.Aluno;
import br.edu.ifpe.recife.pdsw.model.Professor;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-09T02:11:30")
@StaticMetamodel(Turma.class)
public class Turma_ { 

    public static volatile SingularAttribute<Turma, Professor> professor;
    public static volatile SingularAttribute<Turma, Integer> idTurma;
    public static volatile ListAttribute<Turma, Aluno> alunos;
    public static volatile SingularAttribute<Turma, String> serie;
    public static volatile SingularAttribute<Turma, Integer> numeroSala;
    public static volatile SingularAttribute<Turma, Integer> qtdAluno;
    public static volatile SingularAttribute<Turma, String> turno;

}