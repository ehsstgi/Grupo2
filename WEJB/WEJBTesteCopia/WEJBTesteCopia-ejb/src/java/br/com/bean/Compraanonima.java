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
@Table(name = "COMPRAANONIMA")
@NamedQueries({
    @NamedQuery(name = "Compraanonima.findAll", query = "SELECT c FROM Compraanonima c"),
    @NamedQuery(name = "Compraanonima.findByCodCompraanonima", query = "SELECT c FROM Compraanonima c WHERE c.codCompraanonima = :codCompraanonima"),
    @NamedQuery(name = "Compraanonima.findByCpffunc", query = "SELECT c FROM Compraanonima c WHERE c.cpffunc = :cpffunc"),
    @NamedQuery(name = "Compraanonima.findByValtotal", query = "SELECT c FROM Compraanonima c WHERE c.valtotal = :valtotal"),
    @NamedQuery(name = "Compraanonima.findByOrigem", query = "SELECT c FROM Compraanonima c WHERE c.origem = :origem"),
    @NamedQuery(name = "Compraanonima.findByDestino", query = "SELECT c FROM Compraanonima c WHERE c.destino = :destino"),
    @NamedQuery(name = "Compraanonima.findByDthrsaida", query = "SELECT c FROM Compraanonima c WHERE c.dthrsaida = :dthrsaida"),
    @NamedQuery(name = "Compraanonima.findByAssento", query = "SELECT c FROM Compraanonima c WHERE c.assento = :assento"),
    @NamedQuery(name = "Compraanonima.findByPlaca", query = "SELECT c FROM Compraanonima c WHERE c.placa = :placa"),
    @NamedQuery(name = "Compraanonima.findByPlatembarque", query = "SELECT c FROM Compraanonima c WHERE c.platembarque = :platembarque"),
    @NamedQuery(name = "Compraanonima.findByTipopessoa", query = "SELECT c FROM Compraanonima c WHERE c.tipopessoa = :tipopessoa")})
public class Compraanonima implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_COMPRAANONIMA")
    private BigDecimal codCompraanonima;
    @Column(name = "CPFFUNC")
    private BigInteger cpffunc;
    @Column(name = "VALTOTAL")
    private BigInteger valtotal;
    @Size(max = 120)
    @Column(name = "ORIGEM")
    private String origem;
    @Size(max = 120)
    @Column(name = "DESTINO")
    private String destino;
    @Column(name = "DTHRSAIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dthrsaida;
    @Column(name = "ASSENTO")
    private BigInteger assento;
    @Size(max = 8)
    @Column(name = "PLACA")
    private String placa;
    @Column(name = "PLATEMBARQUE")
    private BigInteger platembarque;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPOPESSOA")
    private BigInteger tipopessoa;
    @JoinColumn(name = "FUNCIONARIO_CODIGO_FUNC", referencedColumnName = "CODIGO_FUNC")
    @ManyToOne(optional = false)
    private Funcionario funcionarioCodigoFunc;

    public Compraanonima() {
    }

    public Compraanonima(BigDecimal codCompraanonima) {
        this.codCompraanonima = codCompraanonima;
    }

    public Compraanonima(BigDecimal codCompraanonima, BigInteger tipopessoa) {
        this.codCompraanonima = codCompraanonima;
        this.tipopessoa = tipopessoa;
    }

    public BigDecimal getCodCompraanonima() {
        return codCompraanonima;
    }

    public void setCodCompraanonima(BigDecimal codCompraanonima) {
        this.codCompraanonima = codCompraanonima;
    }

    public BigInteger getCpffunc() {
        return cpffunc;
    }

    public void setCpffunc(BigInteger cpffunc) {
        this.cpffunc = cpffunc;
    }

    public BigInteger getValtotal() {
        return valtotal;
    }

    public void setValtotal(BigInteger valtotal) {
        this.valtotal = valtotal;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getDthrsaida() {
        return dthrsaida;
    }

    public void setDthrsaida(Date dthrsaida) {
        this.dthrsaida = dthrsaida;
    }

    public BigInteger getAssento() {
        return assento;
    }

    public void setAssento(BigInteger assento) {
        this.assento = assento;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public BigInteger getPlatembarque() {
        return platembarque;
    }

    public void setPlatembarque(BigInteger platembarque) {
        this.platembarque = platembarque;
    }

    public BigInteger getTipopessoa() {
        return tipopessoa;
    }

    public void setTipopessoa(BigInteger tipopessoa) {
        this.tipopessoa = tipopessoa;
    }

    public Funcionario getFuncionarioCodigoFunc() {
        return funcionarioCodigoFunc;
    }

    public void setFuncionarioCodigoFunc(Funcionario funcionarioCodigoFunc) {
        this.funcionarioCodigoFunc = funcionarioCodigoFunc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCompraanonima != null ? codCompraanonima.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compraanonima)) {
            return false;
        }
        Compraanonima other = (Compraanonima) object;
        if ((this.codCompraanonima == null && other.codCompraanonima != null) || (this.codCompraanonima != null && !this.codCompraanonima.equals(other.codCompraanonima))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.bean.Compraanonima[ codCompraanonima=" + codCompraanonima + " ]";
    }
    
}
