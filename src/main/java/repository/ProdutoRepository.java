package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.loja.api.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    public List<Produto> findByDescricao(String descricao);
    public List<Produto> findByMarca(String marca);
    public List<Produto> findByPreco(double preco);

    @Query("SELECT prod FROM Produto prod WHERE LOWER(prod.descricao) LIKE '?1%'")
    public List<Produto> findByDescricaoStarts(String descricao);

    @Query("SELECT prod FROM Produto prod WHERE LOWER(prod.marca) LIKE '?1%'")
    public List<Produto> findByMarcaStarts(String marca);

    @Query("SELECT prod FROM Produto prod WHERE LOWER(prod.preco) > ?1")
    public List<Produto> findByPrecoGT(double preco);

    @Query("SELECT prod FROM Produto prod WHERE LOWER(prod.preco) < ?1")
    public List<Produto> findByPrecoLT(double preco);

    @Query("SELECT prod FROM Produto prod WHERE LOWER(prod.descricao) LIKE '%?1%' AND LOWER(prod.marca) LIKE '%?2%'")
    public List<Produto> findByDescContainsAndMarcaContains(String descricao, String marca);

    @Query("SELECT prod FROM Produto prod WHERE LOWER(prod.descricao) LIKE '%?1%' AND prod.preco < ?2")
    public List<Produto> findByDescContainsAndPrecoLT(String descricao, double preco);
}
