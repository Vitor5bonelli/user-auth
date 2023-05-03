package org.example.domain.usecases;

import org.example.domain.entities.Usuario;

import java.sql.*;
import java.util.Scanner;

public class UserUseCases {

    private static UserUseCases singleton;

    public static UserUseCases getInstance(){
        if(singleton == null){
            singleton = new UserUseCases();
        }
        return singleton;
    }

    public void cadastraUsuario(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Insira um email para o novo usuário: ");
        String email = scanner.nextLine();

        if(!emailExiste(email)){
            System.out.print("Insira a senha para o novo usuário: ");
            String senha = scanner.nextLine();

            System.out.print("Insira o nome do novo usuário: ");
            String nome = scanner.nextLine();

            Usuario user = new Usuario(nome, email, senha);

            insereUserNoBanco(user);

        }else {
            System.out.println("Esse email já foi cadastrado...");
        }

    }

    public void insereUserNoBanco(Usuario user){
        String sql = createSqlInsertUser();

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:company.db");
             PreparedStatement userTableStmt = conn.prepareStatement(sql)) {

            userTableStmt.setString(1, user.getEmail());
            userTableStmt.setString(2, user.getNome());
            userTableStmt.setString(3, "");
            userTableStmt.setString(4, user.getSenha());

            userTableStmt.executeUpdate();
            System.out.println("Usuário Cadastrado no banco com Sucesso!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void listaTodosOsCadastrados(){
        String sql = createSqlGetAllUsers();

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:company.db");
             PreparedStatement userTableStmt = conn.prepareStatement(sql)) {

            ResultSet result = userTableStmt.executeQuery();

            System.out.println("==== Usuários Cadastrados ====");
            while (result.next()){
                System.out.print("Nome: " + result.getString(2) +
                        " | Email: " + result.getString(1) + "\n");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean emailExiste(String email){
        String sql = createSqlGetUserByEmail();

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:company.db");
             PreparedStatement userTableStmt = conn.prepareStatement(sql)) {

            userTableStmt.setString(1, email);

            ResultSet result = userTableStmt.executeQuery();

            return result.next();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    private String createSqlGetUserByEmail(){
        return "SELECT * FROM users WHERE email = ? ";
    }

    private String createSqlGetAllUsers(){
        return "SELECT * FROM users";
    }

    private String createSqlInsertUser(){
        return "INSERT INTO users (email, username, birthdate, password) values (?,?,?,?)";
    }
}
