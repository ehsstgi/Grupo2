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
@Table(name = "MANUTENCAOASSENTO")
@NamedQueries({
    @NamedQuery(name = "Manutencaoassento.findAll", query = "SELECT m FROM Manutencaoassento m"),
    @NamedQuery(name = "Manutencaoassento.findByCodManutassento", query = "SELECT m FROM Manutencaoassento m WHERE m.codManutassento = :codManutassento"),
    @NamedQuery(name = "Manutencaoassento.findByCodigolinha", query = "SELECT m FROM Manutencaoassento m WHERE m.codigolinha = :codigolinha"),
    @NamedQuery(name = "Manutencaoassento.findByNumassento", query = "SELECT m FROM Manutencaoassento m WHERE m.numassento = :numassento"),
    @NamedQuery(name = "Manutencaoassento.findByParada1", query = "SELECT m FROM Manutencaoassento m WHERE m.parada1 = :parada1"),
    @NamedQuery(name = "Manutencaoassento.findByParada2", query = "SELECT m FROM Manutencaoassento m WHERE m.parada2 = :parada2")})
public class Manutencaoassento implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_MANUTASSENTO")
    private BigDecimal codManutassento;
    @Column(name = "CODIGOLINHA")
    private BigInteger codigolinha;
    @Column(name = "NUMASSENTO")
    private BigInteger numassento;
    @Size(max = 120)
    @Column(name = "PARADA1")
    private String parada1;
    @Size(max = 120)
    @Column(name = "PARADA2")
    private String parada2;
    @JoinColumn(name = "MANVI_COD_MANUTVIAGEM", referencedColumnName = "MANVI_COD_MANUTVIAGEM")
    @ManyToOne(optional = false)
    private Manutencaoviagem manviCodManutviagem;

    public Manutencaoassento() {
    }

    public Manutencaoassento(BigDecimal codManutassento) {
        this.codManutassento = codManutassento;
    }

    public BigDecimal getCodManutassento() {
        return codManutassento;
    }

    public void setCodManutassento(BigDecimal codManutassento) {
        this.codManutassento = codManutassento;
    }

    public BigInteger getCodigolinha() {
        return codigolinha;
    }

    public void setCodigolinha(BigInteger codigolinha) {
        this.codigolinha = codigolinha;
    }

    public BigInteger getNumassento() {
        return numassento;
    }

    public void setNumassento(BigInteger numassento) {
        this.numassento = numassento;
    }

    public String getParada1() {
        return parada1;
    }

    public void setParada1(String parada1) {
        this.parada1 = parada1;
    }

    public String getParada2() {
        return parada2;
    }

    public void setParada2(String parada2) {
        this.parada2 = parada2;
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
        hash += (codManutassento != null ? codManutassento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Manutencaoassento)) {
            return false;
        }
        Manutencaoassento other = (Manutencaoassento) object;
        if ((this.codManutassento == null && other.codManutassento != null) || (this.codManutassento != null && !this.codManutassento.equals(other.codManutassento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.bean.Manutencaoassento[ codManutassento=" + codManutassento + " ]";
    }
    
}
