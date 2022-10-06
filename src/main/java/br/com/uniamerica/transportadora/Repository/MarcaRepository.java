package br.com.uniamerica.transportadora.Repository;

import br.com.uniamerica.transportadora.Entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {
}
