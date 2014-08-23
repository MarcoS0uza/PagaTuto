package entidade;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import persistencia.Conexao;

public class Fornecedor {

    private int codigo, numero;
    private String nome, n_documento, endereço, bairro, telefone, cep, estado, email, data_cadastro, tipo_pessoa;
    private Cidade cidade;

    public Fornecedor(int codigo, int numero, Cidade cidade, String nome, String n_documento, String endereço, String bairro, String telefone, String cep, String estado, String email, String data_cadastro, String tipo_pessoa) {
        this.codigo = codigo;
        this.numero = numero;
        this.cidade = cidade;
        this.nome = nome;
        this.n_documento = n_documento;
        this.endereço = endereço;
        this.bairro = bairro;
        this.telefone = telefone;
        this.cep = cep;
        this.estado = estado;
        this.email = email;
        this.data_cadastro = data_cadastro;
        this.tipo_pessoa = tipo_pessoa;
    }

    public Fornecedor(int numero, Cidade cidade, String nome, String n_documento, String endereço, String bairro, String telefone, String cep, String estado, String email, String data_cadastro, String tipo_pessoa) {
        this.numero = numero;
        this.cidade = cidade;
        this.nome = nome;
        this.n_documento = n_documento;
        this.endereço = endereço;
        this.bairro = bairro;
        this.telefone = telefone;
        this.cep = cep;
        this.estado = estado;
        this.email = email;
        this.data_cadastro = data_cadastro;
        this.tipo_pessoa = tipo_pessoa;
    }

    public Fornecedor(int codigo, String nome, String n_documento) {
        this.codigo = codigo;
        this.nome = nome;
        this.n_documento = n_documento;
    }
    
    public Fornecedor() {
    }

    public int getCodigo() {
        return codigo;
    }

    public int getNumero() {
        return numero;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public String getNome() {
        return nome;
    }

    public String getN_documento() {
        return n_documento;
    }

    public String getEndereço() {
        return endereço;
    }

    public String getBairro() {
        return bairro;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public String getEstado() {
        return estado;
    }

    public String getEmail() {
        return email;
    }

    public String getData_cadastro() {
        return data_cadastro;
    }

    public String getTipo_pessoa() {
        return tipo_pessoa;
    }

    @Override
    public String toString() {
        return "Fornecedor{" + "codigo=" + codigo + ", numero=" + numero + ", cidade=" + cidade + ", nome=" + nome + ", n_documento=" + n_documento + ", endere\u00e7o=" + endereço + ", bairro=" + bairro + ", telefone=" + telefone + ", cep=" + cep + ", estado=" + estado + ", email=" + email + ", data_cadastro=" + data_cadastro + ", tipo_pessoa=" + tipo_pessoa + '}';
    }

    /* Inicio dos métodos para manipulação do BD.
     ============================================================================================================================================================
     */
    
    public static String buscaCodCidade(String nome, String uf){
        String sql = "select cv.codigo from cidade_vila cv where cv.nome = '"+nome.toUpperCase()+"' and cv.uf = '"+uf.toUpperCase()+"'";
        ResultSet lista_resultados;
        String cod_cidade = "";
        try {
            lista_resultados = Conexao.comando.executeQuery(sql);

            while (lista_resultados.next()) {
                cod_cidade = lista_resultados.getString("codigo");
            }
            lista_resultados.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage());
        }
        if (cod_cidade == null) {
            return null;
        }else{
            return cod_cidade;
        }
    }
    public static String verificaDocCadastro(String nDoc) {
        String sql = "SELECT codigo,nome FROM fornecedor WHERE numero_documento = '" + nDoc + "'";
        ResultSet lista_resultados;
        String nome = null;
        String result = null;
        int cod = 0;
        try {
            lista_resultados = Conexao.comando.executeQuery(sql);

            while (lista_resultados.next()) {
                cod = lista_resultados.getInt("codigo");
                nome = lista_resultados.getString("nome");
            }
            lista_resultados.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage());
        }
        if (cod != 0 && nome != null) {
            result = "Documento Nº " + nDoc + " já cadastrado: \n" + cod + " - " + nome;
        }

        return result;
    }

    //Retorna null se sucesso ou mensagem do SQLException caso caia na excessão
    public static String inserirFornecedor(Fornecedor fornecedor) {
        String sql = "INSERT INTO FORNECEDOR(NOME,DATA_CADASTRO,"
                + "TIPO_PESSOA,NUMERO_DOCUMENTO,ENDERECO,NUMERO,"
                + "BAIRRO,CEP,TELEFONE,UF,EMAIL,COD_CIDADE)VALUES"
                + "('" + fornecedor.getNome().toUpperCase() + "','" + fornecedor.getData_cadastro().replace("/", ".") + "','" + fornecedor.getTipo_pessoa() + "','"
                + fornecedor.getN_documento() + "','" + fornecedor.getEndereço().toUpperCase() + "',"
                + fornecedor.getNumero() + ",'" + fornecedor.getBairro().toUpperCase() + "','" + fornecedor.getCep() + "','" + fornecedor.getTelefone() + "','"
                + fornecedor.getEstado() + "','" + fornecedor.getEmail().toUpperCase() + "'," + fornecedor.getCidade().getCodigo() + ")";
        System.out.println(sql);
//dn.format(Date.parse(fornecedor.getData_cadastro())) = converte data_cadastro para Date() e também para o formato de data do Mysql com a função format()
        try {
            Conexao.comando.executeUpdate(sql);
            return null;
        } catch (SQLException ex) {
            return "Erro de inserção no Banco de Dados:  " + ex.getMessage();
        }
    }

    //retorna objeto Cliente conforme parametro codigo, ou null se cair na excessão
    public static Fornecedor buscarFornecedor(int código) {
        String sql = "select f.*,"
                + " (select cv.nome from CIDADE_VILA cv where cv.codigo = f.cod_cidade)as nome_cidade"
                + " from fornecedor f"
                + " WHERE CODIGO = '" + código + "'";
        ResultSet rs;
        Fornecedor fornecedor = null;
        try {
            rs = Conexao.comando.executeQuery(sql);
            while (rs.next()) {

                fornecedor = new Fornecedor(
                        rs.getInt("CODIGO"),
                        rs.getInt("NUMERO"),
                        new Cidade(rs.getString("nome_cidade"),rs.getInt("COD_CIDADE")),
                        rs.getString("NOME"),
                        rs.getString("NUMERO_DOCUMENTO"),
                        rs.getString("ENDERECO"),
                        rs.getString("BAIRRO"),
                        rs.getString("TELEFONE"),
                        rs.getString("CEP"),
                        rs.getString("UF"),
                        rs.getString("EMAIL"),
                        rs.getString("DATA_CADASTRO").replace("-", "/"),
                        rs.getString("TIPO_PESSOA"));
            }
            rs.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "BUSCA ERROR\n"+sqle.getMessage());
            fornecedor = null;
        }
        return fornecedor;
    }

    public static ArrayList<Fornecedor> buscarTodosFornecedor(Fornecedor fornecedor) {
        DateFormat dn = new SimpleDateFormat("dd/MM/yyyy");
        String sql;
        if (fornecedor == null) {
            sql = "select"
                + " f.*," 
                + " cv.nome as nome_cidade" 
                + " from fornecedor f"
                + " left join cidade_vila cv on cv.codigo = f.cod_cidade";
        } else {
            sql = "select"
                + " f.*," 
                + " cv.nome as nome_cidade" 
                + " from fornecedor f"
                + " left join cidade_vila cv on cv.codigo = f.cod_cidade where";

            if (!fornecedor.getNome().equals("")) {
                sql += " and NOME like '" + fornecedor.getNome() + "%'";
            }
            if (!fornecedor.getN_documento().trim().equals("")) {
                sql += " and NUMERO_DOCUMENTO = '" + fornecedor.getN_documento() + "'";
            }
            if (fornecedor.getTipo_pessoa() != null) {
                sql += " and TIPO_PESSOA = '" + fornecedor.getTipo_pessoa() + "'";
            }
            if (!fornecedor.getData_cadastro().equals("")) {
                sql += " and DATA_CADASTRO = '" + fornecedor.getData_cadastro() + "'";
            }
            if (!fornecedor.getEmail().equals("")) {
                sql += " and EMAIL like '" + fornecedor.getEmail() + "%'";
            }
            if (!fornecedor.getEndereço().equals("")) {
                sql += " and ENDERECO like '" + fornecedor.getEndereço() + "%'";
            }
            if (!fornecedor.getBairro().equals("")) {
                sql += " and BAIRRO like '" + fornecedor.getBairro() + "%'";
            }
            if (fornecedor.getNumero() != -1) {
                sql += " and NUMERO = " + fornecedor.getNumero();
            }
            if (!fornecedor.getCep().trim().equals("")) {
                sql += " and CEP = '" + fornecedor.getCep() + "'";
            }
            if (!fornecedor.getTelefone().trim().equals("")) {
                sql += " and TELEFONE = '" + fornecedor.getTelefone() + "'";
            }
            if (fornecedor.getCidade().getCodigo() != -1 ) {
                sql += " and COD_CIDADE = '" + fornecedor.getCidade().getCodigo() + "'";
            }
            if (fornecedor.getEstado().equals("")) {
                sql += " and UF = '" + fornecedor.getEstado() + "'";
            }

            System.out.println(sql.replace("where and", "where"));
        }

        ResultSet rs;
        ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
        Fornecedor fornecedor1 = null;
        try {
            rs = Conexao.comando.executeQuery(sql.replace("where and", "where"));
            while (rs.next()) {

                fornecedor1 = new Fornecedor(
                        rs.getInt("CODIGO"),
                        rs.getInt("NUMERO"),
                        new Cidade(rs.getString("nome_cidade"),rs.getInt("COD_CIDADE")),
                        rs.getString("NOME"),
                        rs.getString("NUMERO_DOCUMENTO"),
                        rs.getString("ENDERECO"),
                        rs.getString("BAIRRO"),
                        rs.getString("TELEFONE"),
                        rs.getString("CEP"),
                        rs.getString("UF"),
                        rs.getString("EMAIL"),
                        dn.format(rs.getDate("DATA_CADASTRO")),
                        rs.getString("TIPO_PESSOA"));

                fornecedores.add(fornecedor1);
            }
            rs.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage());
            fornecedor1 = null;
        }
        return fornecedores;
    }

    //retorna novo cod para inserir no BD (o maior codigo do cliente + 1), já convertido em String ou mensagem do SQLException caso caia na excessão
    public static String id() {
        String codigo = null;
        try {
            String sql = "select gen_id(gen_fornecedor_id,0) FROM rdb$database";
            ResultSet rs = (ResultSet) Conexao.comando.executeQuery(sql);
            while (rs.next()) {
                codigo = String.valueOf((rs.getInt(1) + 1));
            }
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return codigo;
    }

    //altera (Update) dados do cliente no BD
    public static String alterarFornecedor(Fornecedor fornecedor) {
        String sql = "UPDATE FORNECEDOR SET NOME='" + fornecedor.getNome().toUpperCase()
                + "',DATA_CADASTRO='" + fornecedor.getData_cadastro().replace("/", ".")
                + "',TIPO_PESSOA='" + fornecedor.getTipo_pessoa() + "',NUMERO_DOCUMENTO='" + fornecedor.getN_documento()
                + "',EMAIL='" + fornecedor.getEmail().toUpperCase()
                + "',ENDERECO='" + fornecedor.getEndereço().toUpperCase() + "',NUMERO=" + fornecedor.getNumero()
                + ",BAIRRO='" + fornecedor.getBairro().toUpperCase() + "',CEP='" + fornecedor.getCep()
                + "',TELEFONE='" + fornecedor.getTelefone() + "',UF='" + fornecedor.getEstado()
                + "',COD_CIDADE=" + fornecedor.getCidade() + " WHERE CODIGO=" + fornecedor.getCodigo() + ";";
        //.toUpperCase() para salvar os dados em maiusculo no BD
        try {
            Conexao.comando.executeUpdate(sql);
            return null;
        } catch (SQLException e) {
            return "Erro na alteração do Fornecedor no Banco de Dados\n" + e.getMessage();
        }
    }

    //Exclui linha Cliente conforme parametro codigo
    public static String eleminarFornecedor(int código) {
        String sql = "DELETE FROM FORNECEDOR WHERE CODIGO=" + código + ";";
        try {
            Conexao.comando.executeUpdate(sql);
            return null;
        } catch (SQLException ex) {
            return "Erro na Remoção do Forncedor no Banco de Dados\n" + ex.getMessage();
        }
    }

        public static ArrayList<Fornecedor> visãoTabela() {
        DateFormat dc = new SimpleDateFormat("dd/MM/yyyy");//Formato da função format() para converter o formato Mysql para o usual no Brasil
        String sql = "Select codigo ,nome ,numero_documento from fornecedor";
        ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();// Cria um ArrayList de Objetos Fornecedor
        try {
            ResultSet rs = Conexao.comando.executeQuery(sql);
            while (rs.next()) {//cria objeto com dados do fornecedor salvos no BD
                Fornecedor fornecedor = new Fornecedor(rs.getInt("codigo"),
                        rs.getString("nome"),rs.getString("numero_documento"));
                fornecedores.add(fornecedor);//adiciona objeto fornecedore no Array
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
        return fornecedores;
    }


    /* Fim dos métodos para manipulação do BD.
     ============================================================================================================================================================
     */
}
