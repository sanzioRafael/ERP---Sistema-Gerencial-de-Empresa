/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import view.EnderecoEditView;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafael
 */
public class Conexao {
    
    public static Connection con;
    
    static {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/siscom", "postgres", "zmax*2035");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<VisaoEndereco> pesquisaCep(String campo){
        List<VisaoEndereco> endereco = new ArrayList<VisaoEndereco>();
            try {
                PreparedStatement pstm = Conexao.con.prepareStatement("SELECT * FROM Visao_Endereco WHERE cep = '"+campo+"'");
                ResultSet rs = pstm.executeQuery();
                while(rs.next()){
                    endereco.add(new VisaoEndereco(rs.getString("cep"), rs.getString("endereco"), rs.getString("uf"), 
                    rs.getString("cidade"), rs.getString("bairro")));
                }
                if(endereco.isEmpty())
                    JOptionPane.showMessageDialog(null, "CEP inexistente, tente de novo!!");
                else
                    JOptionPane.showMessageDialog(null, "CEP encontrado com sucesso!!!");
            } catch (SQLException ex) {
                Logger.getLogger(EnderecoEditView.class.getName()).log(Level.SEVERE, null, ex);
            }
            return endereco;
    }
    
    public List<TabelaUnidade> Unidade (String campo){
        List<TabelaUnidade> unidade = new ArrayList<TabelaUnidade>();
        PreparedStatement pstm;
        try {
            pstm = Conexao.con.prepareCall("SELECT * FROM unidade");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {                
                unidade.add(new TabelaUnidade(rs.getInt("cod_unidade"), rs.getString("descricao")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return unidade;
    }
    
    public List<TabelaTipoPagamento> pesquisaTipoPagamento (String campo) {
        List<TabelaTipoPagamento> tipoPagamento = new ArrayList<TabelaTipoPagamento>();
        PreparedStatement pstmt;
        try {
            pstmt = Conexao.con.prepareCall("SELECT * FROM tipo_pagamento WHERE cod_tipo_pgto = "+campo);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                tipoPagamento.add(new TabelaTipoPagamento(rs.getInt("cod_tipo_pgto"), rs.getString("descricao")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return tipoPagamento;
    }
    
    public List<TabelaTipoPagamento> TipoPagamento (String campo){
        List<TabelaTipoPagamento> tipoPagamento = new ArrayList<TabelaTipoPagamento>();
        PreparedStatement pstm;
        try {
            pstm = Conexao.con.prepareCall("SELECT * FROM tipo_pagamento ORDER BY cod_tipo_pgto");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {                
                tipoPagamento.add(new TabelaTipoPagamento(rs.getInt("cod_tipo_pgto"), rs.getString("descricao")));
            }
        } catch (SQLException ex) {
            System.out.println("Conexao Tipo Pagamento\n"+ex.getMessage());
        }
        return tipoPagamento;
    }
    
    public List<TabelaCartao> pesquisaCartao (String campo) {
        List<TabelaCartao> cartao = new ArrayList<TabelaCartao>();
        PreparedStatement pstmt;
        try {
            pstmt = Conexao.con.prepareCall("SELECT * FROM cartao WHERE cod_cartao = "+campo);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                cartao.add(new TabelaCartao(rs.getInt("cod_cartao"), rs.getString("nome"), rs.getDouble("taxa")));
            }
        } catch (ClassCastException | SQLException ex) {
            System.out.println("Cartão: \n"+ex.getMessage());
        }
        return cartao;
    }
    
    public List<TabelaCartao> Cartao (String campo){
        List<TabelaCartao> cartao = new ArrayList<TabelaCartao>();
        PreparedStatement pstm;
        try {
            pstm = Conexao.con.prepareCall("SELECT * FROM cartao");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {                
                cartao.add(new TabelaCartao(rs.getInt("cod_cartao"), rs.getString("nome"), rs.getDouble("taxa")));
            }
        } catch (ClassCastException | SQLException ex) {
            System.out.println("Conexao Cartao\n"+ex.getMessage());
        }
        return cartao;
    }
    
    public List<TabelaCliente> pesquisaCliente (int campo) {
        List<TabelaCliente> cliente = new ArrayList<TabelaCliente>();
        cliente.clear();
        PreparedStatement pstmt;
        try {
            pstmt = Conexao.con.prepareCall("SELECT * FROM cliente WHERE cod_cliente = "+campo);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                cliente.add(new TabelaCliente(rs.getString("email"), rs.getString("nome"), rs.getString("fone_referencia"), rs.getString("referencia"),
                rs.getDouble("renda"), rs.getInt("cod_cliente"), rs.getString("rg"), rs.getString("cpf"), rs.getDate("dt_nasc")));
            }
        } catch (ClassCastException | SQLException e) {
            System.err.println("Conexao Cliente\n"+e.getMessage());
        }
        return cliente;
    }
    
    public List<TabelaFuncionario> pesquisaFuncionario (int campo) {
        List<TabelaFuncionario> funcionario = new ArrayList<TabelaFuncionario>();
        PreparedStatement pstmt;
        try {
            pstmt = Conexao.con.prepareCall("SELECT * FROM funcionario WHERE cod_funcionario = "+campo);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                funcionario.add(new TabelaFuncionario(rs.getString("acesso_total"), rs.getString("senha"), rs.getDate("dt_admissao"), 
                rs.getString("login"), rs.getString("cargo"), rs.getString("nome"), rs.getInt("cod_funcionario"), rs.getInt("cod_departamento")));
            }
        } catch (ClassCastException | SQLException e) {
            System.err.println("Funcionário\n"+e.getMessage());
        }
        return funcionario;
    }
    
    public List<TabelaCfop> pesquisaCfop (int campo) {
        List<TabelaCfop> cfop = new ArrayList<TabelaCfop>();
        PreparedStatement pstmt;
        try {
            pstmt = Conexao.con.prepareCall("SELECT * FROM cfop WHERE cod_cfop = "+campo);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {                
                cfop.add(new TabelaCfop(rs.getInt("cod_cfop"), rs.getString("descricao")));
            }
        } catch (ClassCastException | SQLException e) {
            System.err.println("CFOP\n"+e.getMessage());
        }
        return cfop;
    }
    
}
