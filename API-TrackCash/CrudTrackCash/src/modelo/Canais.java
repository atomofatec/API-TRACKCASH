/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author PICHAU
 */
public class Canais {
    private int idcanal;
    private int token;
    private String tipocanal;
    private String nomecanal;
    private String padraoautentificacao;
    private String senhacanal;
    
    public int getIdcanal(){
        return idcanal;
    }
    public void setIdcanal(int idcanal){
        this.idcanal = idcanal;
    }
    public int getToken(){
        return token;
    }
    public void setToken(int token){
        this.token = token;
    }
    public String getTipocanal(){
        return tipocanal;
    }
    public void setTipocanal(String tipocanal){
        this.tipocanal = tipocanal;
    }
    public String getNomecanal(){
        return nomecanal;
    }
    public void setNomecanal(String nomecanal){
        this.nomecanal = nomecanal;
    }
    public String getPadraoautentificacao(){
        return padraoautentificacao;
    }
    public void setPadraoautentificacao(String padraoautentificacao){
        this.padraoautentificacao = padraoautentificacao;
    }
    public String getSenhacanal(){
        return senhacanal;
    }
    public void setSenhacanal(String senhacanal){
        this.senhacanal = senhacanal;
    }
}
