package com.loja.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loja.api.model.Cliente;
import com.loja.api.repository.ClienteRepository;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteControl {
    @Autowired
    ClienteRepository repo;

    @GetMapping("/todos")
    public List<Cliente> findAll() {
        return repo.findAll();
    }

    @CrossOrigin
    @PostMapping("/inserir")
    public void save(@RequestBody Cliente cliente) {
        repo.save(cliente);
    }

    @PutMapping("/atualizar")
    public void update(@RequestBody Cliente cliente) {
        repo.save(cliente);
    }

    @GetMapping("/busca/codigo/{codigo}")
    public Optional<Cliente> findByCodigo(@PathVariable(value = "nome") Integer codigo) {
        return repo.findById(codigo);
    }

    @GetMapping("/busca/nome/{nome}")
    public List<Cliente> findByNome(@PathVariable(value = "nome") String nome) {
        return repo.findByNome(nome);
    }

    @GetMapping("/busca/email/{email}")
    public List<Cliente> findByEmail(@PathVariable(value = "email") String email) {
        return repo.findByEmail(email);
    }

    @GetMapping("/busca/comeco_do_nome/{nome}")
    public List<Cliente> findByNomeStarts(@PathVariable(value = "nome") String nome) {
        return repo.findByNomeStarts(nome.toLowerCase());
    }

    @GetMapping("/busca/preco_menor_que/{codigo}")
    public List<Cliente> findByCodigoGT(@PathVariable(value = "codigo") int codigo) {
        return repo.findByCodigoGT(codigo);
    }

    @GetMapping("/busca/comeco_do_email/{email}")
    public List<Cliente> findByEmailStarts(@PathVariable(value = "email") String email) {
        return repo.findByEmailStarts(email.toLowerCase());
    }

    @GetMapping("/busca/comeco_do_nome/{nome}/comeco_do_email/{email}")
    public List<Cliente> findByEmailStartsAndNomeStarts(@PathVariable(value = "nome") String nome, @PathVariable(value = "email") String email) {
        return repo.findByEmailStartsAndNomeStarts(nome.toLowerCase(), email.toLowerCase());
    }
}
