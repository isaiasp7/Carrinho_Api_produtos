package io.github.isaiasp7.productsApi.Exceptions;


public class ProdutoNaoEncontrado extends RuntimeException {
    public ProdutoNaoEncontrado(String message) {
        super(message);
    }
}
