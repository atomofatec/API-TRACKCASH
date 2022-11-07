/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author thiag
 */
public class CanalUser {
    
    private int idusuario;
    private String nome_canal;
    private String token;
    private String usuario;
    private String senha;

    public CanalUser() {
        this.idusuario = idusuario;
        this.nome_canal = nome_canal;
        this.token = token;
        this.usuario = usuario;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNome_canal() {
        return nome_canal;
    }

    public void setNome_canal(String nome_canal) {
        this.nome_canal = nome_canal;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}

