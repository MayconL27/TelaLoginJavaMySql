package com.maycon.appfinal.model;
import java.util.ArrayList;

public class Usuario {
    private String email, senha;
    private ArrayList<Tarefa> tarefas;
    
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
    public ArrayList<Tarefa> getTarefas() {
        return tarefas;
    }
    public void setTarefas(ArrayList<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }
    
    
}
