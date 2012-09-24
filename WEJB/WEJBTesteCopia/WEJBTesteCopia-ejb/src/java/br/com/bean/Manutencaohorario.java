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

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "MANUTENCAOHORARIO")
@NamedQueries({
    @NamedQuery(name = "Manutencaohorario.findAll", query = "SELECT m FROM Manutencaohorario m"),
    @NamedQuery(name = "Manutencaohorario.findByCodManuthorario", query = "SELECT m FROM Manutencaohorario m WHERE m.codManuthorario = :codManuthorario"),
    @NamedQuery(name = "Manutencaohorario.findByCodigolinha", query = "SELECT m FROM Manutencaohorario m WHERE m.codigolinha = :codigolinha"),
    @NamedQuery(name = "Manutencaohorario.findByHoraida", query = "SELECT m FROM Manutencaohorario m WHERE m.horaida = :horaida"),
    @NamedQuery(name = "Manutencaohorario.findByValor", query = "SELECT m FROM Manutencaohorario m WHERE m.valor = :valor")})
public class Manutencaohorario implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_MANUTHORARIO")
    private BigDecimal codManuthorario;
    @Column(name = "CODIGOLINHA")
    private BigInteger codigolinha;
    @Column(name = "HORAIDA")
    private BigInteger horaida;
    @Column(name = "VALOR")
    private BigInteger valor;
    @JoinColumn(name = "MANVI_COD_MANUTVIAGEM", referencedColumnName = "MANVI_COD_MANUTVIAGEM")
    @ManyToOne(optional = false)
    private Manutencaoviagem manviCodManutviagem;

    public Manutencaohorario() {
    }

    public Manutencaohorario(BigDecimal codManuthorario) {
        this.codManuthorario = codManuthorario;
    }

    public BigDecimal getCodManuthorario() {
        return codManuthorario;
    }

    public void setCodManuthorario(BigDecimal codManuthorario) {
        this.codManuthorario = codManuthorario;
    }

    public BigInteger getCodigolinha() {
        return codigolinha;
    }

    public void setCodigolinha(BigInteger codigolinha) {
        this.codigolinha = codigolinha;
    }

    public BigInteger getHoraida() {
        return horaida;
    }

    public void setHoraida(BigInteger horaida) {
        this.horaida = horaida;
    }

    public BigInteger getValor() {
        return valor;
    }

    public void setValor(BigInteger valor) {
        this.valor = valor;
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
        hash += (codManuthorario != null ? codManuthorario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Manutencaohorario)) {
            return false;
        }
        Manutencaohorario other = (Manutencaohorario) object;
        if ((this.codManuthorario == null && other.codManuthorario != null) || (this.codManuthorario != null && !this.codManuthorario.equals(other.codManuthorario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.bean.Manutencaohorario[ codManuthorario=" + codManuthorario + " ]";
    }
    
}
