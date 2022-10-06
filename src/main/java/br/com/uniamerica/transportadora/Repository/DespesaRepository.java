package br.com.uniamerica.transportadora.Repository;

import br.com.uniamerica.transportadora.Entity.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Long> {
}
