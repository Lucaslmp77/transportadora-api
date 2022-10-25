package br.com.uniamerica.transportadora.Repository;

import br.com.uniamerica.transportadora.Entity.Caminhao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CaminhaoRepository extends JpaRepository<Caminhao, Long> {

    @Query("SELECT cam FROM Caminhao cam WHERE cam.ativo = true")
    List<Optional<Caminhao>> findByAtivo();
}
