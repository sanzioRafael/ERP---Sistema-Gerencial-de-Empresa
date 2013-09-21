/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "cartao", catalog = "siscom", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Cartao.findAll", query = "SELECT c FROM Cartao c"),
    @NamedQuery(name = "Cartao.findByCodCartao", query = "SELECT c FROM Cartao c WHERE c.codCartao = :codCartao"),
    @NamedQuery(name = "Cartao.findByNome", query = "SELECT c FROM Cartao c WHERE c.nome = :nome"),
    @NamedQuery(name = "Cartao.findByTaxa", query = "SELECT c FROM Cartao c WHERE c.taxa = :taxa")})
public class Cartao implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_cartao")
    private Integer codCartao;
    @Column(name = "nome")
    private String nome;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "taxa")
    private double taxa;

    public Cartao() {
    }

    public Cartao(Integer codCartao) {
        this.codCartao = codCartao;
    }

    public Integer getCodCartao() {
        return codCartao;
    }

    public void setCodCartao(Integer codCartao) {
        Integer oldCodCartao = this.codCartao;
        this.codCartao = codCartao;
        changeSupport.firePropertyChange("codCartao", oldCodCartao, codCartao);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        double oldTaxa = this.taxa;
        this.taxa = taxa;
        changeSupport.firePropertyChange("taxa", oldTaxa, taxa);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCartao != null ? codCartao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cartao)) {
            return false;
        }
        Cartao other = (Cartao) object;
        if ((this.codCartao == null && other.codCartao != null) || (this.codCartao != null && !this.codCartao.equals(other.codCartao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.siscom.bean.Cartao[ codCartao=" + codCartao + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
