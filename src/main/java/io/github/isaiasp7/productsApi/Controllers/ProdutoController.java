package io.github.isaiasp7.productsApi.Controllers;

import java.util.List;


import io.github.isaiasp7.productsApi.DAO.Repository.ProdutoRepository;
import io.github.isaiasp7.productsApi.DAO.Services.ProdutoService;
import io.github.isaiasp7.productsApi.DTO.ProdDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.github.isaiasp7.productsApi.Models.Produto;


@RestController
@RequestMapping("produtos")
public class ProdutoController {
    @Autowired
	private ProdutoService produtoService;



    @PostMapping
    public ResponseEntity salvar(@RequestBody Produto produto){
        return ResponseEntity.ok(produtoService.salvar(produto));

    }
    @GetMapping
    public ResponseEntity<List<Produto>> getProdutos(
            @RequestParam(required = false) String id,
            @RequestParam(required = false) String name) {

        return ResponseEntity.ok(
                produtoService.searchFilters(id, name)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") String produtoId){
         produtoService.removerId(produtoId);
        return ResponseEntity.noContent().build(); // HTTP 204
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@RequestBody String produce, @PathVariable String id){
        return ResponseEntity.ok(produtoService.atualizarProd(id,produce));

    }

}
