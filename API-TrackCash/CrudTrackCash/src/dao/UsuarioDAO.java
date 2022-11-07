/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexãobanco.ConexaoComBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import modelo.Usuario;

/**
 *
 * @author Dutev
 */
public class UsuarioDAO {
    
    private Connection connection;
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    int st;
    
    public UsuarioDAO(){
        this.connection = new ConexaoComBanco().getConnection();
    }
    public void adicionaUsuario(Usuario usuario){
        String sql = "INSERT INTO usuario(email_usuario, nome_usuario, senha_usuario, tipo_usuario) VALUES(?, ?, ?, 'comum')";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario.getEmail_usuario());
            stmt.setString(2, usuario.getNome_usuario());
            stmt.setString(3, usuario.getSenha_usuario());
            stmt.execute();
        }
        catch (SQLException u){
            throw new RuntimeException(u);
        }
    }
    public boolean updateUsuario(Usuario usuario){
        String sql = "UPDATE usuario SET nome_usuario = ?, email_usuario = ?,senha_usuario = ? WHERE id_usuario = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario.getNome_usuario());
            stmt.setString(2, usuario.getEmail_usuario());
            stmt.setString(3, usuario.getSenha_usuario());
            stmt.setInt(4, usuario.getId_usuario());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro!"+ex);
            return false;
        }
    }
    public DefaultTableModel fetchBySizeUsu(int start, int size) {
        
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Nome", "E-mail", "Senha"}, 0);
        try {
            String query = ("SELECT * FROM usuario LIMIT " + start + "," + size);
            System.out.println(query);
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int idusuario = rs.getInt("id_usuario");
                String nome = rs.getString("nome_usuario");
                String email = rs.getString("email_usuario");
                String senha = rs.getString("senha_usuario");

                model.addRow(new Object[]{idusuario, nome, email, senha});
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
    
    public boolean checkLogin(String email, String senha){
       
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean checagem = false;
        
        try{
            stmt = connection.prepareStatement("SELECT * FROM usuario WHERE email_usuario = ? and senha_usuario = ?");
            stmt.setString(1, email);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
           
            if (rs.next()){
                checagem = true;
            }
           
        }catch(SQLException ex){
            System.out.println("Algo ocorreu errado, tente novamente !");
        }finally{
            try {
                connection.close();
            } catch (SQLException ex) {
                System.out.println("Algo ocorreu errado, tente novamente !");
            }
        }
        return checagem;
    }
    
    public double getRowCountUsu() {
        ConexaoComBanco ccb = new ConexaoComBanco();
        Connection con = ccb.getConnection();
        /*        con = ConexaoComBanco.getConnection();*/
        long count = 0;
        try {
            String query = "SELECT count(*) FROM usuario ";
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
}
