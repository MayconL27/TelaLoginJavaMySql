package com.maycon.appfinal.model;

public class Usuario {
    private String email, senha;
    
    public void getEmail(String email){
        this.email = email;
    }
    public String setEmail(){
    return email;
    }
    public void getSenha(String senha){
        this.senha = senha;
    }
    public String setSenha(){
        return senha;
    }
    
}
