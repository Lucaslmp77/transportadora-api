package br.com.uniamerica.transportadora.Repository;

import br.com.uniamerica.transportadora.Entity.TipoDespesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDespesaRepository extends JpaRepository<TipoDespesa, Long> {
}
