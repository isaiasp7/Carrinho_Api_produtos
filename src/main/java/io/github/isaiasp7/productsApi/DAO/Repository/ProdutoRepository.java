package io.github.isaiasp7.productsApi.DAO.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.isaiasp7.productsApi.Models.Produto;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, String> {
    List<Produto> findByNomeContainingIgnoreCase(String id);
    List<Produto> findByIdAndNomeContainingIgnoreCase(String id,String name);
    List<Produto> findByIdContainingIgnoreCase(String id);
}
