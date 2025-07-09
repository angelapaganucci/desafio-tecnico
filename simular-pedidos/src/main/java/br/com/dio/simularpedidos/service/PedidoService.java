package br.com.dio.simularpedidos.service;

import br.com.dio.catalogoprodutos.model.Produto;
import br.com.dio.simularpedidos.client.ProdutoClient;
import br.com.dio.simularpedidos.dto.ItemPedidoDTO;
import br.com.dio.simularpedidos.dto.PedidoDTO;
import br.com.dio.simularpedidos.dto.SimulacaoResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final ProdutoClient produtoClient;

    public List<SimulacaoResponseDTO> simularPedido(PedidoDTO pedidoDTO) {
        List<Produto> produtos = produtoClient.listarProdutos();

        Map<Long, Integer> mapaQuantidade = pedidoDTO.getItens().stream()
                .collect(Collectors.toMap(ItemPedidoDTO::getIdProduto, ItemPedidoDTO::getQuantidade));

        return produtos.stream()
                .filter(p -> mapaQuantidade.containsKey(p.getId()))
                .map(produto -> mapToSimulacaoResponseDTO(produto, mapaQuantidade.get(produto.getId())))
                .collect(Collectors.toList());
    }


    private SimulacaoResponseDTO mapToSimulacaoResponseDTO(Produto produto, int quantidade) {
        return SimulacaoResponseDTO.builder()
                .idProduto(produto.getId())
                .nomeProduto(produto.getNome())
                .descricaoProduto(produto.getDescricao())
                .precoUnitario(produto.getPreco())
                .quantidade(quantidade)
                .precoTotal(produto.getPreco().multiply(BigDecimal.valueOf(quantidade)))
                .build();
    }

}
