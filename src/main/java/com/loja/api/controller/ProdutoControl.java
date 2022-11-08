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

import com.loja.api.model.Produto;
import com.loja.api.repository.ProdutoRepository;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoControl {
    @Autowired
    ProdutoRepository repo;

    @GetMapping("/busca/codigo/{codigo}")
    public Optional<Produto> findByCodigo(@PathVariable(value = "codigo") int codigo) {
        return repo.findById(codigo);
    }

    @GetMapping("/todos")
    public List<Produto> findAll() {
        return repo.findAll();
    }

    @PutMapping("/atualizar")
    public void atualizar(@RequestBody Produto prod) {
        repo.save(prod);
    }

    @CrossOrigin
    @PostMapping("/inserir")
    public void inserir(@RequestBody Produto prod) {
        repo.save(prod);
    }

    @GetMapping("/busca/descricao/{descricao}")
    public List<Produto> findByDescricao(@PathVariable(value = "descricao") String descricao) {
        return repo.findByDescricao(descricao);
    }

    @GetMapping("/busca/marca/{marca}")
    public List<Produto> findByMarca(@PathVariable(value = "marca") String marca) {
        return repo.findByMarca(marca);
    }

    @GetMapping("/busca/preco/{preco}")
    public List<Produto> findByPreco(@PathVariable(value = "preco") double preco) {
        return repo.findByPreco(preco);
    }

    @GetMapping("/busca/comeco_da_descricao/{descricao}")
    public List<Produto> findByDescricaoStarts(@PathVariable(value = "descricao") String descricao) {
        return repo.findByDescricaoStarts(descricao);
    }

    @GetMapping("/busca/comeco_da_marca/{marca}")
    public List<Produto> findByMarcaStarts(@PathVariable(value = "marca") String marca) {
        return repo.findByMarcaStarts(marca);
    }

    @GetMapping("/busca/preco_maior_que/{preco}")
    public List<Produto> findByPrecoGT(@PathVariable(value = "preco") double preco) {
        return repo.findByPrecoGT(preco);
    }

    @GetMapping("/busca/preco_menor_que/{preco}")
    public List<Produto> findByPrecoLT(@PathVariable(value = "preco") double preco) {
        return repo.findByPrecoLT(preco);
    }

    @GetMapping("/busca/descricao_contem/{descricao}/marca_contem/{marca}")
    public List<Produto> findByDescContainsAndMarcaContains(@PathVariable(value = "descricao") String descricao, @PathVariable(value = "marca") String marca) {
        return repo.findByDescContainsAndMarcaContains(descricao, marca);
    }

    @GetMapping("/busca/descricao_contem/{descricao}/preco_menor_que/{preco}")
    public List<Produto> findByDescContainsAndPrecoLT(String descricao, double preco) {
        return repo.findByDescContainsAndPrecoLT(descricao, preco);
    }
}
