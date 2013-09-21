/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Rafael
 */
@Entity
@Table(name = "tipo_pagamento", catalog = "siscom", schema = "public")
@NamedQueries({
    @NamedQuery(name = "TipoPagamento.findAll", query = "SELECT t FROM TipoPagamento t"),
    @NamedQuery(name = "TipoPagamento.findByCodTipoPgto", query = "SELECT t FROM TipoPagamento t WHERE t.codTipoPgto = :codTipoPgto"),
    @NamedQuery(name = "TipoPagamento.findByDescricao", query = "SELECT t FROM TipoPagamento t WHERE t.descricao = :descricao")})
public class TipoPagamento implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_tipo_pgto")
    private Integer codTipoPgto;
    @Column(name = "descricao")
    private String descricao;

    public TipoPagamento() {
    }

    public TipoPagamento(Integer codTipoPgto) {
        this.codTipoPgto = codTipoPgto;
    }

    public Integer getCodTipoPgto() {
        return codTipoPgto;
    }

    public void setCodTipoPgto(Integer codTipoPgto) {
        Integer oldCodTipoPgto = this.codTipoPgto;
        this.codTipoPgto = codTipoPgto;
        changeSupport.firePropertyChange("codTipoPgto", oldCodTipoPgto, codTipoPgto);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        String oldDescricao = this.descricao;
        this.descricao = descricao;
        changeSupport.firePropertyChange("descricao", oldDescricao, descricao);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipoPgto != null ? codTipoPgto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPagamento)) {
            return false;
        }
        TipoPagamento other = (TipoPagamento) object;
        if ((this.codTipoPgto == null && other.codTipoPgto != null) || (this.codTipoPgto != null && !this.codTipoPgto.equals(other.codTipoPgto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.siscom.bean.TipoPagamento[ codTipoPgto=" + codTipoPgto + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
