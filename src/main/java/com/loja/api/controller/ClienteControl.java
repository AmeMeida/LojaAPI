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
    public String sayHi() {
        return "Cliente says Hi!";
    }

    // WORKS
    public List<Cliente> findAll() {
        return repo.findAll();
    }

    // WORKS
    public void save(Cliente cliente) {
        repo.save(cliente);
    }

    // WORKS
    public void saveAll(Iterable<Cliente> entities) {
        repo.saveAll(entities);
    }

    // WORKS
    public void delete(Cliente cliente) {
        repo.delete(cliente);
    }

    // WORKS
    public void deleteAll(Iterable<Cliente> entities) {
        repo.deleteAll(entities);
    }

    // WORKS
    public void update(Cliente cliente) {
        repo.save(cliente);
    }

    // WORKS
    public Optional<Cliente> findById(Integer codigo) {
        return repo.findById(codigo);
    }

    // WORKS
    @GetMapping("/busca/nome/{nome}")
    public List<Cliente> findByNome(@PathVariable(value = "nome") String nome) {
        return repo.findByNome(nome);
    }
    
    // WORKS
    @GetMapping("/busca/email/{email}")
    public List<Cliente> findByEmail(@PathVariable(value = "email") String email) {
        return repo.findByEmail(email);
    }

    // WORKS
    @GetMapping("/busca/comeco_do_nome/{nome}")
    public List<Cliente> findByNomeStarts(@PathVariable(value = "nome") String nome) {
        return repo.findByNomeStarts(nome.toLowerCase());
    }

    // WORKS
    @GetMapping("/busca/codigo_maior_que/{codigo}")
    public List<Cliente> findByCodigoGT(@PathVariable(value = "codigo") int codigo) {
        return repo.findByCodigoGT(codigo);
    }

    // WORKS
    @GetMapping("/busca/comeco_do_email/{email}")
    public List<Cliente> findByEmailStarts(@PathVariable(value = "email") String email) {
        return repo.findByEmailStarts(email.toLowerCase());
    }

    // WORKS
    @GetMapping("/busca/comeco_do_nome/{nome}/comeco_do_email/{email}")
    public List<Cliente> findByEmailStartsAndNomeStarts(@PathVariable(value = "nome") String nome, @PathVariable(value = "email") String email) {
        return repo.findByEmailStartsAndNomeStarts(nome.toLowerCase(), email.toLowerCase());
    }
}
