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
@Table(name = "MANUTECAOROTA")
@NamedQueries({
    @NamedQuery(name = "Manutecaorota.findAll", query = "SELECT m FROM Manutecaorota m"),
    @NamedQuery(name = "Manutecaorota.findByCodManutrota", query = "SELECT m FROM Manutecaorota m WHERE m.codManutrota = :codManutrota"),
    @NamedQuery(name = "Manutecaorota.findByCodigolinha", query = "SELECT m FROM Manutecaorota m WHERE m.codigolinha = :codigolinha"),
    @NamedQuery(name = "Manutecaorota.findByParada1", query = "SELECT m FROM Manutecaorota m WHERE m.parada1 = :parada1"),
    @NamedQuery(name = "Manutecaorota.findByParada2", query = "SELECT m FROM Manutecaorota m WHERE m.parada2 = :parada2"),
    @NamedQuery(name = "Manutecaorota.findByOutrasparadas", query = "SELECT m FROM Manutecaorota m WHERE m.outrasparadas = :outrasparadas")})
public class Manutecaorota implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_MANUTROTA")
    private BigDecimal codManutrota;
    @Column(name = "CODIGOLINHA")
    private BigInteger codigolinha;
    @Size(max = 120)
    @Column(name = "PARADA1")
    private String parada1;
    @Size(max = 120)
    @Column(name = "PARADA2")
    private String parada2;
    @Size(max = 120)
    @Column(name = "OUTRASPARADAS")
    private String outrasparadas;
    @JoinColumn(name = "MANVI_COD_MANUTVIAGEM", referencedColumnName = "MANVI_COD_MANUTVIAGEM")
    @ManyToOne(optional = false)
    private Manutencaoviagem manviCodManutviagem;

    public Manutecaorota() {
    }

    public Manutecaorota(BigDecimal codManutrota) {
        this.codManutrota = codManutrota;
    }

    public BigDecimal getCodManutrota() {
        return codManutrota;
    }

    public void setCodManutrota(BigDecimal codManutrota) {
        this.codManutrota = codManutrota;
    }

    public BigInteger getCodigolinha() {
        return codigolinha;
    }

    public void setCodigolinha(BigInteger codigolinha) {
        this.codigolinha = codigolinha;
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

    public String getOutrasparadas() {
        return outrasparadas;
    }

    public void setOutrasparadas(String outrasparadas) {
        this.outrasparadas = outrasparadas;
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
        hash += (codManutrota != null ? codManutrota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Manutecaorota)) {
            return false;
        }
        Manutecaorota other = (Manutecaorota) object;
        if ((this.codManutrota == null && other.codManutrota != null) || (this.codManutrota != null && !this.codManutrota.equals(other.codManutrota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.bean.Manutecaorota[ codManutrota=" + codManutrota + " ]";
    }
    
}
