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
@Table(name = "produto", catalog = "siscom", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findByCriticoProduto", query = "SELECT p FROM Produto p WHERE p.criticoProduto = :criticoProduto"),
    @NamedQuery(name = "Produto.findByValorVenda", query = "SELECT p FROM Produto p WHERE p.valorVenda = :valorVenda"),
    @NamedQuery(name = "Produto.findByEstoqueProduto", query = "SELECT p FROM Produto p WHERE p.estoqueProduto = :estoqueProduto"),
    @NamedQuery(name = "Produto.findByCodProduto", query = "SELECT p FROM Produto p WHERE p.codProduto = :codProduto"),
    @NamedQuery(name = "Produto.findByDescricao", query = "SELECT p FROM Produto p WHERE p.descricao = :descricao"),
    @NamedQuery(name = "Produto.findByValorCompra", query = "SELECT p FROM Produto p WHERE p.valorCompra = :valorCompra"),
    @NamedQuery(name = "Produto.findByCodUnidade", query = "SELECT p FROM Produto p WHERE p.codUnidade = :codUnidade"),
    @NamedQuery(name = "Produto.findByCodFornecedor", query = "SELECT p FROM Produto p WHERE p.codFornecedor = :codFornecedor")})
public class Produto implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Column(name = "critico_produto")
    private Integer criticoProduto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_venda")
    private double valorVenda;
    @Column(name = "estoque_produto")
    private Integer estoqueProduto;
    @Id
    @Column(name = "cod_produto")
    private Integer codProduto;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "valor_compra")
    private double valorCompra;
    
    @Basic(optional = false)
    @Column(name = "cod_unidade")
    private Integer codUnidade;
    
    @Basic(optional = false)
    @Column(name = "cod_fornecedor")
    private int codFornecedor;

    public Produto() {
    }

    public Produto(Integer codProduto) {
        this.codProduto = codProduto;
    }

    public Produto(Integer codProduto, Integer codUnidade, int codFornecedor) {
        this.codProduto = codProduto;
        this.codUnidade = codUnidade;
        this.codFornecedor = codFornecedor;
    }

    public Integer getCriticoProduto() {
        return criticoProduto;
    }

    public void setCriticoProduto(Integer criticoProduto) {
        Integer oldCriticoProduto = this.criticoProduto;
        this.criticoProduto = criticoProduto;
        changeSupport.firePropertyChange("criticoProduto", oldCriticoProduto, criticoProduto);
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        double oldValorVenda = this.valorVenda;
        this.valorVenda = valorVenda;
        changeSupport.firePropertyChange("valorVenda", oldValorVenda, valorVenda);
    }

    public Integer getEstoqueProduto() {
        return estoqueProduto;
    }

    public void setEstoqueProduto(Integer estoqueProduto) {
        Integer oldEstoqueProduto = this.estoqueProduto;
        this.estoqueProduto = estoqueProduto;
        changeSupport.firePropertyChange("estoqueProduto", oldEstoqueProduto, estoqueProduto);
    }

    public Integer getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(Integer codProduto) {
        Integer oldCodProduto = this.codProduto;
        this.codProduto = codProduto;
        changeSupport.firePropertyChange("codProduto", oldCodProduto, codProduto);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        String oldDescricao = this.descricao;
        this.descricao = descricao;
        changeSupport.firePropertyChange("descricao", oldDescricao, descricao);
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        double oldValorCompra = this.valorCompra;
        this.valorCompra = valorCompra;
        changeSupport.firePropertyChange("valorCompra", oldValorCompra, valorCompra);
    }

    public Integer getCodUnidade() {
        return codUnidade;
    }

    public void setCodUnidade(Integer codUnidade) {
        Integer oldCodUnidade = this.codUnidade;
        this.codUnidade = codUnidade;
        changeSupport.firePropertyChange("codUnidade", oldCodUnidade, codUnidade);
    }

    public int getCodFornecedor() {
        return codFornecedor;
    }

    public void setCodFornecedor(int codFornecedor) {
        int oldCodFornecedor = this.codFornecedor;
        this.codFornecedor = codFornecedor;
        changeSupport.firePropertyChange("codFornecedor", oldCodFornecedor, codFornecedor);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codProduto != null ? codProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.codProduto == null && other.codProduto != null) || (this.codProduto != null && !this.codProduto.equals(other.codProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.siscom.bean.Produto[ codProduto=" + codProduto + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
