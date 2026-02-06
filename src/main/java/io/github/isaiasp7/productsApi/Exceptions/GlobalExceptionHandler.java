package io.github.isaiasp7.productsApi.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ProdutoNaoEncontrado.class)
  public ResponseEntity<String> handleProdutoNaoEncontrado(
          ProdutoNaoEncontrado ex) {

    return ResponseEntity
            .status(HttpStatus.OK)
            .body(ex.getMessage());
  }
}