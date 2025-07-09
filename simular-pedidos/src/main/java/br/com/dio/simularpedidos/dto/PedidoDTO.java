package br.com.dio.simularpedidos.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PedidoDTO {

    public static final String ERRO_LISTA_VAZIA = "A lista de itens do pedido não pode estar vazia.";

    @NotEmpty(message = ERRO_LISTA_VAZIA)
    private List<ItemPedidoDTO> itens;

    private String observacao;

}
