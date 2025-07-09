package br.com.dio.catalogoprodutos.service;

import br.com.dio.catalogoprodutos.dto.ProdutoRequest;
import br.com.dio.catalogoprodutos.dto.ProdutoResponse;
import br.com.dio.catalogoprodutos.exception.ProdutoNotFoundException;
import br.com.dio.catalogoprodutos.mapper.ProdutoMapper;
import br.com.dio.catalogoprodutos.model.Produto;
import br.com.dio.catalogoprodutos.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;
    private final ProdutoMapper mapper;

    public ProdutoResponse salvar(ProdutoRequest request) {
        Produto produto = mapper.toEntity(request);
        Produto salvo = repository.save(produto);
        return mapper.toResponse(salvo);
    }

    public List<ProdutoResponse> listarTodos() {
        return repository.findAll().stream()
                .map(mapper::toResponse)
                .toList();
    }

    public Optional<ProdutoResponse> buscarPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toResponse);
    }

    public ProdutoResponse atualizar(Long id, ProdutoRequest request) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new ProdutoNotFoundException(id));

        produto.setNome(request.getNome());
        produto.setDescricao(request.getDescricao());
        produto.setPreco(request.getPreco());

        return mapper.toResponse(repository.save(produto));
    }

    public void deletar(Long id) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new ProdutoNotFoundException(id));

        repository.delete(produto);
    }
}