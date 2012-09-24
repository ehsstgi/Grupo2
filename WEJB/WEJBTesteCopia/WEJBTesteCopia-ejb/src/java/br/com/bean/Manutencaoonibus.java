/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "MANUTENCAOONIBUS")
@NamedQueries({
    @NamedQuery(name = "Manutencaoonibus.findAll", query = "SELECT m FROM Manutencaoonibus m"),
    @NamedQuery(name = "Manutencaoonibus.findByCodManutonibus", query = "SELECT m FROM Manutencaoonibus m WHERE m.codManutonibus = :codManutonibus"),
    @NamedQuery(name = "Manutencaoonibus.findByPlaca", query = "SELECT m FROM Manutencaoonibus m WHERE m.placa = :placa"),
    @NamedQuery(name = "Manutencaoonibus.findByStatuscombustivel", query = "SELECT m FROM Manutencaoonibus m WHERE m.statuscombustivel = :statuscombustivel"),
    @NamedQuery(name = "Manutencaoonibus.findByStatusdocumentacao", query = "SELECT m FROM Manutencaoonibus m WHERE m.statusdocumentacao = :statusdocumentacao"),
    @NamedQuery(name = "Manutencaoonibus.findByStatusipva", query = "SELECT m FROM Manutencaoonibus m WHERE m.statusipva = :statusipva"),
    @NamedQuery(name = "Manutencaoonibus.findByStatusmanutmecanica", query = "SELECT m FROM Manutencaoonibus m WHERE m.statusmanutmecanica = :statusmanutmecanica"),
    @NamedQuery(name = "Manutencaoonibus.findByDataproxverifica", query = "SELECT m FROM Manutencaoonibus m WHERE m.dataproxverifica = :dataproxverifica")})
public class Manutencaoonibus implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_MANUTONIBUS")
    private BigDecimal codManutonibus;
    @Size(max = 8)
    @Column(name = "PLACA")
    private String placa;
    @Column(name = "STATUSCOMBUSTIVEL")
    private BigInteger statuscombustivel;
    @Column(name = "STATUSDOCUMENTACAO")
    private BigInteger statusdocumentacao;
    @Column(name = "STATUSIPVA")
    private BigInteger statusipva;
    @Column(name = "STATUSMANUTMECANICA")
    private BigInteger statusmanutmecanica;
    @Column(name = "DATAPROXVERIFICA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataproxverifica;
    @JoinColumn(name = "ONIBUS_COD_ONIBUS", referencedColumnName = "COD_ONIBUS")
    @ManyToOne(optional = false)
    private Onibus onibusCodOnibus;

    public Manutencaoonibus() {
    }

    public Manutencaoonibus(BigDecimal codManutonibus) {
        this.codManutonibus = codManutonibus;
    }

    public BigDecimal getCodManutonibus() {
        return codManutonibus;
    }

    public void setCodManutonibus(BigDecimal codManutonibus) {
        this.codManutonibus = codManutonibus;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public BigInteger getStatuscombustivel() {
        return statuscombustivel;
    }

    public void setStatuscombustivel(BigInteger statuscombustivel) {
        this.statuscombustivel = statuscombustivel;
    }

    public BigInteger getStatusdocumentacao() {
        return statusdocumentacao;
    }

    public void setStatusdocumentacao(BigInteger statusdocumentacao) {
        this.statusdocumentacao = statusdocumentacao;
    }

    public BigInteger getStatusipva() {
        return statusipva;
    }

    public void setStatusipva(BigInteger statusipva) {
        this.statusipva = statusipva;
    }

    public BigInteger getStatusmanutmecanica() {
        return statusmanutmecanica;
    }

    public void setStatusmanutmecanica(BigInteger statusmanutmecanica) {
        this.statusmanutmecanica = statusmanutmecanica;
    }

    public Date getDataproxverifica() {
        return dataproxverifica;
    }

    public void setDataproxverifica(Date dataproxverifica) {
        this.dataproxverifica = dataproxverifica;
    }

    public Onibus getOnibusCodOnibus() {
        return onibusCodOnibus;
    }

    public void setOnibusCodOnibus(Onibus onibusCodOnibus) {
        this.onibusCodOnibus = onibusCodOnibus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codManutonibus != null ? codManutonibus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Manutencaoonibus)) {
            return false;
        }
        Manutencaoonibus other = (Manutencaoonibus) object;
        if ((this.codManutonibus == null && other.codManutonibus != null) || (this.codManutonibus != null && !this.codManutonibus.equals(other.codManutonibus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.bean.Manutencaoonibus[ codManutonibus=" + codManutonibus + " ]";
    }
    
}
