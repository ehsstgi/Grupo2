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

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "MANUTENCAOVIAGEM")
@NamedQueries({
    @NamedQuery(name = "Manutencaoviagem.findAll", query = "SELECT m FROM Manutencaoviagem m"),
    @NamedQuery(name = "Manutencaoviagem.findByManviCodManutviagem", query = "SELECT m FROM Manutencaoviagem m WHERE m.manviCodManutviagem = :manviCodManutviagem"),
    @NamedQuery(name = "Manutencaoviagem.findByCodigolinha", query = "SELECT m FROM Manutencaoviagem m WHERE m.codigolinha = :codigolinha")})
public class Manutencaoviagem implements Serializable {
    @ManyToMany(mappedBy = "manutencaoviagemCollection")
    private Collection<Funcionario> funcionarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manviCodManutviagem")
    private Collection<Manutecaorota> manutecaorotaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manviCodManutviagem")
    private Collection<Manutencaohorario> manutencaohorarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manviCodManutviagem")
    private Collection<Manutencaoassento> manutencaoassentoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manviCodManutviagem")
    private Collection<Manutencaolinha> manutencaolinhaCollection;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MANVI_COD_MANUTVIAGEM")
    private BigDecimal manviCodManutviagem;
    @Column(name = "CODIGOLINHA")
    private BigInteger codigolinha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manviCodManutviagem")
    private Collection<Onibus> onibusCollection;

    public Manutencaoviagem() {
    }

    public Manutencaoviagem(BigDecimal manviCodManutviagem) {
        this.manviCodManutviagem = manviCodManutviagem;
    }

    public BigDecimal getManviCodManutviagem() {
        return manviCodManutviagem;
    }

    public void setManviCodManutviagem(BigDecimal manviCodManutviagem) {
        this.manviCodManutviagem = manviCodManutviagem;
    }

    public BigInteger getCodigolinha() {
        return codigolinha;
    }

    public void setCodigolinha(BigInteger codigolinha) {
        this.codigolinha = codigolinha;
    }

    public Collection<Onibus> getOnibusCollection() {
        return onibusCollection;
    }

    public void setOnibusCollection(Collection<Onibus> onibusCollection) {
        this.onibusCollection = onibusCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (manviCodManutviagem != null ? manviCodManutviagem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Manutencaoviagem)) {
            return false;
        }
        Manutencaoviagem other = (Manutencaoviagem) object;
        if ((this.manviCodManutviagem == null && other.manviCodManutviagem != null) || (this.manviCodManutviagem != null && !this.manviCodManutviagem.equals(other.manviCodManutviagem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.bean.Manutencaoviagem[ manviCodManutviagem=" + manviCodManutviagem + " ]";
    }

    public Collection<Funcionario> getFuncionarioCollection() {
        return funcionarioCollection;
    }

    public void setFuncionarioCollection(Collection<Funcionario> funcionarioCollection) {
        this.funcionarioCollection = funcionarioCollection;
    }

    public Collection<Manutecaorota> getManutecaorotaCollection() {
        return manutecaorotaCollection;
    }

    public void setManutecaorotaCollection(Collection<Manutecaorota> manutecaorotaCollection) {
        this.manutecaorotaCollection = manutecaorotaCollection;
    }

    public Collection<Manutencaohorario> getManutencaohorarioCollection() {
        return manutencaohorarioCollection;
    }

    public void setManutencaohorarioCollection(Collection<Manutencaohorario> manutencaohorarioCollection) {
        this.manutencaohorarioCollection = manutencaohorarioCollection;
    }

    public Collection<Manutencaoassento> getManutencaoassentoCollection() {
        return manutencaoassentoCollection;
    }

    public void setManutencaoassentoCollection(Collection<Manutencaoassento> manutencaoassentoCollection) {
        this.manutencaoassentoCollection = manutencaoassentoCollection;
    }

    public Collection<Manutencaolinha> getManutencaolinhaCollection() {
        return manutencaolinhaCollection;
    }

    public void setManutencaolinhaCollection(Collection<Manutencaolinha> manutencaolinhaCollection) {
        this.manutencaolinhaCollection = manutencaolinhaCollection;
    }
    
}
