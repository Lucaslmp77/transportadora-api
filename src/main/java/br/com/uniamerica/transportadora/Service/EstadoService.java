package br.com.uniamerica.transportadora.Service;

import br.com.uniamerica.transportadora.Entity.Estado;
import br.com.uniamerica.transportadora.Repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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

    public Optional<Estado> findById(Long id) {
        return this.estadoRepository.findById(id);
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
    public void delete(Long id) {
        var estado = this.estadoRepository.findById(id);
        if(id == estado.get().getId()) {
            this.estadoRepository.delete(estado.get());
        } else {
            throw new RuntimeException();
        }
    }

}
