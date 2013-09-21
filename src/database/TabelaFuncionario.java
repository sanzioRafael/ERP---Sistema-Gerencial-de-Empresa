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
public class TabelaFuncionario {
    
    private String acesso_total, senha;
    private Date dt_admissao;
    private String login, cargo, nome;
    private int cod_funcionario, cod_departamento;

    public TabelaFuncionario(String acesso_total, String senha, Date dt_admissao, String login, String cargo, String nome, int cod_funcionario, int cod_departamento) {
        this.acesso_total = acesso_total;
        this.senha = senha;
        this.dt_admissao = dt_admissao;
        this.login = login;
        this.cargo = cargo;
        this.nome = nome;
        this.cod_funcionario = cod_funcionario;
        this.cod_departamento = cod_departamento;
    }

    public String getAcesso_total() {
        return acesso_total;
    }

    public void setAcesso_total(String acesso_total) {
        this.acesso_total = acesso_total;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDt_admissao() {
        return dt_admissao;
    }

    public void setDt_admissao(Date dt_admissao) {
        this.dt_admissao = dt_admissao;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCod_funcionario() {
        return cod_funcionario;
    }

    public void setCod_funcionario(int cod_funcionario) {
        this.cod_funcionario = cod_funcionario;
    }

    public int getCod_departamento() {
        return cod_departamento;
    }

    public void setCod_departamento(int cod_departamento) {
        this.cod_departamento = cod_departamento;
    }
    
}
