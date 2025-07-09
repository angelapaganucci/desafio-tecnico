package br.com.dio.catalogoprodutos.repository;

import br.com.dio.catalogoprodutos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
