package br.com.uniamerica.transportadora.Repository;

import br.com.uniamerica.transportadora.Entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

    @Query("SELECT est FROM Estado est WHERE est.ativo = true")
    List<Optional<Estado>> findByAtivo();
}
