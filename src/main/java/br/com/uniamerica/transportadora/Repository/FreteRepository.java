package br.com.uniamerica.transportadora.Repository;

import br.com.uniamerica.transportadora.Entity.Frete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreteRepository extends JpaRepository<Frete, Long> {
}
