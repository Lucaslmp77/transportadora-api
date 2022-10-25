package br.com.uniamerica.transportadora.Service;

import br.com.uniamerica.transportadora.Entity.Despesa;
import br.com.uniamerica.transportadora.Repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class DespesaService {

    @Autowired
    private DespesaRepository despesaRepository;

    @Transactional
    public Despesa save(Despesa despesa) {
        return this.despesaRepository.save(despesa);
    }

    public List<Despesa> listAll() {
        return this.despesaRepository.findAll();
    }

    public Optional<Despesa> findById(Long id) {
        return this.despesaRepository.findById(id);
    }

    @Transactional
    public void update(Long id, Despesa despesa) {
        if(id == despesa.getId()) {
            this.despesaRepository.save(despesa);
        } else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void delete(Long id) {
        var despesa = this.despesaRepository.findById(id);
        if(id == despesa.get().getId()) {
            this.despesaRepository.delete(despesa.get());
        } else {
            throw new RuntimeException();
        }
    }

}
