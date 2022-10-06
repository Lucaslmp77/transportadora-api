package br.com.uniamerica.transportadora.Repository;

import br.com.uniamerica.transportadora.Entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
