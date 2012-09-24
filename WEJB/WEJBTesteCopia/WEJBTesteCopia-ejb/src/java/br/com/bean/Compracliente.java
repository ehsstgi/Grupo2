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
@Table(name = "COMPRACLIENTE")
@NamedQueries({
    @NamedQuery(name = "Compracliente.findAll", query = "SELECT c FROM Compracliente c"),
    @NamedQuery(name = "Compracliente.findByCodCompracliente", query = "SELECT c FROM Compracliente c WHERE c.codCompracliente = :codCompracliente"),
    @NamedQuery(name = "Compracliente.findByCpfcliente", query = "SELECT c FROM Compracliente c WHERE c.cpfcliente = :cpfcliente"),
    @NamedQuery(name = "Compracliente.findByValor", query = "SELECT c FROM Compracliente c WHERE c.valor = :valor"),
    @NamedQuery(name = "Compracliente.findByOrigem", query = "SELECT c FROM Compracliente c WHERE c.origem = :origem"),
    @NamedQuery(name = "Compracliente.findByDestino", query = "SELECT c FROM Compracliente c WHERE c.destino = :destino"),
    @NamedQuery(name = "Compracliente.findByAssento", query = "SELECT c FROM Compracliente c WHERE c.assento = :assento"),
    @NamedQuery(name = "Compracliente.findByDataCompracli", query = "SELECT c FROM Compracliente c WHERE c.dataCompracli = :dataCompracli"),
    @NamedQuery(name = "Compracliente.findByHoraida", query = "SELECT c FROM Compracliente c WHERE c.horaida = :horaida"),
    @NamedQuery(name = "Compracliente.findByHorachegadaint", query = "SELECT c FROM Compracliente c WHERE c.horachegadaint = :horachegadaint"),
    @NamedQuery(name = "Compracliente.findByTipopessoa", query = "SELECT c FROM Compracliente c WHERE c.tipopessoa = :tipopessoa")})
public class Compracliente implements Serializable {
    @Column(name = "DATA_COMPRACLI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCompracli;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_COMPRACLIENTE")
    private BigDecimal codCompracliente;
    @Column(name = "CPFCLIENTE")
    private BigInteger cpfcliente;
    @Column(name = "VALOR")
    private BigInteger valor;
    @Size(max = 120)
    @Column(name = "ORIGEM")
    private String origem;
    @Size(max = 120)
    @Column(name = "DESTINO")
    private String destino;
    @Column(name = "ASSENTO")
    private BigInteger assento;
    @Column(name = "HORAIDA")
    private BigInteger horaida;
    @Column(name = "HORACHEGADAINT")
    private BigInteger horachegadaint;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPOPESSOA")
    private BigInteger tipopessoa;
    @JoinColumn(name = "PESSOA_CPF", referencedColumnName = "CPF")
    @ManyToOne(optional = false)
    private Pessoa pessoaCpf;

    public Compracliente() {
    }

    public Compracliente(BigDecimal codCompracliente) {
        this.codCompracliente = codCompracliente;
    }

    public Compracliente(BigDecimal codCompracliente, BigInteger tipopessoa) {
        this.codCompracliente = codCompracliente;
        this.tipopessoa = tipopessoa;
    }

    public BigDecimal getCodCompracliente() {
        return codCompracliente;
    }

    public void setCodCompracliente(BigDecimal codCompracliente) {
        this.codCompracliente = codCompracliente;
    }

    public BigInteger getCpfcliente() {
        return cpfcliente;
    }

    public void setCpfcliente(BigInteger cpfcliente) {
        this.cpfcliente = cpfcliente;
    }

    public BigInteger getValor() {
        return valor;
    }

    public void setValor(BigInteger valor) {
        this.valor = valor;
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

    public BigInteger getAssento() {
        return assento;
    }

    public void setAssento(BigInteger assento) {
        this.assento = assento;
    }

    public Date getDataCompracli() {
        return dataCompracli;
    }

    public void setDataCompracli(Date dataCompracli) {
        this.dataCompracli = dataCompracli;
    }

    public BigInteger getHoraida() {
        return horaida;
    }

    public void setHoraida(BigInteger horaida) {
        this.horaida = horaida;
    }

    public BigInteger getHorachegadaint() {
        return horachegadaint;
    }

    public void setHorachegadaint(BigInteger horachegadaint) {
        this.horachegadaint = horachegadaint;
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
        hash += (codCompracliente != null ? codCompracliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compracliente)) {
            return false;
        }
        Compracliente other = (Compracliente) object;
        if ((this.codCompracliente == null && other.codCompracliente != null) || (this.codCompracliente != null && !this.codCompracliente.equals(other.codCompracliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.bean.Compracliente[ codCompracliente=" + codCompracliente + " ]";
    }

    
}
