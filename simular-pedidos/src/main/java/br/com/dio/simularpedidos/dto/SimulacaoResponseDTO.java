package br.com.dio.simularpedidos.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class SimulacaoResponseDTO {

    private Long idProduto;
    private String nomeProduto;
    private String descricaoProduto;
    private BigDecimal precoUnitario;
    private Integer quantidade;
    private BigDecimal precoTotal;
}
