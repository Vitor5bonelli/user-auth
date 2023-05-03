package org.example.application;

import org.example.domain.usecases.UserUseCases;
import org.example.persistence.utils.DatabaseBuilder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserUseCases userCases = UserUseCases.getInstance();
        construirBanco();

        int opcao = 0;
        while (opcao != 6){
            menu();
            opcao = entradaUser();

            switch (opcao) {
                //Cadastrar
                case 1:
                    userCases.cadastraUsuario();
                    break;
                //Logar
                case 2:
                    break;
                //Listar todos
                case 3:
                    userCases.listaTodosOsCadastrados();
                    break;
                //Remover
                case 4:
                    break;
                    //Popular banco
                case 5:
                    break;
            }

        }

        System.out.println("Programa Encerrado!");
    }

    public static void menu(){
        System.out.println("====================");
        System.out.println("<1> Cadastre um usuário.");
        System.out.println("<2> Entre como usuário.");
        System.out.println("<3> Listar usuários.");
        System.out.println("<4> Remover usuário.");
        System.out.println("<5> Popular banco.");
        System.out.println("<6> Sair");
        System.out.println("====================");
    }

    public static void menuUserLogado(){
        System.out.println("====================");
        System.out.println("<1> Listar informações.");
        System.out.println("<2> Alterar nome.");
        System.out.println("<3> Alterar email.");
        System.out.println("<4> Alterar senha.");
        System.out.println("<4> Alterar data de nascimento.");
        System.out.println("<5> Voltar");
        System.out.println("====================");
    }

    public static Integer entradaUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insira o número da opção: ");
        return scanner.nextInt();
    }

    public static void construirBanco(){
        DatabaseBuilder db = new DatabaseBuilder();
        db.buildDatabaseIfMissing();
    }

    public void popularBanco(){

    }


}