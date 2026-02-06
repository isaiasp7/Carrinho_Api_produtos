package io.github.isaiasp7.productsApi.Models;

import com.fasterxml.jackson.annotation.JsonCreator;
import io.github.isaiasp7.productsApi.DTO.ProdDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Produto {
	@Id
    private String id;
    private String nome;
    private String descricao;
    private Double preco;

    public Produto() {

    }
    public Produto(String id, ProdDTO prod) {
        this.id = id;
        this.nome = prod.getNome();
        this.descricao = prod.getDescricao();
        this.preco = prod.getPreco();

    }

    public Produto(Produto prod) {
        this.id = prod.getId();
        this.nome = prod.getNome();
        this.descricao = prod.getDescricao();
        this.preco = prod.getPreco();

    }



    @Override
    public String toString() {
    	
        return "Produto{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                '}';
    }
}
