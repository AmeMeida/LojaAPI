package com.loja.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LojaProduto")
public class Produto {
    // Fields
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(nullable = false, length = 350)
    private String descricao;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private double preco;


    // Constructors
    public Produto(String descricao, String marca, double preco) {
        setDescricao(descricao);
        setMarca(marca);
        setPreco(preco);
    }
    
    public Produto() { }


    // Getters and Setters
    public int getCodigo() {
        return codigo;
    }

    public final void setCodigo(int codigo) {
        if (codigo >= 0)
            this.codigo = codigo;
        else
            throw new IllegalArgumentException("O código deve ser maior ou igual a zero.");
    }

    public String getDescricao() {
        return descricao;
    }

    public final void setDescricao(String descricao) {
        if (descricao != null && descricao.length() >= 3 && descricao.length() <= 350)
            this.descricao = descricao.trim();
        else
            throw new IllegalArgumentException("A descrição não deve estar vazia e deve conter no máximo 350 caracteres.");
    }

    public String getMarca() {
        return marca;
    }

    public final void setMarca(String marca) {
        if (marca != null && !marca.trim().isEmpty())
            this.marca = marca.trim();
        else
            throw new IllegalArgumentException("A marca não deve estar vazia.");
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco > 0)
            this.preco = preco;
        else
            throw new IllegalArgumentException("O preço deve ser maior que zero.");
    }
}
