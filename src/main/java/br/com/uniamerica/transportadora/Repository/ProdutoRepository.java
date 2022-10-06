package br.com.uniamerica.transportadora.Repository;

import br.com.uniamerica.transportadora.Entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
