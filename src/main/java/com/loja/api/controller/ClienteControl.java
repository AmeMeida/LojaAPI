package com.loja.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loja.api.model.Cliente;
import com.loja.api.repository.ClienteRepository;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteControl implements IControl<Cliente, Integer> {
    @Autowired
    ClienteRepository repo;

    // WORKS
    // localhost:8080/clientes/hello
    public String sayHi() {
        return "Cliente says Hi!";
    }

    // WORKS
    // localhost:8080/clientes/buscar/todos
    public List<Cliente> findAll() {
        return repo.findAll();
    }

    // WORKS
    // localhost:8080/clientes/inserir
    public void save(Cliente cliente) {
        repo.save(cliente);
    }

    // WORKS
    // localhost:8080/clientes/inserir_varios
    public void saveAll(Iterable<Cliente> entities) {
        repo.saveAll(entities);
    }

    // WORKS
    // localhost:8080/clientes/remover
    public void delete(Cliente cliente) {
        repo.delete(cliente);
    }

    // WORKS
    // localhost:8080/clientes/remover/
    public void deleteByID(Integer codigo) {
        repo.deleteById(codigo);
    }

    // WORKS
    // localhost:8080/clientes/remover_varios
    public void deleteAll(Iterable<Cliente> entities) {
        repo.deleteAll(entities);
    }

    // WORKS
    // localhost:8080/clientes/atualizar
    public void update(Cliente cliente) {
        repo.save(cliente);
    }

    // WORKS
    // localhost:8080/clientes/busca/
    public Optional<Cliente> findById(Integer codigo) {
        return repo.findById(codigo);
    }

    // WORKS
    @GetMapping("/busca/nome/{nome}")
    // localhost:8080/clientes/busca/nome/
    public List<Cliente> findByNome(@PathVariable(value = "nome") String nome) {
        return repo.findByNome(nome);
    }
    
    // WORKS
    @GetMapping("/busca/email/{email}")
    // localhost:8080/clientes/busca/email/
    public List<Cliente> findByEmail(@PathVariable(value = "email") String email) {
        return repo.findByEmail(email);
    }

    // WORKS
    // localhost:8080/clientes/busca/comeco_do_nome/
    @GetMapping("/busca/comeco_do_nome/{nome}")
    public List<Cliente> findByNomeStarts(@PathVariable(value = "nome") String nome) {
        return repo.findByNomeStarts(nome.toLowerCase());
    }

    // WORKS
    // localhost:8080/clientes/codigo_maior_que/
    @GetMapping("/busca/codigo_maior_que/{codigo}")
    public List<Cliente> findByCodigoGT(@PathVariable(value = "codigo") int codigo) {
        return repo.findByCodigoGT(codigo);
    }

    // WORKS
    // localhost:8080/clientes/comeco_do_email/
    @GetMapping("/busca/comeco_do_email/{email}")
    public List<Cliente> findByEmailStarts(@PathVariable(value = "email") String email) {
        return repo.findByEmailStarts(email.toLowerCase());
    }

    // WORKS
    // localhost:8080/clientes/comeco_do_nome/ /comeco_do_email/
    @GetMapping("/busca/comeco_do_nome/{nome}/comeco_do_email/{email}")
    public List<Cliente> findByEmailStartsAndNomeStarts(@PathVariable(value = "nome") String nome, @PathVariable(value = "email") String email) {
        return repo.findByEmailStartsAndNomeStarts(nome.toLowerCase(), email.toLowerCase());
    }
}
