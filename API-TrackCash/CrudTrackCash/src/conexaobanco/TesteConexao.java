/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package conexãobanco;
import java.sql.Connection;
// Providencia a Conexao e Processamento de Dados no Java
import java.sql.SQLException;
/*É utilizado para providenciar informação sobre erros no acesso a database do banco
ou outros erros.*/

public class TesteConexao {

    
    public static void main(String[] args) throws SQLException {
        Connection conexaobanco = new ConexaoComBanco().getConnection();
        System.out.println("Conexão Aberta !");
        conexaobanco.close();
    }   
}