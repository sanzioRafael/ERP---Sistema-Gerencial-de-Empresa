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
@Table(name = "banco", catalog = "siscom", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Banco.findAll", query = "SELECT b FROM Banco b"),
    @NamedQuery(name = "Banco.findByGerente", query = "SELECT b FROM Banco b WHERE b.gerente = :gerente"),
    @NamedQuery(name = "Banco.findByTelefone", query = "SELECT b FROM Banco b WHERE b.telefone = :telefone"),
    @NamedQuery(name = "Banco.findByNumConta", query = "SELECT b FROM Banco b WHERE b.numConta = :numConta"),
    @NamedQuery(name = "Banco.findByAgencia", query = "SELECT b FROM Banco b WHERE b.agencia = :agencia"),
    @NamedQuery(name = "Banco.findByCodBanco", query = "SELECT b FROM Banco b WHERE b.codBanco = :codBanco"),
    @NamedQuery(name = "Banco.findByNome", query = "SELECT b FROM Banco b WHERE b.nome = :nome")})
public class Banco implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Column(name = "gerente")
    private String gerente;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "num_conta")
    private Integer numConta;
    @Column(name = "agencia")
    private Integer agencia;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_banco")
    private Integer codBanco;
    @Column(name = "nome")
    private String nome;

    public Banco() {
    }

    public Banco(Integer codBanco) {
        this.codBanco = codBanco;
    }

    public String getGerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        String oldGerente = this.gerente;
        this.gerente = gerente;
        changeSupport.firePropertyChange("gerente", oldGerente, gerente);
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        String oldTelefone = this.telefone;
        this.telefone = telefone;
        changeSupport.firePropertyChange("telefone", oldTelefone, telefone);
    }

    public Integer getNumConta() {
        return numConta;
    }

    public void setNumConta(Integer numConta) {
        Integer oldNumConta = this.numConta;
        this.numConta = numConta;
        changeSupport.firePropertyChange("numConta", oldNumConta, numConta);
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        Integer oldAgencia = this.agencia;
        this.agencia = agencia;
        changeSupport.firePropertyChange("agencia", oldAgencia, agencia);
    }

    public Integer getCodBanco() {
        return codBanco;
    }

    public void setCodBanco(Integer codBanco) {
        Integer oldCodBanco = this.codBanco;
        this.codBanco = codBanco;
        changeSupport.firePropertyChange("codBanco", oldCodBanco, codBanco);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codBanco != null ? codBanco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Banco)) {
            return false;
        }
        Banco other = (Banco) object;
        if ((this.codBanco == null && other.codBanco != null) || (this.codBanco != null && !this.codBanco.equals(other.codBanco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.siscom.bean.Banco[ codBanco=" + codBanco + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
