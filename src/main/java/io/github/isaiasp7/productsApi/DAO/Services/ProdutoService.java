package io.github.isaiasp7.productsApi.DAO.Services;

import io.github.isaiasp7.productsApi.DTO.ProdDTO;
import io.github.isaiasp7.productsApi.Exceptions.ProdutoNaoEncontrado;
import io.github.isaiasp7.productsApi.Models.Produto;
import io.github.isaiasp7.productsApi.DAO.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.UUID;
@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;




    public Produto salvar(Produto produto){
        var id = UUID.randomUUID().toString();
        produto.setId(id);
        System.out.println(produto);
        produtoRepository.save(produto);
        return produto;
    }

    public void removerId(String id) {
        if (!produtoRepository.existsById(id)) {
            throw new ProdutoNaoEncontrado(
                    "Produto não encontrado. Id: " + id
            );
        }

        produtoRepository.deleteById(id);
    }



    public Produto atualizarProd(String id, String prod) {
        ObjectMapper objectMapper = new ObjectMapper();
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new ProdutoNaoEncontrado(
                        "Produto não encontrado. Id: " + id
                ));

        try {
            // Cria um reader que vai atualizar o objeto existente
            Produto updatedProduct = objectMapper
                    .readerForUpdating(produto)
                    .readValue(prod);
            produtoRepository.save(produto);
            return updatedProduct;
        } catch (Exception e) {
            throw new RuntimeException("Falha ao atualizar produto", e);
        }
        // Atualiza EM CIMA do objeto existente
       // produtoMapper.updateProdutoFromDTO(prod, produto);


    }



    public List<Produto> searchFilters(String id,String name){
        if ((!id.isBlank()) && (!name.isBlank())) {
            return produtoRepository.findByIdAndNomeContainingIgnoreCase(id,name);
        } else if (id.isBlank()) {
            return produtoRepository.findByNomeContainingIgnoreCase(name);
        } else if (name.isBlank()) {
            return produtoRepository.findByIdContainingIgnoreCase(id);

        }else{
            return produtoRepository.findAll();
        }
    }


}
