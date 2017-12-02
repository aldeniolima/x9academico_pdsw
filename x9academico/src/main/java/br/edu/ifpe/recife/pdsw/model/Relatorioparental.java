package br.edu.ifpe.recife.pdsw.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;


@Entity
@Table(name = "relatorioparental")
public class Relatorioparental implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRelatorioParental")
    private Long idRelatorioParental;

    @DecimalMin("0.0")
    @DecimalMax("10.0")
    @Column(name = "lideranca")
    private double lideranca;

    @DecimalMin("0.0")
    @DecimalMax("10.0")
    @Column(name = "trabalhoEmEquipe")
    private double trabalhoEmEquipe;

    @DecimalMin("0.0")
    @DecimalMax("10.0")
    @Column(name = "participacaoEmSala")
    private double participacaoEmSala;

    @DecimalMin("0.0")
    @DecimalMax("10.0")
    @Column(name = "motivacao")
    private double motivacao;

    @DecimalMin("0.0")
    @DecimalMax("10.0")
    @Column(name = "criatividade")
    private double criatividade;

    @Size(max = 150)
    @Column(name = "observacoes")
    private String observacoes;

    public Relatorioparental() {
    }

    public Relatorioparental(Long idRelatorioParental) {
        this.idRelatorioParental = idRelatorioParental;
    }

    public Long getIdRelatorioParental() {
        return idRelatorioParental;
    }

    public void setIdRelatorioParental(Long idRelatorioParental) {
        this.idRelatorioParental = idRelatorioParental;
    }

    public Double getCriatividade() {
        return criatividade;
    }

    public void setCriatividade(Double criatividade) {
        this.criatividade = criatividade;
    }

    public Double getLideranca() {
        return lideranca;
    }

    public void setLideranca(Double lideranca) {
        this.lideranca = lideranca;
    }

    public Double getMotivacao() {
        return motivacao;
    }

    public void setMotivacao(Double motivacao) {
        this.motivacao = motivacao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Double getParticipacaoEmSala() {
        return participacaoEmSala;
    }

    public void setParticipacaoEmSala(Double participacaoEmSala) {
        this.participacaoEmSala = participacaoEmSala;
    }

    public Double getTrabalhoEmEquipe() {
        return trabalhoEmEquipe;
    }

    public void setTrabalhoEmEquipe(Double trabalhoEmEquipe) {
        this.trabalhoEmEquipe = trabalhoEmEquipe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRelatorioParental != null ? idRelatorioParental.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relatorioparental)) {
            return false;
        }
        Relatorioparental other = (Relatorioparental) object;
        if ((this.idRelatorioParental == null && other.idRelatorioParental != null) || (this.idRelatorioParental != null && !this.idRelatorioParental.equals(other.idRelatorioParental))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifpe.recife.pdsw.model.Relatorioparental[ idRelatorioParental=" + idRelatorioParental + " ]";
    }

}
