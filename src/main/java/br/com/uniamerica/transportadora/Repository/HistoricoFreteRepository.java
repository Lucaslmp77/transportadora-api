package br.com.uniamerica.transportadora.Repository;

import br.com.uniamerica.transportadora.Entity.HistoricoFrete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoFreteRepository extends JpaRepository<HistoricoFrete, Long> {
}
