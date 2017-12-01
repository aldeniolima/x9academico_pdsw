package br.edu.ifpe.recife.pdsw.model;

import br.edu.ifpe.recife.pdsw.model.RelatorioParental;
import br.edu.ifpe.recife.pdsw.model.Responsavel;
import br.edu.ifpe.recife.pdsw.model.Turma;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-01T01:33:37")
@StaticMetamodel(Aluno.class)
public class Aluno_ { 

    public static volatile SingularAttribute<Aluno, RelatorioParental> relatorioParental;
    public static volatile SingularAttribute<Aluno, String> matricula;
    public static volatile SingularAttribute<Aluno, Long> idAluno;
    public static volatile SingularAttribute<Aluno, String> nome;
    public static volatile SingularAttribute<Aluno, Date> dataNascimento;
    public static volatile SingularAttribute<Aluno, Turma> turma;
    public static volatile SingularAttribute<Aluno, Responsavel> responsavel;
    public static volatile SingularAttribute<Aluno, String> deficiencia;

}