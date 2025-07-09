package br.com.dio.simularpedidos.controller;

import br.com.dio.simularpedidos.dto.PedidoDTO;
import br.com.dio.simularpedidos.dto.SimulacaoResponseDTO;
import br.com.dio.simularpedidos.service.PedidoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PedidoControllerTest {

    @InjectMocks
    private PedidoController pedidoController;

    @Mock
    private PedidoService pedidoService;

    @Test
    void deveSimularPedido() {
        when(pedidoService.simularPedido(any(PedidoDTO.class)))
                .thenReturn(List.of(SimulacaoResponseDTO.builder().build()));

        ResponseEntity<List<SimulacaoResponseDTO>> result = pedidoController.simularPedido(new PedidoDTO());

        assertNotNull(result);
    }

}