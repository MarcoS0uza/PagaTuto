package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexao {

    private static final String URL_BD = "jdbc:firebirdsql:192.168.1.150:D:\\Arquivos\\Projetos\\Java\\PagaTuto\\BD\\PAGATUTO.IB";
    private static final String USER = "SYSDBA";
    private static final String SENHA = "masterkey";
    public static Connection conexão = null;
    public static Statement comando = null;

    public static void iniciarConexãoComando() {
        try {
            Class.forName("org.firebirdsql.jdbc.FBDriver");
            conexão = DriverManager.getConnection(URL_BD, USER, SENHA);
            comando = conexão.createStatement();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao canectar ao Banco de dados:\n" + ex, "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao canectar ao Driver Jdbc:\n" + ex, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void fecharComandoConexão() {
        try {
            comando.close();
            conexão.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
