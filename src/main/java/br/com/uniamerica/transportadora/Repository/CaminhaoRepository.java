package br.com.uniamerica.transportadora.Repository;

import br.com.uniamerica.transportadora.Entity.Caminhao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaminhaoRepository extends JpaRepository<Caminhao, Long> {

    @Query("SELECT caminhao FROM Caminhao caminhao WHERE caminhao.ativo = true")
    public List<Caminhao> findByCaminhoesAtivos();

    @Modifying
    @Query("UPDATE Caminhao caminhao SET caminhao.ativo = false WHERE caminhao.id = :idCaminhao")
    public void disable(@Param("idCaminhao") Long id);
}
