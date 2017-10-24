package br.edu.ifpe.recife.pdsw.model;

import br.edu.ifpe.recife.pdsw.model.Aluno;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-23T19:51:26")
@StaticMetamodel(Relatorioparental.class)
public class Relatorioparental_ { 

    public static volatile SingularAttribute<Relatorioparental, Integer> idrelatorioparental;
    public static volatile SingularAttribute<Relatorioparental, String> observacoes;
    public static volatile SingularAttribute<Relatorioparental, Float> facilidadeComDisciplina;
    public static volatile SingularAttribute<Relatorioparental, Float> lideranca;
    public static volatile SingularAttribute<Relatorioparental, Float> participacaoEmSala;
    public static volatile SingularAttribute<Relatorioparental, Float> comportamento;
    public static volatile SingularAttribute<Relatorioparental, Float> trabalhoEmEquipe;
    public static volatile SingularAttribute<Relatorioparental, Float> criatividade;
    public static volatile SingularAttribute<Relatorioparental, Float> motivacao;
    public static volatile SingularAttribute<Relatorioparental, Aluno> alunoIdaluno;

}