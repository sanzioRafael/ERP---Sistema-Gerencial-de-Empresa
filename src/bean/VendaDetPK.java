/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Rafael
 */
@Embeddable
public class VendaDetPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "cod_produto")
    private int codProduto;
    @Basic(optional = false)
    @Column(name = "cod_venda_cab")
    private int codVendaCab;

    public VendaDetPK() {
    }

    public VendaDetPK(int codProduto, int codVendaCab) {
        this.codProduto = codProduto;
        this.codVendaCab = codVendaCab;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public int getCodVendaCab() {
        return codVendaCab;
    }

    public void setCodVendaCab(int codVendaCab) {
        this.codVendaCab = codVendaCab;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codProduto;
        hash += (int) codVendaCab;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VendaDetPK)) {
            return false;
        }
        VendaDetPK other = (VendaDetPK) object;
        if (this.codProduto != other.codProduto) {
            return false;
        }
        if (this.codVendaCab != other.codVendaCab) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.VendaDetPK[ codProduto=" + codProduto + ", codVendaCab=" + codVendaCab + " ]";
    }
    
}
