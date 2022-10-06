package br.com.uniamerica.transportadora.Repository;

import br.com.uniamerica.transportadora.Entity.Caminhao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaminhaoRepository extends JpaRepository<Caminhao, Long> {


}
