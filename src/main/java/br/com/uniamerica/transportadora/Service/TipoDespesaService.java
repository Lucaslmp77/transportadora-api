package br.com.uniamerica.transportadora.Service;

import br.com.uniamerica.transportadora.Entity.TipoDespesa;
import br.com.uniamerica.transportadora.Repository.TipoDespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TipoDespesaService {

    @Autowired
    private TipoDespesaRepository tipoDespesaRepository;

    @Transactional
    public TipoDespesa save(TipoDespesa tipoDespesa) {
        return this.tipoDespesaRepository.save(tipoDespesa);
    }

    public List<TipoDespesa> listAll() {
        return this.tipoDespesaRepository.findAll();
    }

    public Optional<TipoDespesa> findById(Long id) {
        return this.tipoDespesaRepository.findById(id);
    }

    @Transactional
    public void update(Long id, TipoDespesa tipoDespesa) {
        if(id == tipoDespesa.getId()) {
            this.tipoDespesaRepository.save(tipoDespesa);
        } else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void delete(Long id, TipoDespesa tipoDespesa) {
        if(id == tipoDespesa.getId()) {
            this.tipoDespesaRepository.delete(tipoDespesa);
        } else {
            throw new RuntimeException();
        }
    }

}
