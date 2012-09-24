/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "FUNCIONARIO")
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f"),
    @NamedQuery(name = "Funcionario.findByCodigoFunc", query = "SELECT f FROM Funcionario f WHERE f.codigoFunc = :codigoFunc"),
    @NamedQuery(name = "Funcionario.findByNacionalidade", query = "SELECT f FROM Funcionario f WHERE f.nacionalidade = :nacionalidade"),
    @NamedQuery(name = "Funcionario.findByDtadmissao", query = "SELECT f FROM Funcionario f WHERE f.dtadmissao = :dtadmissao"),
    @NamedQuery(name = "Funcionario.findByDtdesligamento", query = "SELECT f FROM Funcionario f WHERE f.dtdesligamento = :dtdesligamento"),
    @NamedQuery(name = "Funcionario.findBySalario", query = "SELECT f FROM Funcionario f WHERE f.salario = :salario"),
    @NamedQuery(name = "Funcionario.findByStatusFunc", query = "SELECT f FROM Funcionario f WHERE f.statusFunc = :statusFunc"),
    @NamedQuery(name = "Funcionario.findByTipopessoa", query = "SELECT f FROM Funcionario f WHERE f.tipopessoa = :tipopessoa")})
public class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_FUNC")
    private BigDecimal codigoFunc;
    @Size(max = 50)
    @Column(name = "NACIONALIDADE")
    private String nacionalidade;
    @Column(name = "DTADMISSAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtadmissao;
    @Column(name = "DTDESLIGAMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtdesligamento;
    @Column(name = "SALARIO")
    private BigInteger salario;
    @Column(name = "STATUS_FUNC")
    private BigInteger statusFunc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPOPESSOA")
    private BigInteger tipopessoa;
    @JoinTable(name = "FUNC_MANUTENCAOVIAGEM", joinColumns = {
        @JoinColumn(name = "FUNCIONARIO_CODIGO_FUNC", referencedColumnName = "CODIGO_FUNC")}, inverseJoinColumns = {
        @JoinColumn(name = "MANVI_COD_MANUTVIAGEM", referencedColumnName = "MANVI_COD_MANUTVIAGEM")})
    @ManyToMany
    private Collection<Manutencaoviagem> manutencaoviagemCollection;
    @JoinTable(name = "FUNC_MANUTENCAOONIBUS", joinColumns = {
        @JoinColumn(name = "FUNCIONARIO_CODIGO_FUNC", referencedColumnName = "CODIGO_FUNC")}, inverseJoinColumns = {
        @JoinColumn(name = "ONIBUS_COD_ONIBUS", referencedColumnName = "COD_ONIBUS")})
    @ManyToMany
    private Collection<Onibus> onibusCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionarioCodigoFunc")
    private Collection<Compraanonima> compraanonimaCollection;
    @JoinColumn(name = "PESSOA_CPF", referencedColumnName = "CPF")
    @ManyToOne(optional = false)
    private Pessoa pessoaCpf;

    public Funcionario() {
    }

    public Funcionario(BigDecimal codigoFunc) {
        this.codigoFunc = codigoFunc;
    }

    public Funcionario(BigDecimal codigoFunc, BigInteger tipopessoa) {
        this.codigoFunc = codigoFunc;
        this.tipopessoa = tipopessoa;
    }

    public BigDecimal getCodigoFunc() {
        return codigoFunc;
    }

    public void setCodigoFunc(BigDecimal codigoFunc) {
        this.codigoFunc = codigoFunc;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Date getDtadmissao() {
        return dtadmissao;
    }

    public void setDtadmissao(Date dtadmissao) {
        this.dtadmissao = dtadmissao;
    }

    public Date getDtdesligamento() {
        return dtdesligamento;
    }

    public void setDtdesligamento(Date dtdesligamento) {
        this.dtdesligamento = dtdesligamento;
    }

    public BigInteger getSalario() {
        return salario;
    }

    public void setSalario(BigInteger salario) {
        this.salario = salario;
    }

    public BigInteger getStatusFunc() {
        return statusFunc;
    }

    public void setStatusFunc(BigInteger statusFunc) {
        this.statusFunc = statusFunc;
    }

    public BigInteger getTipopessoa() {
        return tipopessoa;
    }

    public void setTipopessoa(BigInteger tipopessoa) {
        this.tipopessoa = tipopessoa;
    }

    public Collection<Manutencaoviagem> getManutencaoviagemCollection() {
        return manutencaoviagemCollection;
    }

    public void setManutencaoviagemCollection(Collection<Manutencaoviagem> manutencaoviagemCollection) {
        this.manutencaoviagemCollection = manutencaoviagemCollection;
    }

    public Collection<Onibus> getOnibusCollection() {
        return onibusCollection;
    }

    public void setOnibusCollection(Collection<Onibus> onibusCollection) {
        this.onibusCollection = onibusCollection;
    }

    public Collection<Compraanonima> getCompraanonimaCollection() {
        return compraanonimaCollection;
    }

    public void setCompraanonimaCollection(Collection<Compraanonima> compraanonimaCollection) {
        this.compraanonimaCollection = compraanonimaCollection;
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
        hash += (codigoFunc != null ? codigoFunc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.codigoFunc == null && other.codigoFunc != null) || (this.codigoFunc != null && !this.codigoFunc.equals(other.codigoFunc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.bean.Funcionario[ codigoFunc=" + codigoFunc + " ]";
    }
    
}
