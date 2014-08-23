/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.Conexao;


public class Cidade {
    String nome,uf;
    int codigo;

    public Cidade(String nome, int codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public Cidade(String nome, String uf, int codigo) {
        this.nome = nome;
        this.uf = uf;
        this.codigo = codigo;
    }

    public Cidade() {
    }
    

    public String getNome() {
        return nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }


    public int getCodigo() {
        return codigo;
    }
    
    public static ArrayList<Cidade> getCidades() {
        String sql = "SELECT cv.codigo, cv.nome, cv.uf from cidade_vila cv"
                + " ORDER BY 2";
        ResultSet rs = null;
        ArrayList<Cidade> cidades = new ArrayList<Cidade>();
        try {
            rs = Conexao.comando.executeQuery(sql);
            while (rs.next()) {
                cidades.add(new Cidade(rs.getString("nome"),rs.getString("uf"), rs.getInt("codigo")));
            }
            rs.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return cidades;
    }
    
        public static Cidade getCidade(int cod) {
        String sql = "SELECT cv.codigo, cv.nome, cv.uf from cidade_vila cv"
                + " where cv.codigo = "+cod;
        ResultSet rs = null;
        Cidade cidade = null;
        try {
            rs = Conexao.comando.executeQuery(sql);
            while (rs.next()) {
                cidade = new Cidade(rs.getString("nome"),rs.getString("uf"), rs.getInt("codigo"));
            }
            rs.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return cidade;
    }
    
}
