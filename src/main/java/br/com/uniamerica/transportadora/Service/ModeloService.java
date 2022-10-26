package br.com.uniamerica.transportadora.Service;

import br.com.uniamerica.transportadora.Entity.Modelo;
import br.com.uniamerica.transportadora.Repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ModeloService {

    @Autowired
    private ModeloRepository modeloRepository;

    @Transactional
    public Modelo save(Modelo modelo) {
        return this.modeloRepository.save(modelo);
    }

    public List<Modelo> listAll() {
        return this.modeloRepository.findAll();
    }

    public Optional<Modelo> findById(Long id) {
        return this.modeloRepository.findById(id);
    }

    @Transactional
    public void update(Long id, Modelo modelo) {
        if(id == modelo.getId()) {
            this.modeloRepository.save(modelo);
        } else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void delete(Long id, Modelo modelo) {
        if(id == modelo.getId()) {
            this.modeloRepository.delete(modelo);
        } else {
            throw new RuntimeException();
        }
    }

}
