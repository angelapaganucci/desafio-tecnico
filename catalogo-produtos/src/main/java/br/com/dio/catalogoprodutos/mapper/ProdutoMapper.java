package br.com.dio.catalogoprodutos.mapper;

import br.com.dio.catalogoprodutos.dto.ProdutoRequest;
import br.com.dio.catalogoprodutos.dto.ProdutoResponse;
import br.com.dio.catalogoprodutos.model.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    public Produto toEntity(ProdutoRequest dto) {
        return Produto.builder()
                .nome(dto.getNome())
                .descricao(dto.getDescricao())
                .preco(dto.getPreco())
                .build();
    }

    public ProdutoResponse toResponse(Produto entity) {
        return ProdutoResponse.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .descricao(entity.getDescricao())
                .preco(entity.getPreco())
                .build();
    }
}
