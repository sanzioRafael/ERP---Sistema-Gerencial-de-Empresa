/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Rafael
 */
@Entity
@Table(name = "funcionario", catalog = "siscom", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f"),
    @NamedQuery(name = "Funcionario.findByAcessoTotal", query = "SELECT f FROM Funcionario f WHERE f.acessoTotal = :acessoTotal"),
    @NamedQuery(name = "Funcionario.findBySenha", query = "SELECT f FROM Funcionario f WHERE f.senha = :senha"),
    @NamedQuery(name = "Funcionario.findByDtAdmissao", query = "SELECT f FROM Funcionario f WHERE f.dtAdmissao = :dtAdmissao"),
    @NamedQuery(name = "Funcionario.findByLogin", query = "SELECT f FROM Funcionario f WHERE f.login = :login"),
    @NamedQuery(name = "Funcionario.findByCargo", query = "SELECT f FROM Funcionario f WHERE f.cargo = :cargo"),
    @NamedQuery(name = "Funcionario.findByNome", query = "SELECT f FROM Funcionario f WHERE f.nome = :nome"),
    @NamedQuery(name = "Funcionario.findByCodFuncionario", query = "SELECT f FROM Funcionario f WHERE f.codFuncionario = :codFuncionario"),
    @NamedQuery(name = "Funcionario.findByCodDepartamento", query = "SELECT f FROM Funcionario f WHERE f.codDepartamento = :codDepartamento")})
public class Funcionario implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Column(name = "acesso_total")
    private Character acessoTotal;
    @Column(name = "senha")
    private String senha;
    @Column(name = "dt_admissao")
    @Temporal(TemporalType.DATE)
    private Date dtAdmissao;
    @Column(name = "login")
    private String login;
    @Column(name = "cargo")
    private String cargo;
    @Column(name = "nome")
    private String nome;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_funcionario")
    private Integer codFuncionario;
    @Basic(optional = false)
    @Column(name = "cod_departamento")
    private int codDepartamento;

    public Funcionario() {
    }

    public Funcionario(Integer codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public Funcionario(Integer codFuncionario, int codDepartamento) {
        this.codFuncionario = codFuncionario;
        this.codDepartamento = codDepartamento;
    }

    public Character getAcessoTotal() {
        return acessoTotal;
    }

    public void setAcessoTotal(Character acessoTotal) {
        Character oldAcessoTotal = this.acessoTotal;
        this.acessoTotal = acessoTotal;
        changeSupport.firePropertyChange("acessoTotal", oldAcessoTotal, acessoTotal);
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        String oldSenha = this.senha;
        this.senha = senha;
        changeSupport.firePropertyChange("senha", oldSenha, senha);
    }

    public Date getDtAdmissao() {
        return dtAdmissao;
    }

    public void setDtAdmissao(Date dtAdmissao) {
        Date oldDtAdmissao = this.dtAdmissao;
        this.dtAdmissao = dtAdmissao;
        changeSupport.firePropertyChange("dtAdmissao", oldDtAdmissao, dtAdmissao);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        String oldLogin = this.login;
        this.login = login;
        changeSupport.firePropertyChange("login", oldLogin, login);
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        String oldCargo = this.cargo;
        this.cargo = cargo;
        changeSupport.firePropertyChange("cargo", oldCargo, cargo);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public Integer getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(Integer codFuncionario) {
        Integer oldCodFuncionario = this.codFuncionario;
        this.codFuncionario = codFuncionario;
        changeSupport.firePropertyChange("codFuncionario", oldCodFuncionario, codFuncionario);
    }

    public int getCodDepartamento() {
        return codDepartamento;
    }

    public void setCodDepartamento(int codDepartamento) {
        int oldCodDepartamento = this.codDepartamento;
        this.codDepartamento = codDepartamento;
        changeSupport.firePropertyChange("codDepartamento", oldCodDepartamento, codDepartamento);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codFuncionario != null ? codFuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.codFuncionario == null && other.codFuncionario != null) || (this.codFuncionario != null && !this.codFuncionario.equals(other.codFuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.siscom.bean.Funcionario[ codFuncionario=" + codFuncionario + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
