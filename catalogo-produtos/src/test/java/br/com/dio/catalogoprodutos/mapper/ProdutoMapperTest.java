package br.com.dio.catalogoprodutos.mapper;

import br.com.dio.catalogoprodutos.dto.ProdutoRequest;
import br.com.dio.catalogoprodutos.model.Produto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class ProdutoMapperTest {

    @InjectMocks
    private ProdutoMapper produtoMapper;

    @Test
    void deveConverterProdutoRequestParaProduto() {
        ProdutoRequest request = ProdutoRequest.builder()
                .nome("Produto A")
                .descricao("Descrição do Produto A")
                .preco(BigDecimal.valueOf(100.0))
                .build();

        Produto produto = produtoMapper.toEntity(request);

        assertNotNull(produto);
        assertEquals("Produto A", produto.getNome());
        assertEquals("Descrição do Produto A", produto.getDescricao());
        assertEquals(BigDecimal.valueOf(100.0), produto.getPreco());
    }

    @Test
    void deveConverterProdutoParaProdutoResponse() {
        Produto produto = Produto.builder()
                .id(1L)
                .nome("Produto A")
                .descricao("Descrição do Produto A")
                .preco(BigDecimal.valueOf(100.0))
                .build();

        var response = produtoMapper.toResponse(produto);

        assertNotNull(response);
        assertEquals(1L, response.getId());
        assertEquals("Produto A", response.getNome());
        assertEquals("Descrição do Produto A", response.getDescricao());
        assertEquals(BigDecimal.valueOf(100.0), response.getPreco());
    }

}