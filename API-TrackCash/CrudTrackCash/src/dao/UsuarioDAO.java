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

    public UsuarioDAO() {
        this.connection = new ConexaoComBanco().getConnection();
    }

    public void adicionaUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuario(email_usuario, nome_usuario, senha_usuario, tipo_usuario) VALUES(?, ?, ?, 'User')";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario.getEmail_usuario());
            stmt.setString(2, usuario.getNome_usuario());
            stmt.setString(3, usuario.getSenha_usuario());
            stmt.execute();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    public boolean updateUsuario(Usuario usuario) {
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
            System.err.println("Erro!" + ex);
            return false;
        }
    }

    public DefaultTableModel fetchBySizeUsu(int start, int size) {

        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Nome", "E-mail", "Senha"}, 0);
        try {
            String query = ("SELECT * FROM usuario LIMIT " + start + "," + size);
            //System.out.println(query);
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

    public double getRowCountUsu() {
        ConexaoComBanco ccb = new ConexaoComBanco();
        Connection con = ccb.getConnection();
        //con = ConexaoComBanco.getConnection();
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

    public ResultSet autenticacaoUsuario(Usuario objUsuario) {
        con = new ConexaoComBanco().getConnection();

        try {
            String sql = "SELECT * FROM usuario WHERE email_usuario = (?) and senha_usuario = (?) and tipo_usuario = (?)";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, objUsuario.getEmail_usuario());
            pstm.setString(2, objUsuario.getSenha_usuario());
            pstm.setString(3, objUsuario.getTipo_usuario());
            
            ResultSet rs = pstm.executeQuery();
            return rs;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"UsuarioDAO: "+ erro);
            return null;
        }
    }
    
    public Usuario obterUsuarioPorId(int idUsuario) {
        con = new ConexaoComBanco().getConnection();

        try {
            String sql = "SELECT * FROM usuario WHERE id_usuario = (?)";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, idUsuario);

            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                int idusuario = rs.getInt("id_usuario");
                String nome = rs.getString("nome_usuario");
                String email = rs.getString("email_usuario");
                String senha = rs.getString("senha_usuario");
                String tipo = rs.getString("tipo_usuario");
                Usuario usuario = new Usuario(idusuario, email, nome, senha, tipo);
                return usuario;
            } else {
                return null;
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO: " + erro);
            return null;
        }
    }
}
