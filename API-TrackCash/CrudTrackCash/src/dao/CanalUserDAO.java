/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexaobanco.ConexaoComBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.CanalUser;
import modelo.Usuario;

/**
 *
 * @author thiag
 */
public class CanalUserDAO {

    private Connection connection;
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    int st;//status

    public CanalUserDAO() {
        this.connection = new ConexaoComBanco().getConnection();
    }

    public void adicionaCanalUser(CanalUser user) {
        String sql = "INSERT INTO canal_usuario(nome_canal, token, usuario, senha, id_usuario) VALUES(?, ?, ?, ?, ?)";
        con = new ConexaoComBanco().getConnection();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getNome_canal());
            ps.setString(2, user.getToken());
            ps.setString(3, user.getUsuario());
            ps.setString(4, user.getSenha());
            ps.setInt(5, user.getIdusuario());
            
            ps.execute();
            ps.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "CanalUserDAO" + erro);
        }
    }

    public DefaultTableModel User(int idUsuario, int start, int size) {

        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Nome", "Token", "Usuário", "Senha",}, 0);
        try {
            String query = ("SELECT * FROM canal_usuario WHERE id_usuario = ? LIMIT " + start + "," + size);
            ps = connection.prepareStatement(query);
            ps.setInt(1, idUsuario);
            rs = ps.executeQuery();
            while (rs.next()) {
                int idusuario = rs.getInt("id_canal_usuario");
                String nome = rs.getString("nome_canal");
                String token = rs.getString("token");
                String usuario = rs.getString("usuario");
                String senha = rs.getString("senha");

                model.addRow(new Object[]{idusuario, nome, token, usuario, senha});
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

    public double getRowCount(int idUsuario) {
        ConexaoComBanco ccb = new ConexaoComBanco();
        Connection con = ccb.getConnection();
        /*        con = ConexaoComBanco.getConnection();*/
        long count = 0;
        try {
            String query = "SELECT count(*) FROM canal_usuario WHERE id_usuario = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, idUsuario);
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getLong("count(*)");

            }
            //System.out.println(query + " Quantidade de itens " + count);
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

    public boolean updateUser(CanalUser user) {
        String sql = "UPDATE canal_usuario SET nome_canal = ?,token = ?,usuario = ?,senha = ? WHERE id_canal_usuario = ?";

        PreparedStatement stmt = null;

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, user.getNome_canal());
            stmt.setString(2, user.getToken());
            stmt.setString(3, user.getUsuario());
            stmt.setString(4, user.getSenha());
            stmt.setInt(5, user.getIdusuario());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Erro!" + ex);
        } 
        return false;
    }
}
