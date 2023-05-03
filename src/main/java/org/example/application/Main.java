package org.example.application;

import org.example.persistence.utils.DatabaseBuilder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        construirBanco();

        int opcao = 0;
        while (opcao != 5){
            menu();
            opcao = entradaUser();
        }

        System.out.println("Programa Encerrado!");
    }

    public static void menu(){
        System.out.println("====================");
        System.out.println("<1> Cadastre um usuário.");
        System.out.println("<2> Entre como usuário.");
        System.out.println("<3> Listar usuários.");
        System.out.println("<4> Remover usuário.");
        System.out.println("<5> Sair");
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