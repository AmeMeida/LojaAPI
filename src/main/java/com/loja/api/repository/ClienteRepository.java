package com.loja.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.loja.api.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    public List<Cliente> findByNome(String nome);
    public List<Cliente> findByEmail(String email);

    @Query("SELECT cli FROM Cliente cli WHERE LOWER(cli.nome) LIKE ?1%")
    public List<Cliente> findByNomeStarts(String nome);

    @Query("SELECT cli FROM Cliente cli WHERE cli.codigo > ?1")
    public List<Cliente> findByCodigoGT(int codigo);

    @Query("SELECT cli FROM Cliente cli WHERE LOWER(cli.email) LIKE ?1%")
    public List<Cliente> findByEmailStarts(String email);

    @Query("SELECT cli FROM Cliente cli WHERE LOWER(cli.nome) LIKE ?1% AND LOWER(cli.email) LIKE ?2%")
    public List<Cliente> findByEmailStartsAndNomeStarts(String nome, String email);
}
