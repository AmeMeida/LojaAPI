package com.loja.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loja.api.model.Produto;
import com.loja.api.repository.ProdutoRepository;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoControl implements IControl<Produto, Integer> {
    @Autowired
    ProdutoRepository repo;

    // WORKS
    // localhost:8080/produtos/hello
    public String sayHi() {
        return "Produto says Hi!";
    }

    // WORKS
    // localhost:8080/produtos/buscar/
    public Optional<Produto> findById(Integer codigo) {
        return repo.findById(codigo);
    }

    // WORKS
    // localhost:8080/produtos/buscar/todos
    public List<Produto> findAll() {
        return repo.findAll();
    }

    // WORKS
    // localhost:8080/produtos/atualizar
    public void update(Produto prod) {
        repo.save(prod);
    }

    // WORKS
    // localhost:8080/produtos/inserir
    public void save(Produto prod) {
        repo.save(prod);
    }

    // WORKS
    // localhost:8080/produtos/inserir_varios
    public void saveAll(Iterable<Produto> prods) {
        repo.saveAll(prods);
    }

    // WORKS
    // localhost:8080/produtos/remover
    public void delete(Produto prod) {
        repo.delete(prod);
    }

    // localhost:8080/produtos/remover/
    public void deleteByID(Integer codigo) {
        repo.deleteById(codigo);
    }

    // WORKS
    // localhost:8080/produtos/remover_varios
    public void deleteAll(Iterable<Produto> prods) {
        repo.deleteAll(prods);
    }

    // WORKS
    // localhost:8080/produtos/busca/descricao/
    @GetMapping("/busca/descricao/{descricao}")
    public List<Produto> findByDescricao(@PathVariable(value = "descricao") String descricao) {
        return repo.findByDescricao(descricao);
    }

    // WORKS
    // localhost:8080/produtos/busca/marca/
    @GetMapping("/busca/marca/{marca}")
    public List<Produto> findByMarca(@PathVariable(value = "marca") String marca) {
        return repo.findByMarca(marca);
    }

    // WORKS
    // localhost:8080/produtos/busca/preco/
    @GetMapping("/busca/preco/{preco}")
    public List<Produto> findByPreco(@PathVariable(value = "preco") double preco) {
        return repo.findByPreco(preco);
    }

    // WORKS
    // localhost:8080/produtos/comeco_da_descricao/
    @GetMapping("/busca/comeco_da_descricao/{descricao}")
    public List<Produto> findByDescricaoStarts(@PathVariable(value = "descricao") String descricao) {
        return repo.findByDescricaoStarts(descricao.toLowerCase());
    }

    // WORKS
    // localhost:8080/produtos/comeco_da_marca/
    @GetMapping("/busca/comeco_da_marca/{marca}")
    public List<Produto> findByMarcaStarts(@PathVariable(value = "marca") String marca) {
        return repo.findByMarcaStarts(marca);
    }

    // WORKS
    // localhost:8080/produtos/busca/preco_maior_que/
    @GetMapping("/busca/preco_maior_que/{preco}")
    public List<Produto> findByPrecoGT(@PathVariable(value = "preco") double preco) {
        return repo.findByPrecoGT(preco);
    }

    // WORKS
    // localhost:8080/produtos/busca/preco_maior_que/
    @GetMapping("/busca/preco_menor_que/{preco}")
    public List<Produto> findByPrecoLT(@PathVariable(value = "preco") double preco) {
        return repo.findByPrecoLT(preco);
    }

    // WORKS
    // localhost:8080/produtos/busca/descricao_contem/ /
    @GetMapping("/busca/descricao_contem/{descricao}/marca_contem/{marca}")
    public List<Produto> findByDescContainsAndMarcaContains(@PathVariable(value = "descricao") String descricao, @PathVariable(value = "marca") String marca) {
        return repo.findByDescContainsAndMarcaContains(descricao.toLowerCase(), marca.toLowerCase());
    }

    // WORKS
    // localhost:8080/produtos/busca/descricao_contem/ /preco_menor_que/
    @GetMapping("/busca/descricao_contem/{descricao}/preco_menor_que/{preco}")
    public List<Produto> findByDescContainsAndPrecoLT(@PathVariable(value = "descricao") String descricao, @PathVariable(value = "preco") double preco) {
        return repo.findByDescContainsAndPrecoLT(descricao.toLowerCase(), preco);
    }
}

