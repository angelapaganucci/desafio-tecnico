package br.com.dio.simularpedidos.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ItemPedidoDTO {

    public static final String ERRO_ID_OBRIGATORIO = "O id do produto é obrigatório.";
    public static final String ERRO_QUANTIDADE_OBRIGATORIA = "A quantidade é obrigatória.";
    public static final String ERRO_QUANTIDADE = "A quantidade deve ser maior que zero.";

    @NotNull(message = ERRO_ID_OBRIGATORIO)
    private Long idProduto;

    @NotNull(message = ERRO_QUANTIDADE_OBRIGATORIA)
    @Positive(message = ERRO_QUANTIDADE)
    private Integer quantidade;

}
