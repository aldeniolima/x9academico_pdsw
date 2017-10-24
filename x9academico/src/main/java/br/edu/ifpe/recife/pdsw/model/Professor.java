package br.edu.ifpe.recife.pdsw.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author aldo_neto
 */
@Entity
@Table(name = "professor")
@PrimaryKeyJoinColumn(name="idprofessor", referencedColumnName = "idusuario")
public class Professor extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    /*@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idprofessor")
    private Integer idprofessor;*/
    @JoinColumn(name = "idprofessor", referencedColumnName = "idusuario", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "idturma", referencedColumnName = "idturma")
    @ManyToOne(optional = false)
    private Turma idturma;

    public Professor() {
    }

   /* public Professor(Integer idprofessor) {
        this.idprofessor = idprofessor;
    }

    public Integer getIdprofessor() {
        return idprofessor;
    }

    public void setIdprofessor(Integer idprofessor) {
        this.idprofessor = idprofessor;
    }*/

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Turma getIdturma() {
        return idturma;
    }

    public void setIdturma(Turma idturma) {
        this.idturma = idturma;
    }

  /*  @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprofessor != null ? idprofessor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Professor)) {
            return false;
        }
        Professor other = (Professor) object;
        if ((this.idprofessor == null && other.idprofessor != null) || (this.idprofessor != null && !this.idprofessor.equals(other.idprofessor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifpe.recife.pdsw.model.Professor[ idprofessor=" + idprofessor + " ]";
    }*/

}
