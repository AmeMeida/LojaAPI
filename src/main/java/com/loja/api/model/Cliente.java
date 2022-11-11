package com.loja.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LojaCliente")
public class Cliente {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    public Cliente() { }

    public Cliente(String nome, String email) {
        setNome(nome);
        setEmail(email);
    }

    public int getCodigo() {
        return codigo;
    }

    public final void setCodigo(int codigo) {
        if (codigo >= 0)
            this.codigo = codigo;
        else
            throw new IllegalArgumentException("O código deve ser maior ou igual a zero.");
    }

    public String getNome() {
        return nome;
    }

    public final void setNome(String nome) {
        if (nome != null && nome.trim().length() >= 3 && nome.trim().length() <= 255)
            this.nome = nome.trim();
        else
            throw new IllegalArgumentException("O nome inserido é inválido.");
    }

    public String getEmail() {
        return email;
    }

    public final void setEmail(String email) {
        if (email != null && email.trim().matches("^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$"))
            this.email = email.trim();
        else
            throw new IllegalArgumentException("O email inserido é inválido.");
    }
}
