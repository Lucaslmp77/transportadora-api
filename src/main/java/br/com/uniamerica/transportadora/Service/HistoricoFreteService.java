package br.com.uniamerica.transportadora.Service;

import br.com.uniamerica.transportadora.Entity.HistoricoFrete;
import br.com.uniamerica.transportadora.Repository.HistoricoFreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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

    public HistoricoFrete findById(Long id) {
        return this.historicoFreteRepository.findById(id).orElse(new HistoricoFrete());
    }


}
