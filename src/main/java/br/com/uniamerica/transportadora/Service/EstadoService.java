package br.com.uniamerica.transportadora.Service;

import br.com.uniamerica.transportadora.Entity.Estado;
import br.com.uniamerica.transportadora.Repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    @Transactional
    public Estado save(Estado estado) {
        return this.estadoRepository.save(estado);
    }

    public List<Estado> listAll() {
        return this.estadoRepository.findAll();
    }

    public List<Estado> findByEstadosAtivos() {
        return this.estadoRepository.findByEstadosAtivos();
    }

    public Estado findById(Long id) {
        return this.estadoRepository.findById(id).orElse(new Estado());
    }

    @Transactional
    public void update(Long id, Estado estado) {
        if(id == estado.getId()) {
            this.estadoRepository.save(estado);
        } else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void disable(Long id){
        var estado = this.estadoRepository.findById(id);
        if (id == estado.get().getId()) {
            this.estadoRepository.disable(id);
        }
        else {
            throw new RuntimeException();
        }
    }

}
