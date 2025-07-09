package br.com.dio.catalogoprodutos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class ProdutoRequest {
    @NotBlank
    private String nome;

    private String descricao;

    @NotNull
    private BigDecimal preco;

}