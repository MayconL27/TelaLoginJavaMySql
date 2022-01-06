package com.maycon.appfinal;

import java.util.ArrayList;
import java.util.Scanner;

import com.maycon.appfinal.model.Tarefa;
import com.maycon.appfinal.model.Usuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppfinalApplication {

	public static Usuario usuarioLogado = null;
    public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		SpringApplication.run(AppfinalApplication.class, args);

		ArrayList<Usuario> usuarios = new ArrayList();

        boolean rodando = true;
        while (rodando) {
            System.out.println("=== PAGINA INICIAL ===");
            System.out.println("1 Fazer cadastro");
            System.out.println("2 Fazer Login");
            System.out.println("3 Sair");
            System.out.println("Digite a opção: ");

            String opcao = sc.nextLine();

            switch (opcao) {
            case "1": {
                System.out.println("CADASTRO");
                System.out.println("Digite email: ");
                String email = sc.nextLine();
                System.out.println("Digite senha: ");
                String senha = sc.nextLine();

                Usuario u = new Usuario();
                u.getEmail(email);
                u.getSenha(senha);

                ArrayList<Tarefa> tarefas = new ArrayList();
                u.setTarefas(tarefas);

                usuarios.add(u); // adicionar array lista de usuarios em user.

                System.out.println("Usuario cadastrado");

                break;
            }
            // Fazer login
            case "2": {
                System.out.println("LOGIN");
                System.out.println("Digite Email:");
                String email = sc.nextLine();
                System.out.println("Digite a Senha:");
                String senha = sc.nextLine();

                boolean loginSucesso = false;
                for (Usuario u : usuarios) {
                    String uEmail = u.setEmail();
                    String uSenha = u.setSenha();

                    boolean emailConfere = email.equals(uEmail);
                    boolean senhaConfere = senha.equals(uSenha);

                    if (emailConfere && senhaConfere) {
                        loginSucesso = true;
                        usuarioLogado = u;
                        break;
                    }
                }
                if (!loginSucesso) {
                    System.out.println("-----> incorreto");
                } else {
                    System.out.println("Logado");
                    homePage();
                }
                break;
            }
            case "3": {
                rodando = false;
                System.out.println("Programa encerrado...");
                break;
            }
            default: {
                break;
            }

            }

        }
        System.out.println("Fim do programa");

    }
    public static void homePage() {
        boolean rodando = true;
        while (rodando) {
            System.out.println("=== HOME PAGE ===");
            System.out.println("1 mostrar tarefas");
            System.out.println("2 Mostrar tarefas finalizadas");
            System.out.println("3 Mostrar tarefas não finalizadas");
            System.out.println("4 Adicionar tarefas");
            System.out.println("5 Finalizar tarefas");
            System.out.println("6 Remover tarefa");
            System.out.println("7 Logout");
            System.out.print("Digite a opção: ");
            String opcao = sc.nextLine();

            switch (opcao) {
                // 1 mostrar tarefas
                case "1": {
                    System.out.println("===Lista de Tarefas===");
                    ArrayList<Tarefa> lista = usuarioLogado.getTarefas();

                    // CASOO LISTA DE TAREFAS ESTEJA VAZIA.
                    if (lista.isEmpty()) {
                        System.out.println("Lista de tarefas vazia.");
                    }

                    for(int i =0; i < lista.size(); i++) {

                        Tarefa t = lista.get(i);
                        System.out.println("Tarefa: " + i);
                        System.out.println("\tTitulo: " + t.getTitulo());
                        System.out.println("\tFinalizada: " + t.isFinalizada());

                    }

                    break;
                }
                // 2 Mostrar tarefas finalizadas
                case "2": {
                    System.out.println("=== TAREFAS FINALIZADAS ===");

                    ArrayList<Tarefa> lista = usuarioLogado.getTarefas();
                    ArrayList<Tarefa> finalizadas = new ArrayList();

                    for (Tarefa t : lista) {
                        if (t.isFinalizada()) {
                            finalizadas.add(t);
                        }
                    }
                    if (finalizadas.isEmpty()) {
                        System.out.println("Não á tarefas finalizadas.");
                    }

                    for (int i = 0; i < finalizadas.size(); i++) {
                        Tarefa t = finalizadas.get(i);
                        System.out.println("Tarefa " + i);
                        System.out.println("\tTítulo: " + t.getTitulo());
                        System.out.println("\tFinalizada: " + t.isFinalizada());
                    }

                    break;
                }
                // 3 Mostrar tarefas não finalizadas
                case "3": {
                    System.out.println("=== TAREFAS NÃO FINALIZADAS ===");

                    ArrayList<Tarefa> lista = usuarioLogado.getTarefas(); // PEGAR LISTA DE TAREFAS DO USUARIO LOGADO
                    ArrayList<Tarefa> naoFinalizadas = new ArrayList(); // ARRAY PRA GUARDA AS NÃO FINALIZADAS

                    for (Tarefa t : lista) {
                        if (!t.isFinalizada()) {
                            naoFinalizadas.add(t);
                        }
                    }
                    if (naoFinalizadas.isEmpty()) { // VERIFICA SE naoFinalizadas É VAZIO.
                        System.out.println("Nãp há tarefas em aberto");
                    }

                    for (int i = 0; i < naoFinalizadas.size(); i++) {
                        Tarefa t = naoFinalizadas.get(i);
                        System.out.println("Tarefa " + i);
                        System.out.println("\tTítulo: " + t.getTitulo());
                        System.out.println("\tFinalizada: " + t.isFinalizada());
                    }

                    break;
                }
                // 4 Adicionar tarefas
                case "4": {
                    break;
                }
                // 5 Finalizar tarefas
                case "5": {
                    break;
                }
                // 6 Remover tarefa
                case "6": {
                    break;
                }
                // 7 Logout
                case "7": {
                    System.out.println("Fazendo logout...");
                    rodando = false;
                    break;
                }
                
            }
        }
	}

}
