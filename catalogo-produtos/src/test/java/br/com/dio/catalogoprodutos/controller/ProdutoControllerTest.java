package br.com.dio.catalogoprodutos.controller;

import br.com.dio.catalogoprodutos.dto.ProdutoRequest;
import br.com.dio.catalogoprodutos.dto.ProdutoResponse;
import br.com.dio.catalogoprodutos.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProdutoControllerTest {

    @InjectMocks
    private ProdutoController produtoController;

    @Mock
    private ProdutoService produtoService;

    @Test
    void deveCriarProduto() {
        ProdutoRequest produtoRequest = ProdutoRequest.builder()
                .nome("Produto Teste")
                .descricao("Descrição do Produto Teste")
                .preco(BigDecimal.valueOf(100.0))
                .build();
        when(produtoService.salvar(produtoRequest)).thenReturn(ProdutoResponse.builder().build());

        ResponseEntity<ProdutoResponse> result = produtoController.criarProduto(produtoRequest);

        assertNotNull(result);
    }

    @Test
    void deveListarProdutos() {
        when(produtoService.listarTodos()).thenReturn(List.of(ProdutoResponse.builder().build()));

        ResponseEntity<List<ProdutoResponse>> result = produtoController.listar();

        assertNotNull(result);
        assertNotNull(result.getBody());
    }

    @Test
    void deveBuscarProdutoPorId() {
        Long id = 1L;
        when(produtoService.buscarPorId(id)).thenReturn(java.util.Optional.of(ProdutoResponse.builder().build()));

        ResponseEntity<ProdutoResponse> result = produtoController.buscar(id);

        assertNotNull(result);
        assertNotNull(result.getBody());
    }

    @Test
    void deveAtualizarProduto() {
        Long id = 1L;
        ProdutoRequest produtoRequest = ProdutoRequest.builder()
                .nome("Produto Atualizado")
                .descricao("Descrição do Produto Atualizado")
                .preco(BigDecimal.valueOf(150.0))
                .build();
        when(produtoService.atualizar(id, produtoRequest)).thenReturn(ProdutoResponse.builder().build());

        ResponseEntity<ProdutoResponse> result = produtoController.atualizar(id, produtoRequest);

        assertNotNull(result);
        assertNotNull(result.getBody());
    }

    @Test
    void deveDeletarProduto() {
        Long id = 1L;

        ResponseEntity<Void> result = produtoController.deletar(id);

        assertNotNull(result);
        assertNotNull(result.getStatusCode());
    }

}