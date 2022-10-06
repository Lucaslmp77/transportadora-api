package br.com.uniamerica.transportadora.Repository;

import br.com.uniamerica.transportadora.Entity.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {
}
