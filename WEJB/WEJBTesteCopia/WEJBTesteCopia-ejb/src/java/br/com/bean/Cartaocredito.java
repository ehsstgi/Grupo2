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
@Table(name = "CARTAOCREDITO")
@NamedQueries({
    @NamedQuery(name = "Cartaocredito.findAll", query = "SELECT c FROM Cartaocredito c"),
    @NamedQuery(name = "Cartaocredito.findByCodCc", query = "SELECT c FROM Cartaocredito c WHERE c.codCc = :codCc"),
    @NamedQuery(name = "Cartaocredito.findByCodbanco", query = "SELECT c FROM Cartaocredito c WHERE c.codbanco = :codbanco"),
    @NamedQuery(name = "Cartaocredito.findByAgencia", query = "SELECT c FROM Cartaocredito c WHERE c.agencia = :agencia"),
    @NamedQuery(name = "Cartaocredito.findByContacorrente", query = "SELECT c FROM Cartaocredito c WHERE c.contacorrente = :contacorrente"),
    @NamedQuery(name = "Cartaocredito.findByNumcartao", query = "SELECT c FROM Cartaocredito c WHERE c.numcartao = :numcartao"),
    @NamedQuery(name = "Cartaocredito.findByCodseguranca", query = "SELECT c FROM Cartaocredito c WHERE c.codseguranca = :codseguranca"),
    @NamedQuery(name = "Cartaocredito.findByTipopessoa", query = "SELECT c FROM Cartaocredito c WHERE c.tipopessoa = :tipopessoa")})
public class Cartaocredito implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CC")
    private BigDecimal codCc;
    @Column(name = "CODBANCO")
    private BigInteger codbanco;
    @Column(name = "AGENCIA")
    private BigInteger agencia;
    @Column(name = "CONTACORRENTE")
    private BigInteger contacorrente;
    @Column(name = "NUMCARTAO")
    private BigInteger numcartao;
    @Column(name = "CODSEGURANCA")
    private BigInteger codseguranca;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPOPESSOA")
    private BigInteger tipopessoa;
    @JoinColumn(name = "PESSOA_CPF", referencedColumnName = "CPF")
    @ManyToOne(optional = false)
    private Pessoa pessoaCpf;

    public Cartaocredito() {
    }

    public Cartaocredito(BigDecimal codCc) {
        this.codCc = codCc;
    }

    public Cartaocredito(BigDecimal codCc, BigInteger tipopessoa) {
        this.codCc = codCc;
        this.tipopessoa = tipopessoa;
    }

    public BigDecimal getCodCc() {
        return codCc;
    }

    public void setCodCc(BigDecimal codCc) {
        this.codCc = codCc;
    }

    public BigInteger getCodbanco() {
        return codbanco;
    }

    public void setCodbanco(BigInteger codbanco) {
        this.codbanco = codbanco;
    }

    public BigInteger getAgencia() {
        return agencia;
    }

    public void setAgencia(BigInteger agencia) {
        this.agencia = agencia;
    }

    public BigInteger getContacorrente() {
        return contacorrente;
    }

    public void setContacorrente(BigInteger contacorrente) {
        this.contacorrente = contacorrente;
    }

    public BigInteger getNumcartao() {
        return numcartao;
    }

    public void setNumcartao(BigInteger numcartao) {
        this.numcartao = numcartao;
    }

    public BigInteger getCodseguranca() {
        return codseguranca;
    }

    public void setCodseguranca(BigInteger codseguranca) {
        this.codseguranca = codseguranca;
    }

    public BigInteger getTipopessoa() {
        return tipopessoa;
    }

    public void setTipopessoa(BigInteger tipopessoa) {
        this.tipopessoa = tipopessoa;
    }

    public Pessoa getPessoaCpf() {
        return pessoaCpf;
    }

    public void setPessoaCpf(Pessoa pessoaCpf) {
        this.pessoaCpf = pessoaCpf;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCc != null ? codCc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cartaocredito)) {
            return false;
        }
        Cartaocredito other = (Cartaocredito) object;
        if ((this.codCc == null && other.codCc != null) || (this.codCc != null && !this.codCc.equals(other.codCc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.bean.Cartaocredito[ codCc=" + codCc + " ]";
    }
    
}
