package io.github.isaiasp7.productsApi.DTO;

import io.github.isaiasp7.productsApi.Models.Produto;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class ProdDTO {
    private String nome;
    private String descricao;
    private Double preco;

    /*public ProdDTO(Produto prod) {
        nome = prod.getNome();
        this.descricao = prod.getDescricao();
        preco = prod.getPreco();
    }*/
    /*public Produto ProdDTOtoProd(String id, ProdDTO prod) {
        return new Produto();
    }*/
}
