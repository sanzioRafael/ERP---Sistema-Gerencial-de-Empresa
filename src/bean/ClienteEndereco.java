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
@Table(name = "cliente_endereco", catalog = "siscom", schema = "public")
@NamedQueries({
    @NamedQuery(name = "ClienteEndereco.findAll", query = "SELECT c FROM ClienteEndereco c"),
    @NamedQuery(name = "ClienteEndereco.findByCodEndereco", query = "SELECT c FROM ClienteEndereco c WHERE c.codEndereco = :codEndereco"),
    @NamedQuery(name = "ClienteEndereco.findByLogradouro", query = "SELECT c FROM ClienteEndereco c WHERE c.logradouro = :logradouro"),
    @NamedQuery(name = "ClienteEndereco.findByCep", query = "SELECT c FROM ClienteEndereco c WHERE c.cep = :cep"),
    @NamedQuery(name = "ClienteEndereco.findByComplemento", query = "SELECT c FROM ClienteEndereco c WHERE c.complemento = :complemento"),
    @NamedQuery(name = "ClienteEndereco.findByUf", query = "SELECT c FROM ClienteEndereco c WHERE c.uf = :uf"),
    @NamedQuery(name = "ClienteEndereco.findByCidade", query = "SELECT c FROM ClienteEndereco c WHERE c.cidade = :cidade"),
    @NamedQuery(name = "ClienteEndereco.findByBairro", query = "SELECT c FROM ClienteEndereco c WHERE c.bairro = :bairro")})
public class ClienteEndereco implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_endereco")
    private Integer codEndereco;
    @Column(name = "logradouro")
    private String logradouro;
    @Column(name = "cep")
    private String cep;
    @Column(name = "complemento")
    private String complemento;
    @Column(name = "uf")
    private String uf;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "bairro")
    private String bairro;
    @JoinColumn(name = "cod_cliente", referencedColumnName = "cod_cliente")
    @ManyToOne(optional = false)
    private Cliente codCliente;

    public ClienteEndereco() {
    }

    public ClienteEndereco(Integer codEndereco) {
        this.codEndereco = codEndereco;
    }

    public Integer getCodEndereco() {
        return codEndereco;
    }

    public void setCodEndereco(Integer codEndereco) {
        Integer oldCodEndereco = this.codEndereco;
        this.codEndereco = codEndereco;
        changeSupport.firePropertyChange("codEndereco", oldCodEndereco, codEndereco);
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        String oldLogradouro = this.logradouro;
        this.logradouro = logradouro;
        changeSupport.firePropertyChange("logradouro", oldLogradouro, logradouro);
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        String oldCep = this.cep;
        this.cep = cep;
        changeSupport.firePropertyChange("cep", oldCep, cep);
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        String oldComplemento = this.complemento;
        this.complemento = complemento;
        changeSupport.firePropertyChange("complemento", oldComplemento, complemento);
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        String oldUf = this.uf;
        this.uf = uf;
        changeSupport.firePropertyChange("uf", oldUf, uf);
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        String oldCidade = this.cidade;
        this.cidade = cidade;
        changeSupport.firePropertyChange("cidade", oldCidade, cidade);
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        String oldBairro = this.bairro;
        this.bairro = bairro;
        changeSupport.firePropertyChange("bairro", oldBairro, bairro);
    }

    public Cliente getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Cliente codCliente) {
        Cliente oldCodCliente = this.codCliente;
        this.codCliente = codCliente;
        changeSupport.firePropertyChange("codCliente", oldCodCliente, codCliente);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEndereco != null ? codEndereco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteEndereco)) {
            return false;
        }
        ClienteEndereco other = (ClienteEndereco) object;
        if ((this.codEndereco == null && other.codEndereco != null) || (this.codEndereco != null && !this.codEndereco.equals(other.codEndereco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.siscom.bean.ClienteEndereco[ codEndereco=" + codEndereco + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
