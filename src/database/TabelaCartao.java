/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author Rafael
 */
public class TabelaCartao {
    
    private Integer cod_cartao;
    private String nome;
    private double taxa;

    public TabelaCartao(Integer cod_cartao, String nome, double taxa) {
        this.cod_cartao = cod_cartao;
        this.nome = nome;
        this.taxa = taxa;
    }

    public Integer getCod_cartao() {
        return cod_cartao;
    }

    public void setCod_cartao(Integer cod_cartao) {
        this.cod_cartao = cod_cartao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }
    
}
