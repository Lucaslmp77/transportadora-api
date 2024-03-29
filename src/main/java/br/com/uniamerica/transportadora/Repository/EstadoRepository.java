package br.com.uniamerica.transportadora.Repository;

import br.com.uniamerica.transportadora.Entity.Estado;
import br.com.uniamerica.transportadora.Entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

    @Query("SELECT estado FROM Estado estado WHERE estado.ativo = true")
    public List<Estado> findByEstadosAtivos();

    @Modifying
    @Query("UPDATE Estado estado SET estado.ativo = false WHERE estado.id = :idEstado")
    public void disable(@Param("idEstado") Long id);
}
