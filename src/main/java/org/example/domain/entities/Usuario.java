package org.example.domain.entities;

import java.time.LocalDate;

public class Usuario extends Pessoa{
    private String email;
    private String senha;

    public Usuario(String nome, LocalDate dataNascimento, String email, String senha) {
        super(nome, dataNascimento);
        this.email = email;
        this.senha = senha;
    }

    @Override
    public String toString() {
        return super.toString() + "Email: " + this.email + '\n';
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
}
