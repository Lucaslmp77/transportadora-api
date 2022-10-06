package br.com.uniamerica.transportadora.Repository;

import br.com.uniamerica.transportadora.Entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
}
