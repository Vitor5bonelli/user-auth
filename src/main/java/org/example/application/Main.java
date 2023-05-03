package org.example.application;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

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

    public static Integer entradaUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insira o número da opção: ");
        return scanner.nextInt();
    }

    /*
    CREATE TABLE users (
      username    TEXT NOT NULL,
      birthdate   TEXT NOT NULL,
      email       TEXT NOT NULL,
      password    TEXT NOT NULL
    );
     */
}