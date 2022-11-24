/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author PICHAU
 */
public class Secao {
    
    private int id_user;
    private String nome_user;
    private String email_user;
    private String tipo_user;

    public Secao(int id_user, String nome_user, String email_user, String tipo_user) {
        this.id_user = id_user;
        this.nome_user = nome_user;
        this.email_user = email_user;
        this.tipo_user = tipo_user;
    }

    public Secao() {
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getNome_user() {
        return nome_user;
    }

    public void setNome_user(String nome_user) {
        this.nome_user = nome_user;
    }

    public String getEmail_user() {
        return email_user;
    }

    public void setEmail_user(String email_user) {
        this.email_user = email_user;
    }

    public String getTipo_user() {
        return tipo_user;
    }

    public void setTipo_user(String tipo_user) {
        this.tipo_user = tipo_user;
    }
}
