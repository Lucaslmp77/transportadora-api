package br.com.uniamerica.transportadora.Service;

import br.com.uniamerica.transportadora.Entity.Marca;
import br.com.uniamerica.transportadora.Repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    @Transactional
    public Marca save(Marca marca) {
        return this.marcaRepository.save(marca);
    }

    public List<Marca> listAll() {
        return this.marcaRepository.findAll();
    }

    public Optional<Marca> findById(Long id) {
        return this.marcaRepository.findById(id);
    }

    @Transactional
    public void update(Long id, Marca marca) {
        if(id == marca.getId()) {
            this.marcaRepository.save(marca);
        } else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void delete(Long id) {
        var marca = this.marcaRepository.findById(id);
        if(id == marca.get().getId()) {
            this.marcaRepository.delete(marca.get());
        } else {
            throw new RuntimeException();
        }
    }

}
