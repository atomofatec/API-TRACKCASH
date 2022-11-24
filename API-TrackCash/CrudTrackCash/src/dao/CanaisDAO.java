/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import conexaobanco.ConexaoComBanco;
import modelo.Canais;
import java.sql.*;
// Providencia ao NetBeans o acesso e o processamento de dados em um banco de dados.
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
// Um objeto que representa um pre-compilado de argumentos no SQL, podendo ser executado varias vezes.

public class CanaisDAO {
    private Connection connection;
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    int st;//status
    
    public CanaisDAO(){
        this.connection = new ConexaoComBanco().getConnection();

    }
    public void adicionacanal(Canais canais){
        String sql = "INSERT INTO canais(nome_canal, tipo_canal, padrao_autenticacao) VALUES(?, ? , ?)";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, canais.getNomecanal());
            stmt.setString(2, canais.getTipocanal());
            stmt.setString(3, canais.getPadraoautenticacao());
            stmt.execute();
        }
        catch (SQLException u){
            throw new RuntimeException(u);
        }
    }
    public boolean update(Canais canais){
        String sql = "UPDATE canais SET nome_canal = ?,tipo_canal = ?,padrao_autenticacao = ? WHERE id_canais = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, canais.getNomecanal());
            stmt.setString(2, canais.getTipocanal());
            stmt.setString(3, canais.getPadraoautenticacao());
            stmt.setInt(4, canais.getIdcanal());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro!"+ex);
            return false;
        }
    }
    public boolean saveusu(Canais canais){
        String sql = "INSERT INTO Canais(nome_canal,tipo_canal,padrao_autenticacao) VALUES (?,?,?)";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, canais.getNomecanal());
            stmt.setString(2, canais.getTipocanal());
            stmt.setString(3, canais.getPadraoautenticacao());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro!"+ex);
            return false;
        }
    }
    public DefaultTableModel fetchBySize(int start, int size) {
        
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Canais", "Tipo", "Padrão Autenticaçao"}, 0);
        try {
            String query = ("SELECT * FROM canais LIMIT " + start + "," + size);
            //System.out.println(query);
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int idcanais = rs.getInt("id_canais");
                String nome = rs.getString("nome_canal");
                String tipo = rs.getString("tipo_canal");
                String padraoautenticacao = rs.getString("padrao_autenticacao");

                model.addRow(new Object[]{idcanais, nome, tipo, padraoautenticacao});
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return model;
    }
    public double getRowCount() {
        ConexaoComBanco ccb = new ConexaoComBanco();
        Connection con = ccb.getConnection();
        /*        con = ConexaoComBanco.getConnection();*/
        long count = 0;
        try {
            String query = "SELECT count(*) FROM canais ";
            System.out.println(query);
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getLong("count(*)");
 
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return count;
    }
    public ResultSet listarCanal(){
        ConexaoComBanco ccb = new ConexaoComBanco();
        String sql = "SELECT nome_canal FROM canais nome_canal ORDER BY nome_canal;";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            return stmt.executeQuery();
            
        } catch (SQLException erro) {
                System.out.println(erro.getMessage());
                return null;
            }
    }   
}    