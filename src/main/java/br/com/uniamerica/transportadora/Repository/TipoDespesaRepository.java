package br.com.uniamerica.transportadora.Repository;

import br.com.uniamerica.transportadora.Entity.Marca;
import br.com.uniamerica.transportadora.Entity.TipoDespesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TipoDespesaRepository extends JpaRepository<TipoDespesa, Long> {

    @Query("SELECT tpd FROM TipoDespesa tpd WHERE tpd.ativo = true")
    List<Optional<TipoDespesa>> findByAtivo();

}
