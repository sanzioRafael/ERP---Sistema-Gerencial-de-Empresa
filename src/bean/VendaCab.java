/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Rafael
 */
@Entity
@Table(name = "venda_cab", catalog = "siscom", schema = "public")
@NamedQueries({
    @NamedQuery(name = "VendaCab.findAll", query = "SELECT v FROM VendaCab v"),
    @NamedQuery(name = "VendaCab.findByValorVenda", query = "SELECT v FROM VendaCab v WHERE v.valorVenda = :valorVenda"),
    @NamedQuery(name = "VendaCab.findByDtVenda", query = "SELECT v FROM VendaCab v WHERE v.dtVenda = :dtVenda"),
    @NamedQuery(name = "VendaCab.findByTotalVenda", query = "SELECT v FROM VendaCab v WHERE v.totalVenda = :totalVenda"),
    @NamedQuery(name = "VendaCab.findByPrimeiroVenc", query = "SELECT v FROM VendaCab v WHERE v.primeiroVenc = :primeiroVenc"),
    @NamedQuery(name = "VendaCab.findByNumNf", query = "SELECT v FROM VendaCab v WHERE v.numNf = :numNf"),
    @NamedQuery(name = "VendaCab.findByCodVendaCab", query = "SELECT v FROM VendaCab v WHERE v.codVendaCab = :codVendaCab"),
    @NamedQuery(name = "VendaCab.findByValorDesconto", query = "SELECT v FROM VendaCab v WHERE v.valorDesconto = :valorDesconto"),
    @NamedQuery(name = "VendaCab.findByCodCartao", query = "SELECT v FROM VendaCab v WHERE v.codCartao = :codCartao"),
    @NamedQuery(name = "VendaCab.findByCodFuncionario", query = "SELECT v FROM VendaCab v WHERE v.codFuncionario = :codFuncionario"),
    @NamedQuery(name = "VendaCab.findByCodCliente", query = "SELECT v FROM VendaCab v WHERE v.codCliente = :codCliente"),
    @NamedQuery(name = "VendaCab.findByCodCfop", query = "SELECT v FROM VendaCab v WHERE v.codCfop = :codCfop"),
    @NamedQuery(name = "VendaCab.findByCodTipoPgto", query = "SELECT v FROM VendaCab v WHERE v.codTipoPgto = :codTipoPgto")})
public class VendaCab implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_venda")
    private double valorVenda;
    @Column(name = "dt_venda")
    @Temporal(TemporalType.DATE)
    private Date dtVenda;
    @Column(name = "total_venda")
    private double totalVenda;
    @Column(name = "primeiro_venc")
    @Temporal(TemporalType.DATE)
    private Date primeiroVenc;
    @Column(name = "num_nf")
    private Integer numNf;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_venda_cab")
    private Integer codVendaCab;
    @Column(name = "valor_desconto")
    private double valorDesconto;
    @Basic(optional = false)
    @Column(name = "cod_cartao")
    private int codCartao;
    @Basic(optional = false)
    @Column(name = "cod_funcionario")
    private int codFuncionario;
    @Basic(optional = false)
    @Column(name = "cod_cliente")
    private int codCliente;
    @Basic(optional = false)
    @Column(name = "cod_cfop")
    private int codCfop;
    @Basic(optional = false)
    @Column(name = "cod_tipo_pgto")
    private int codTipoPgto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendaCab")
    private List<VendaDet> vendaDetList;

    public VendaCab() {
    }

    public VendaCab(Integer codVendaCab) {
        this.codVendaCab = codVendaCab;
    }

    public VendaCab(Integer codVendaCab, int codCartao, int codFuncionario, int codCliente, int codCfop, int codTipoPgto) {
        this.codVendaCab = codVendaCab;
        this.codCartao = codCartao;
        this.codFuncionario = codFuncionario;
        this.codCliente = codCliente;
        this.codCfop = codCfop;
        this.codTipoPgto = codTipoPgto;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        double oldValorVenda = this.valorVenda;
        this.valorVenda = valorVenda;
        changeSupport.firePropertyChange("valorVenda", oldValorVenda, valorVenda);
    }

    public Date getDtVenda() {
        return dtVenda;
    }

    public void setDtVenda(Date dtVenda) {
        Date oldDtVenda = this.dtVenda;
        this.dtVenda = dtVenda;
        changeSupport.firePropertyChange("dtVenda", oldDtVenda, dtVenda);
    }

    public double getTotalVenda() {
        return totalVenda;
    }

    public void setTotalVenda(double totalVenda) {
        double oldTotalVenda = this.totalVenda;
        this.totalVenda = totalVenda;
        changeSupport.firePropertyChange("totalVenda", oldTotalVenda, totalVenda);
    }

    public Date getPrimeiroVenc() {
        return primeiroVenc;
    }

    public void setPrimeiroVenc(Date primeiroVenc) {
        Date oldPrimeiroVenc = this.primeiroVenc;
        this.primeiroVenc = primeiroVenc;
        changeSupport.firePropertyChange("primeiroVenc", oldPrimeiroVenc, primeiroVenc);
    }

    public Integer getNumNf() {
        return numNf;
    }

    public void setNumNf(Integer numNf) {
        Integer oldNumNf = this.numNf;
        this.numNf = numNf;
        changeSupport.firePropertyChange("numNf", oldNumNf, numNf);
    }

    public Integer getCodVendaCab() {
        return codVendaCab;
    }

    public void setCodVendaCab(Integer codVendaCab) {
        Integer oldCodVendaCab = this.codVendaCab;
        this.codVendaCab = codVendaCab;
        changeSupport.firePropertyChange("codVendaCab", oldCodVendaCab, codVendaCab);
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(double valorDesconto) {
        double oldValorDesconto = this.valorDesconto;
        this.valorDesconto = valorDesconto;
        changeSupport.firePropertyChange("valorDesconto", oldValorDesconto, valorDesconto);
    }

    public int getCodCartao() {
        return codCartao;
    }

    public void setCodCartao(int codCartao) {
        int oldCodCartao = this.codCartao;
        this.codCartao = codCartao;
        changeSupport.firePropertyChange("codCartao", oldCodCartao, codCartao);
    }

    public int getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(int codFuncionario) {
        int oldCodFuncionario = this.codFuncionario;
        this.codFuncionario = codFuncionario;
        changeSupport.firePropertyChange("codFuncionario", oldCodFuncionario, codFuncionario);
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        int oldCodCliente = this.codCliente;
        this.codCliente = codCliente;
        changeSupport.firePropertyChange("codCliente", oldCodCliente, codCliente);
    }

    public int getCodCfop() {
        return codCfop;
    }

    public void setCodCfop(int codCfop) {
        int oldCodCfop = this.codCfop;
        this.codCfop = codCfop;
        changeSupport.firePropertyChange("codCfop", oldCodCfop, codCfop);
    }

    public int getCodTipoPgto() {
        return codTipoPgto;
    }

    public void setCodTipoPgto(int codTipoPgto) {
        int oldCodTipoPgto = this.codTipoPgto;
        this.codTipoPgto = codTipoPgto;
        changeSupport.firePropertyChange("codTipoPgto", oldCodTipoPgto, codTipoPgto);
    }

    public List<VendaDet> getVendaDetList() {
        return vendaDetList;
    }

    public void setVendaDetList(List<VendaDet> vendaDetList) {
        this.vendaDetList = vendaDetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codVendaCab != null ? codVendaCab.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VendaCab)) {
            return false;
        }
        VendaCab other = (VendaCab) object;
        if ((this.codVendaCab == null && other.codVendaCab != null) || (this.codVendaCab != null && !this.codVendaCab.equals(other.codVendaCab))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.VendaCab[ codVendaCab=" + codVendaCab + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
