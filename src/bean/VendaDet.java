/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Rafael
 */
@Entity
@Table(name = "venda_det", catalog = "siscom", schema = "public")
@NamedQueries({
    @NamedQuery(name = "VendaDet.findAll", query = "SELECT v FROM VendaDet v"),
    @NamedQuery(name = "VendaDet.findByVlrTotal", query = "SELECT v FROM VendaDet v WHERE v.vlrTotal = :vlrTotal"),
    @NamedQuery(name = "VendaDet.findByVlrUnitario", query = "SELECT v FROM VendaDet v WHERE v.vlrUnitario = :vlrUnitario"),
    @NamedQuery(name = "VendaDet.findByQtdVendaDet", query = "SELECT v FROM VendaDet v WHERE v.qtdVendaDet = :qtdVendaDet"),
    @NamedQuery(name = "VendaDet.findByCodProduto", query = "SELECT v FROM VendaDet v WHERE v.vendaDetPK.codProduto = :codProduto"),
    @NamedQuery(name = "VendaDet.findByCodVendaCab", query = "SELECT v FROM VendaDet v WHERE v.vendaDetPK.codVendaCab = :codVendaCab")})
public class VendaDet implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VendaDetPK vendaDetPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "vlr_total")
    private double vlrTotal;
    @Column(name = "vlr_unitario")
    private double vlrUnitario;
    @Column(name = "qtd_venda_det")
    private Integer qtdVendaDet;
    @JoinColumn(name = "cod_venda_cab", referencedColumnName = "cod_venda_cab", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private VendaCab vendaCab;

    public VendaDet() {
    }

    public VendaDet(VendaDetPK vendaDetPK) {
        this.vendaDetPK = vendaDetPK;
    }

    public VendaDet(int codProduto, int codVendaCab) {
        this.vendaDetPK = new VendaDetPK(codProduto, codVendaCab);
    }

    public VendaDetPK getVendaDetPK() {
        return vendaDetPK;
    }

    public void setVendaDetPK(VendaDetPK vendaDetPK) {
        this.vendaDetPK = vendaDetPK;
    }

    public double getVlrTotal() {
        return vlrTotal;
    }

    public void setVlrTotal(double vlrTotal) {
        double oldVlrTotal = this.vlrTotal;
        this.vlrTotal = vlrTotal;
        changeSupport.firePropertyChange("vlrTotal", oldVlrTotal, vlrTotal);
    }

    public double getVlrUnitario() {
        return vlrUnitario;
    }

    public void setVlrUnitario(double vlrUnitario) {
        double oldVlrUnitario = this.vlrUnitario;
        this.vlrUnitario = vlrUnitario;
        changeSupport.firePropertyChange("vlrUnitario", oldVlrUnitario, vlrUnitario);
    }

    public Integer getQtdVendaDet() {
        return qtdVendaDet;
    }

    public void setQtdVendaDet(Integer qtdVendaDet) {
        Integer oldQtdVendaDet = this.qtdVendaDet;
        this.qtdVendaDet = qtdVendaDet;
        changeSupport.firePropertyChange("qtdVendaDet", oldQtdVendaDet, qtdVendaDet);
    }

    public VendaCab getVendaCab() {
        return vendaCab;
    }

    public void setVendaCab(VendaCab vendaCab) {
        VendaCab oldVendaCab = this.vendaCab;
        this.vendaCab = vendaCab;
        changeSupport.firePropertyChange("vendaCab", oldVendaCab, vendaCab);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vendaDetPK != null ? vendaDetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VendaDet)) {
            return false;
        }
        VendaDet other = (VendaDet) object;
        if ((this.vendaDetPK == null && other.vendaDetPK != null) || (this.vendaDetPK != null && !this.vendaDetPK.equals(other.vendaDetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.VendaDet[ vendaDetPK=" + vendaDetPK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
