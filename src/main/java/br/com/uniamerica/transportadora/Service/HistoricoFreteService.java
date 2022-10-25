package br.com.uniamerica.transportadora.Service;

import br.com.uniamerica.transportadora.Entity.HistoricoFrete;
import br.com.uniamerica.transportadora.Repository.HistoricoFreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class HistoricoFreteService {

    @Autowired
    private HistoricoFreteRepository historicoFreteRepository;

    @Transactional
    public HistoricoFrete save(HistoricoFrete historicoFrete) {
        return this.historicoFreteRepository.save(historicoFrete);
    }

    public List<HistoricoFrete> listAll() {
        return this.historicoFreteRepository.findAll();
    }

    public Optional<HistoricoFrete> findById(Long id) {
        return this.historicoFreteRepository.findById(id);
    }

    @Transactional
    public void update(Long id, HistoricoFrete historicoFrete) {
        if(id == historicoFrete.getId()) {
            this.historicoFreteRepository.save(historicoFrete);
        } else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void delete(Long id) {
        var historicoFrete = this.historicoFreteRepository.findById(id);
        if(id == historicoFrete.get().getId()) {
            this.historicoFreteRepository.delete(historicoFrete.get());
        } else {
            throw new RuntimeException();
        }
    }

}
