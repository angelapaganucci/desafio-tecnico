package br.com.dio.simularpedidos.service;

import br.com.dio.simularpedidos.client.ProdutoClient;
import br.com.dio.simularpedidos.dto.ItemPedidoDTO;
import br.com.dio.simularpedidos.dto.PedidoDTO;
import br.com.dio.simularpedidos.dto.SimulacaoResponseDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class PedidoServiceTest {

    @InjectMocks
    private PedidoService pedidoService;

    @Mock
    private ProdutoClient produtoClient;

    @Test
    void deveSimularPedidoComSucesso() {
        PedidoDTO pedidoDTO = new PedidoDTO();
        pedidoDTO.setItens(List.of(ItemPedidoDTO.builder()
                        .idProduto(1L)
                        .quantidade(2)
                        .build(),
                ItemPedidoDTO.builder()
                        .idProduto(2L)
                        .quantidade(3)
                        .build()));

        List<SimulacaoResponseDTO> result = pedidoService.simularPedido(pedidoDTO);

        assertNotNull(result);
    }

}