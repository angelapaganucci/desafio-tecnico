package br.com.dio.catalogoprodutos.service;

import br.com.dio.catalogoprodutos.dto.ProdutoRequest;
import br.com.dio.catalogoprodutos.dto.ProdutoResponse;
import br.com.dio.catalogoprodutos.mapper.ProdutoMapper;
import br.com.dio.catalogoprodutos.model.Produto;
import br.com.dio.catalogoprodutos.repository.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProdutoServiceTest {

    @InjectMocks
    private ProdutoService produtoService;

    @Mock
    private ProdutoMapper produtoMapper;

    @Mock
    private ProdutoRepository produtoRepository;

    @Test
    void deveSalvarProduto() {
        ProdutoRequest produtoRequest = ProdutoRequest.builder()
                .nome("Produto Teste")
                .descricao("Descrição do Produto Teste")
                .preco(BigDecimal.valueOf(100.0))
                .build();

        when(produtoMapper.toEntity(produtoRequest)).thenReturn(null);
        when(produtoRepository.save(null)).thenReturn(null);
        when(produtoMapper.toResponse(null)).thenReturn(ProdutoResponse.builder().build());

        ProdutoResponse result = produtoService.salvar(produtoRequest);

        assertNotNull(result);
    }

    @Test
    void deveListarTodosProdutos() {
        when(produtoRepository.findAll()).thenReturn(List.of());

        List<ProdutoResponse> result = produtoService.listarTodos();

        assertNotNull(result);
    }

    @Test
    void deveBuscarProdutoPorId() {
        Long id = 1L;
        Produto produto = Produto.builder().build();
        when(produtoRepository.findById(id)).thenReturn(Optional.of(produto));
        when(produtoMapper.toResponse(produto)).thenReturn(ProdutoResponse.builder().id(1l).build());

        ProdutoResponse result = produtoService.buscarPorId(id).orElse(null);

        assertNotNull(result);
    }

    @Test
    void deveAtualizarProduto() {
        Long id = 1L;
        ProdutoRequest produtoRequest = ProdutoRequest.builder()
                .nome("Produto Atualizado")
                .descricao("Descrição Atualizada")
                .preco(BigDecimal.valueOf(150.0))
                .build();

        Produto produtoExistente = Produto.builder().id(id).build();
        when(produtoRepository.findById(id)).thenReturn(Optional.of(produtoExistente));
        when(produtoMapper.toResponse(produtoExistente)).thenReturn(ProdutoResponse.builder().id(id).build());
        when(produtoRepository.save(produtoExistente)).thenReturn(produtoExistente);

        ProdutoResponse result = produtoService.atualizar(id, produtoRequest);

        assertNotNull(result);
    }

    @Test
    void deveDeletarProduto() {
        Long id = 1L;
        Produto produtoExistente = Produto.builder().id(id).build();
        when(produtoRepository.findById(id)).thenReturn(Optional.of(produtoExistente));

        produtoService.deletar(id);

        verify(produtoRepository).delete(produtoExistente);
    }

}