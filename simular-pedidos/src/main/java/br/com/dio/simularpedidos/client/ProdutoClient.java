package br.com.dio.simularpedidos.client;

import br.com.dio.catalogoprodutos.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
public class ProdutoClient {

    private final WebClient webClient;

    @Autowired
    public ProdutoClient(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("http://catalogo-produtos").build();
    }

    public List<Produto> listarProdutos() {
        return webClient.get()
                .uri("/produtos")
                .retrieve()
                .bodyToFlux(Produto.class)
                .collectList()
                .block();
    }
}
