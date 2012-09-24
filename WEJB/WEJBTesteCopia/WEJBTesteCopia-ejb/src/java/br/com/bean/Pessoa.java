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
@Table(name = "PESSOA")
@NamedQueries({
    @NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p"),
    @NamedQuery(name = "Pessoa.findByCpf", query = "SELECT p FROM Pessoa p WHERE p.cpf = :cpf"),
    @NamedQuery(name = "Pessoa.findByRg", query = "SELECT p FROM Pessoa p WHERE p.rg = :rg"),
    @NamedQuery(name = "Pessoa.findByNome", query = "SELECT p FROM Pessoa p WHERE p.nome = :nome"),
    @NamedQuery(name = "Pessoa.findByTelefone", query = "SELECT p FROM Pessoa p WHERE p.telefone = :telefone"),
    @NamedQuery(name = "Pessoa.findByNascimento", query = "SELECT p FROM Pessoa p WHERE p.nascimento = :nascimento"),
    @NamedQuery(name = "Pessoa.findBySexo", query = "SELECT p FROM Pessoa p WHERE p.sexo = :sexo"),
    @NamedQuery(name = "Pessoa.findByEstadocivil", query = "SELECT p FROM Pessoa p WHERE p.estadocivil = :estadocivil"),
    @NamedQuery(name = "Pessoa.findByEmail", query = "SELECT p FROM Pessoa p WHERE p.email = :email"),
    @NamedQuery(name = "Pessoa.findByTipopessoa", query = "SELECT p FROM Pessoa p WHERE p.tipopessoa = :tipopessoa")})
public class Pessoa implements Serializable {
    @Column(name =     "NASCIMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date nascimento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaCpf")
    private Collection<Funcionario> funcionarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaCpf")
    private Collection<Compracliente> compraclienteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaCpf")
    private Collection<Cartaocredito> cartaocreditoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaCpf")
    private Collection<Endereco> enderecoCollection;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CPF")
    private BigDecimal cpf;
    @Column(name = "RG")
    private BigInteger rg;
    @Size(max = 255)
    @Column(name = "NOME")
    private String nome;
    @Column(name = "TELEFONE")
    private BigInteger telefone;
    @Size(max = 1)
    @Column(name = "SEXO")
    private String sexo;
    @Size(max = 50)
    @Column(name = "ESTADOCIVIL")
    private String estadocivil;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 60)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPOPESSOA")
    private BigInteger tipopessoa;

    public Pessoa() {
    }

    public Pessoa(BigDecimal cpf) {
        this.cpf = cpf;
    }

    public Pessoa(BigDecimal cpf, BigInteger tipopessoa) {
        this.cpf = cpf;
        this.tipopessoa = tipopessoa;
    }

    public BigDecimal getCpf() {
        return cpf;
    }

    public void setCpf(BigDecimal cpf) {
        this.cpf = cpf;
    }

    public BigInteger getRg() {
        return rg;
    }

    public void setRg(BigInteger rg) {
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigInteger getTelefone() {
        return telefone;
    }

    public void setTelefone(BigInteger telefone) {
        this.telefone = telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(String estadocivil) {
        this.estadocivil = estadocivil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigInteger getTipopessoa() {
        return tipopessoa;
    }

    public void setTipopessoa(BigInteger tipopessoa) {
        this.tipopessoa = tipopessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cpf != null ? cpf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.cpf == null && other.cpf != null) || (this.cpf != null && !this.cpf.equals(other.cpf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.Bean.Pessoa[ cpf=" + cpf + " ]";
    }

    public Collection<Endereco> getEnderecoCollection() {
        return enderecoCollection;
    }

    public void setEnderecoCollection(Collection<Endereco> enderecoCollection) {
        this.enderecoCollection = enderecoCollection;
    }

    public Collection<Cartaocredito> getCartaocreditoCollection() {
        return cartaocreditoCollection;
    }

    public void setCartaocreditoCollection(Collection<Cartaocredito> cartaocreditoCollection) {
        this.cartaocreditoCollection = cartaocreditoCollection;
    }

    public Collection<Compracliente> getCompraclienteCollection() {
        return compraclienteCollection;
    }

    public void setCompraclienteCollection(Collection<Compracliente> compraclienteCollection) {
        this.compraclienteCollection = compraclienteCollection;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public Collection<Funcionario> getFuncionarioCollection() {
        return funcionarioCollection;
    }

    public void setFuncionarioCollection(Collection<Funcionario> funcionarioCollection) {
        this.funcionarioCollection = funcionarioCollection;
    }
    
}
