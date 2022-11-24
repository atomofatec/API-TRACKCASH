/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexaobanco;

import java.sql.Connection;
// Providencia a Conexao e Processamento de Dados no Java
import java.sql.DriverManager;
/*É uma classe estatica no Java que define do Java Database
Connectivity (JDBC) drivers que estão disponiveis para o uso na aplicação */
import java.sql.SQLException;
/*É utilizado para providenciar informação sobre erros no acesso a database do banco
ou outros erros.*/

public class ConexaoComBanco {
    public Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/bancoapiii?serverTimezone=UTC","root","senhabanco");          
        }
        catch(SQLException excecao){
            throw new RuntimeException(excecao);
        }
    }
}
