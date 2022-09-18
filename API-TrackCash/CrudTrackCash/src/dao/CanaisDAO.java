/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import conexãobanco.ConexaoComBanco;
import modelo.Canais;
import java.sql.*;
// Providencia ao NetBeans o acesso e o processamento de dados em um banco de dados.
import java.sql.PreparedStatement;
// Um objeto que representa um pre-compilado de argumentos no SQL, podendo ser executado varias vezes.

public class CanaisDAO {
    private Connection connection;
    
    public CanaisDAO(){
        this.connection = new ConexaoComBanco().getConnection();
    }
    public void adicionacanal(Canais canais){
        String sql = "INSERT INTO canais(nome_canal, tipo_canal, padrao_autentificacao) VALUES(?, ? , ?)";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, canais.getNomecanal());
            stmt.setString(2, canais.getTipocanal());
            stmt.setString(3, canais.getPadraoautentificacao());
            stmt.execute();
        }
        catch (SQLException u){
            throw new RuntimeException(u);
        }
    }    
}    