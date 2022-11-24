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

    public Canais() {
        this.idcanal = idcanal;
        this.token = token;
        this.tipocanal = tipocanal;
        this.nomecanal = nomecanal;
        this.padraoautenticacao = padraoautenticacao;
        this.usuariocanal = usuariocanal;
        this.senhacanal = senhacanal;
    }
    private int idcanal;
    private String token;
    private String tipocanal;
    private String nomecanal;
    private String padraoautenticacao;
    private String usuariocanal;
    private String senhacanal;
    
    public int getIdcanal(){
        return idcanal;
    }
    public void setIdcanal(int idcanal){
        this.idcanal = idcanal;
    }
    public String getToken(){
        return token;
    }
    public void setToken(String token){
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
    public String getPadraoautenticacao(){
        return padraoautenticacao;
    }
    public void setPadraoautenticacao(String padraoautenticacao){
        this.padraoautenticacao = padraoautenticacao;
    }
    public String getUsuariocanal(){
        return usuariocanal;
    }
    public void setUsuariocanal(String usuariocanal){
        this.usuariocanal = usuariocanal;
    }
    public String getSenhacanal(){
        return senhacanal;
    }
    public void setSenhacanal(String senhacanal){
        this.senhacanal = senhacanal;
    }
}
