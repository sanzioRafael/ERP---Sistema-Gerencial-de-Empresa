/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author Rafael
 */
public class TabelaCfop {
 
    private int cod_cfop;
    private String descricao;

    public TabelaCfop(int cod_cfop, String descricao) {
        this.cod_cfop = cod_cfop;
        this.descricao = descricao;
    }

    public int getCod_cfop() {
        return cod_cfop;
    }

    public void setCod_cfop(int cod_cfop) {
        this.cod_cfop = cod_cfop;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
