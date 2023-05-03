package org.example.domain.entities;

import java.time.LocalDate;

public class Pessoa {
    private String nome;
    private LocalDate dataNascimento;

    @Override
    public String toString() {
        return "Nome: " + nome + '\n' +
                "Data de Nascimento=" + dataNascimento + '\n';
    }

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public Pessoa() {
    }
}
