package br.edu.ifpe.recife.pdsw.model;

import br.edu.ifpe.recife.pdsw.model.Relatorioparental;
import br.edu.ifpe.recife.pdsw.model.Responsavel;
import br.edu.ifpe.recife.pdsw.model.Turma;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-27T15:27:53")
@StaticMetamodel(Aluno.class)
public class Aluno_ { 

    public static volatile SingularAttribute<Aluno, Responsavel> responsavelIdresponsavel;
    public static volatile SingularAttribute<Aluno, Turma> turmaIdturma;
    public static volatile SingularAttribute<Aluno, String> matricula;
    public static volatile SingularAttribute<Aluno, String> nome;
    public static volatile SingularAttribute<Aluno, Integer> idaluno;
    public static volatile SingularAttribute<Aluno, String> dataNascimento;
    public static volatile SingularAttribute<Aluno, String> deficiencia;
    public static volatile ListAttribute<Aluno, Relatorioparental> relatorioparentalList;

}