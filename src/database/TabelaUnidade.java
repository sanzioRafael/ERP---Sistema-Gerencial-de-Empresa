/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author Rafael
 */
public class TabelaUnidade {
    
    private Integer cod_unidade;
    private String descricao;

    public TabelaUnidade(Integer cod_unidade, String descricao) {
        this.cod_unidade = cod_unidade;
        this.descricao = descricao;
    }

    public Integer getCod_unidade() {
        return cod_unidade;
    }

    public void setCod_unidade(Integer cod_unidade) {
        this.cod_unidade = cod_unidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
        
}
