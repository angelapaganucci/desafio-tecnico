package br.com.dio.catalogoprodutos.exception;

public class ProdutoNotFoundException extends RuntimeException {
    public ProdutoNotFoundException(Long id) {
        super("Produto com ID " + id + " não encontrado.");
    }
}
