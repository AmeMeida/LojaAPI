package com.loja.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IControl<T, ID> {
    @GetMapping("/hello")
    public String sayHi();

    @GetMapping("/busca/todos")
    public List<T> findAll();

    @GetMapping("/busca/{id}")
    public Optional<T> findById(@PathVariable(value = "id") ID id);

    @CrossOrigin
    @PostMapping("/inserir")
    public void save(@RequestBody T entity);

    @CrossOrigin
    @PostMapping("/inserir_varios")
    public void saveAll(@RequestBody Iterable<T> entities);

    @DeleteMapping("/remover")
    public void delete(@RequestBody T entity);

    @DeleteMapping("/remover/{id}")
    public void deleteByID(@PathVariable(value = "id") ID id);

    @DeleteMapping("/remover_varios")
    public void deleteAll(@RequestBody Iterable<T> entities);

    @PutMapping("/atualizar")
    public void update(@RequestBody T entity);
}
