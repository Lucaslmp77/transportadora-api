package br.com.uniamerica.transportadora.Repository;

import br.com.uniamerica.transportadora.Entity.Produto;
import br.com.uniamerica.transportadora.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Modifying
    @Query("UPDATE Usuario usuario SET usuario.ativo = false WHERE usuario.id = :idUsuario")
    public void disable(@Param("idUsuario") Long id);

    @Query("SELECT usuario FROM Usuario usuario WHERE usuario.ativo = true and usuario.grupo = 'MOTORISTA'")
    public List<Usuario> findByMotoristasAtivos();

}
