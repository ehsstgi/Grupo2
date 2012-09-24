/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "ONIBUS")
@NamedQueries({
    @NamedQuery(name = "Onibus.findAll", query = "SELECT o FROM Onibus o"),
    @NamedQuery(name = "Onibus.findByCodOnibus", query = "SELECT o FROM Onibus o WHERE o.codOnibus = :codOnibus"),
    @NamedQuery(name = "Onibus.findByPlaca", query = "SELECT o FROM Onibus o WHERE o.placa = :placa"),
    @NamedQuery(name = "Onibus.findByMarca", query = "SELECT o FROM Onibus o WHERE o.marca = :marca"),
    @NamedQuery(name = "Onibus.findByModelo", query = "SELECT o FROM Onibus o WHERE o.modelo = :modelo"),
    @NamedQuery(name = "Onibus.findByAno", query = "SELECT o FROM Onibus o WHERE o.ano = :ano"),
    @NamedQuery(name = "Onibus.findByNome", query = "SELECT o FROM Onibus o WHERE o.nome = :nome"),
    @NamedQuery(name = "Onibus.findByQtassento", query = "SELECT o FROM Onibus o WHERE o.qtassento = :qtassento"),
    @NamedQuery(name = "Onibus.findByStatusMantonibus", query = "SELECT o FROM Onibus o WHERE o.statusMantonibus = :statusMantonibus")})
public class Onibus implements Serializable {
    @ManyToMany(mappedBy = "onibusCollection")
    private Collection<Funcionario> funcionarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "onibusCodOnibus")
    private Collection<Manutencaoonibus> manutencaoonibusCollection;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_ONIBUS")
    private BigDecimal codOnibus;
    @Size(max = 8)
    @Column(name = "PLACA")
    private String placa;
    @Size(max = 50)
    @Column(name = "MARCA")
    private String marca;
    @Column(name = "MODELO")
    private BigInteger modelo;
    @Column(name = "ANO")
    private BigInteger ano;
    @Size(max = 50)
    @Column(name = "NOME")
    private String nome;
    @Column(name = "QTASSENTO")
    private BigInteger qtassento;
    @Column(name = "STATUS_MANTONIBUS")
    private BigInteger statusMantonibus;
    @JoinColumn(name = "MANVI_COD_MANUTVIAGEM", referencedColumnName = "MANVI_COD_MANUTVIAGEM")
    @ManyToOne(optional = false)
    private Manutencaoviagem manviCodManutviagem;

    public Onibus() {
    }

    public Onibus(BigDecimal codOnibus) {
        this.codOnibus = codOnibus;
    }

    public BigDecimal getCodOnibus() {
        return codOnibus;
    }

    public void setCodOnibus(BigDecimal codOnibus) {
        this.codOnibus = codOnibus;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public BigInteger getModelo() {
        return modelo;
    }

    public void setModelo(BigInteger modelo) {
        this.modelo = modelo;
    }

    public BigInteger getAno() {
        return ano;
    }

    public void setAno(BigInteger ano) {
        this.ano = ano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigInteger getQtassento() {
        return qtassento;
    }

    public void setQtassento(BigInteger qtassento) {
        this.qtassento = qtassento;
    }

    public BigInteger getStatusMantonibus() {
        return statusMantonibus;
    }

    public void setStatusMantonibus(BigInteger statusMantonibus) {
        this.statusMantonibus = statusMantonibus;
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
        hash += (codOnibus != null ? codOnibus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Onibus)) {
            return false;
        }
        Onibus other = (Onibus) object;
        if ((this.codOnibus == null && other.codOnibus != null) || (this.codOnibus != null && !this.codOnibus.equals(other.codOnibus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.bean.Onibus[ codOnibus=" + codOnibus + " ]";
    }

    public Collection<Funcionario> getFuncionarioCollection() {
        return funcionarioCollection;
    }

    public void setFuncionarioCollection(Collection<Funcionario> funcionarioCollection) {
        this.funcionarioCollection = funcionarioCollection;
    }

    public Collection<Manutencaoonibus> getManutencaoonibusCollection() {
        return manutencaoonibusCollection;
    }

    public void setManutencaoonibusCollection(Collection<Manutencaoonibus> manutencaoonibusCollection) {
        this.manutencaoonibusCollection = manutencaoonibusCollection;
    }
    
}
