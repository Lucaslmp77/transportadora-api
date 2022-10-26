package br.com.uniamerica.transportadora.Service;

import br.com.uniamerica.transportadora.Entity.Frete;
import br.com.uniamerica.transportadora.Repository.FreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class FreteService {
    
    @Autowired
    private FreteRepository freteRepository;

    @Transactional
    public Frete save(Frete frete) {
        return this.freteRepository.save(frete);
    }

    public List<Frete> listAll() {
        return this.freteRepository.findAll();
    }

    public Frete findById(Long id) {
        return this.freteRepository.findById(id).orElse(new Frete());
    }

    @Transactional
    public void update(Long id, Frete frete) {
        if(id == frete.getId()) {
            this.freteRepository.save(frete);
        } else {
            throw new RuntimeException();
        }
    }

}
