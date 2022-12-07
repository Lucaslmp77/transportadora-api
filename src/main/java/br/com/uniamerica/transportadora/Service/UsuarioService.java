package br.com.uniamerica.transportadora.Service;

import br.com.uniamerica.transportadora.Entity.Usuario;
import br.com.uniamerica.transportadora.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario save(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }

    public List<Usuario> listAll() {
        return this.usuarioRepository.findAll();
    }

    public List<Usuario> findByMotoristasAtivos() {
        return this.usuarioRepository.findByMotoristasAtivos();
    }

    public Usuario findById(Long id) {
        return this.usuarioRepository.findById(id).orElse(new Usuario());
    }

    @Transactional
    public void update(Long id, Usuario usuario) {
        if(id == usuario.getId()) {
            this.usuarioRepository.save(usuario);
        } else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void disable(Long id){
        var usuario = this.usuarioRepository.findById(id);
        if (id == usuario.get().getId()) {
            this.usuarioRepository.disable(id);
        }
        else {
            throw new RuntimeException();
        }
    }

}
