package br.com.vendexpress.catalog.repositories;

import br.com.vendexpress.catalog.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
}
