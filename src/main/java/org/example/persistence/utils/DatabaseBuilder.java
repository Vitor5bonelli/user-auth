package org.example.persistence.utils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseBuilder {
    public void buildDatabaseIfMissing() {
        if(!isDatabaseAvailable()){
            System.out.println("Database is missing. Building database: \n");
            buildUserTable();
        }
        else {
            System.out.println("Database Loaded!");
        }
    }

    private void buildUserTable() {
        String sql = createSqlUsertable();

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:company.db");
             PreparedStatement userTableStmt = conn.prepareStatement(sql)) {

            userTableStmt.executeUpdate();
            System.out.println("Database successfully created.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private String createSqlUsertable(){
        return """
                CREATE TABLE users (
                    email TEXT NOT NULL PRIMARY KEY UNIQUE,
                    username TEXT NOT NULL,
                    birthdate TEXT NOT NULL,
                    password TEXT NOT NULL
                );
                """;
    }

    private boolean isDatabaseAvailable(){
        return Files.exists(Paths.get("company.db"));
    }
}
