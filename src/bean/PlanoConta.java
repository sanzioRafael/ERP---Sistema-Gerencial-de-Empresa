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
@Table(name = "plano_conta", catalog = "siscom", schema = "public")
@NamedQueries({
    @NamedQuery(name = "PlanoConta.findAll", query = "SELECT p FROM PlanoConta p"),
    @NamedQuery(name = "PlanoConta.findByCodPlanoConta", query = "SELECT p FROM PlanoConta p WHERE p.codPlanoConta = :codPlanoConta"),
    @NamedQuery(name = "PlanoConta.findByDescricao", query = "SELECT p FROM PlanoConta p WHERE p.descricao = :descricao")})
public class PlanoConta implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_plano_conta")
    private Integer codPlanoConta;
    @Column(name = "descricao")
    private String descricao;

    public PlanoConta() {
    }

    public PlanoConta(Integer codPlanoConta) {
        this.codPlanoConta = codPlanoConta;
    }

    public Integer getCodPlanoConta() {
        return codPlanoConta;
    }

    public void setCodPlanoConta(Integer codPlanoConta) {
        Integer oldCodPlanoConta = this.codPlanoConta;
        this.codPlanoConta = codPlanoConta;
        changeSupport.firePropertyChange("codPlanoConta", oldCodPlanoConta, codPlanoConta);
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
        hash += (codPlanoConta != null ? codPlanoConta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanoConta)) {
            return false;
        }
        PlanoConta other = (PlanoConta) object;
        if ((this.codPlanoConta == null && other.codPlanoConta != null) || (this.codPlanoConta != null && !this.codPlanoConta.equals(other.codPlanoConta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.siscom.bean.PlanoConta[ codPlanoConta=" + codPlanoConta + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
