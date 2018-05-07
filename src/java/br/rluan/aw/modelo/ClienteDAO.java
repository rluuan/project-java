// Definição do pacote
package br.rluan.aw.modelo;
 
// Importações
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
 
// Declaração da classe
public class ClienteDAO {
 
  // Quatro variáveis finais para conexão com banco de dados
  private static final String DRIVER = "com.mysql.jdbc.Driver";
  private static final String URL = "jdbc:mysql://localhost:3306/teste";
  private static final String USUARIO = "root";
  private static final String SENHA = "";
  // Variáveis finais com instruções SQL
  private static final String sqlSelecao = "SELECT * FROM usuarios ORDER BY name";
  private static final String sqlInclusao = "insert into usuarios (name, email) values (?, ?)";
  // Objetos para conexão com banco de dados
  private static Connection conexao;
  private static PreparedStatement ps;
  private static ResultSet rs;
  public static int estado;
 
  // Método para retornar todos os registros
  public static List<Cliente> todosClientes() {
    // Cria um List nulo
    List<Cliente> lista = null;
    // Conectar com o banco de dados
    if (conectar()) {
      // Se conectado
      try {
        // Obtém registros
        ps = conexao.prepareStatement(sqlSelecao);
        rs = ps.executeQuery();
        // Cria List
        lista = new ArrayList<Cliente>();
        // Navega entre registros
        while (rs.next()) {
          // Cria objeto a partir do registro
            System.out.println("Teste");
          Cliente cliente = popularCliente();
          // Adicionar objeto à List
          lista.add(cliente);
        }
      } catch (SQLException sqle) {
        System.out.println(sqle.getLocalizedMessage());
      } finally {
        // Desconectar
        desconectar();
      }
    }
    // Retorna a List
    return lista;
  }
 public static boolean inserirCliente(Cliente cliente) {
    boolean retorno = false;
    if (conectar()) {
      try {
        ps = conexao.prepareStatement(sqlInclusao);
        ps.setString(1, cliente.getName());
        ps.setString(2, cliente.getEmail());
        ps.execute();
        retorno = true;
      } catch (SQLException sqle) {
      } finally {
        desconectar();
      }
    }
    return retorno;
  }
  // Método que realiza conexão ao banco de dados
  // Retorna 'true' se conectado
  public static boolean conectar() {
    try {
        
      Class.forName(DRIVER);
      conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
      estado = 1;
    } catch (ClassNotFoundException cnfe) {
      System.out.println(cnfe.getLocalizedMessage());
      estado = 2;
    } catch (SQLException sqle) {
      System.out.println(sqle.getLocalizedMessage());
      estado = 3;
    } finally {
      return (conexao != null);
    }
  }
 
  // Método que realiza desconexão ao banco de dados
  public static void desconectar() {
    if (conexao != null) {
      try {
        conexao.close();
      } catch (SQLException sqle) {
        System.out.println(sqle.getLocalizedMessage());
      }
    }
  }
 
  // Método que cria um objeto a partir de um registro
  private static Cliente popularCliente() throws SQLException {
    String nome = rs.getString("name");
    System.out.println("nome = " + nome);
    String email = rs.getString("email");
    Cliente cliente = new Cliente(nome, email);
    return cliente;
  }
}