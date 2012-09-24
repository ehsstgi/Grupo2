/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "MANUTENCAOLINHA")
@NamedQueries({
    @NamedQuery(name = "Manutencaolinha.findAll", query = "SELECT m FROM Manutencaolinha m"),
    @NamedQuery(name = "Manutencaolinha.findByCodManutlinha", query = "SELECT m FROM Manutencaolinha m WHERE m.codManutlinha = :codManutlinha"),
    @NamedQuery(name = "Manutencaolinha.findByPontoini", query = "SELECT m FROM Manutencaolinha m WHERE m.pontoini = :pontoini"),
    @NamedQuery(name = "Manutencaolinha.findByPontofin", query = "SELECT m FROM Manutencaolinha m WHERE m.pontofin = :pontofin"),
    @NamedQuery(name = "Manutencaolinha.findByCodigolinha", query = "SELECT m FROM Manutencaolinha m WHERE m.codigolinha = :codigolinha")})
public class Manutencaolinha implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_MANUTLINHA")
    private BigDecimal codManutlinha;
    @Size(max = 120)
    @Column(name = "PONTOINI")
    private String pontoini;
    @Size(max = 120)
    @Column(name = "PONTOFIN")
    private String pontofin;
    @Column(name = "CODIGOLINHA")
    private BigInteger codigolinha;
    @JoinColumn(name = "MANVI_COD_MANUTVIAGEM", referencedColumnName = "MANVI_COD_MANUTVIAGEM")
    @ManyToOne(optional = false)
    private Manutencaoviagem manviCodManutviagem;

    public Manutencaolinha() {
    }

    public Manutencaolinha(BigDecimal codManutlinha) {
        this.codManutlinha = codManutlinha;
    }

    public BigDecimal getCodManutlinha() {
        return codManutlinha;
    }

    public void setCodManutlinha(BigDecimal codManutlinha) {
        this.codManutlinha = codManutlinha;
    }

    public String getPontoini() {
        return pontoini;
    }

    public void setPontoini(String pontoini) {
        this.pontoini = pontoini;
    }

    public String getPontofin() {
        return pontofin;
    }

    public void setPontofin(String pontofin) {
        this.pontofin = pontofin;
    }

    public BigInteger getCodigolinha() {
        return codigolinha;
    }

    public void setCodigolinha(BigInteger codigolinha) {
        this.codigolinha = codigolinha;
    }

    public Manutencaoviagem getManviCodManutviagem() {
        return manviCodManutviagem;
    }

    public void setManviCodManutviagem(Manutencaoviagem manviCodManutviagem) {
        this.manviCodManutviagem = manviCodManutviagem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codManutlinha != null ? codManutlinha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Manutencaolinha)) {
            return false;
        }
        Manutencaolinha other = (Manutencaolinha) object;
        if ((this.codManutlinha == null && other.codManutlinha != null) || (this.codManutlinha != null && !this.codManutlinha.equals(other.codManutlinha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.bean.Manutencaolinha[ codManutlinha=" + codManutlinha + " ]";
    }
    
}
