/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.Date;

/**
 *
 * @author Rafael
 */
public class TabelaCliente {
    
    private String email, nome, referencia, fone_referencia;
    private double renda;
    private int cod_cliente;
    private String rg, cpf;
    private Date dt_nasc;

    public TabelaCliente(String email, String nome, String referencia, String fone_referencia, double renda, int cod_cliente, String rg, String cpf, Date dt_nasc) {
        this.email = email;
        this.nome = nome;
        this.referencia = referencia;
        this.fone_referencia = fone_referencia;
        this.renda = renda;
        this.cod_cliente = cod_cliente;
        this.rg = rg;
        this.cpf = cpf;
        this.dt_nasc = dt_nasc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getFone_referencia() {
        return fone_referencia;
    }

    public void setFone_referencia(String fone_referencia) {
        this.fone_referencia = fone_referencia;
    }

    public double getRenda() {
        return renda;
    }

    public void setRenda(double renda) {
        this.renda = renda;
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDt_nasc() {
        return dt_nasc;
    }

    public void setDt_nasc(Date dt_nasc) {
        this.dt_nasc = dt_nasc;
    }
    
}
