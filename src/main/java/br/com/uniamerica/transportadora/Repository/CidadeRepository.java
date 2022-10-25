package br.com.uniamerica.transportadora.Repository;

import br.com.uniamerica.transportadora.Entity.Cidade;
import br.com.uniamerica.transportadora.Entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    @Query("SELECT cid FROM Cidade cid WHERE cid.ativo = true")
    List<Optional<Cidade>> findByAtivo();

    @Query("SELECT est FROM Estado est WHERE est.estado = :estado")
    List<Optional<Estado>> findByEstado(Estado estado);


}
