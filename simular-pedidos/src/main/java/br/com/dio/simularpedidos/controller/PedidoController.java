package br.com.dio.simularpedidos.controller;

import br.com.dio.simularpedidos.dto.PedidoDTO;
import br.com.dio.simularpedidos.dto.SimulacaoResponseDTO;
import br.com.dio.simularpedidos.service.PedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService service;

    @PostMapping("/simular")
    public ResponseEntity<List<SimulacaoResponseDTO>> simularPedido(@Valid @RequestBody PedidoDTO pedidoDTO) {
        List<SimulacaoResponseDTO> simulacoes = service.simularPedido(pedidoDTO);
        return ResponseEntity.ok(simulacoes);
    }
}
