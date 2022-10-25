package br.com.uniamerica.transportadora.Service;

import br.com.uniamerica.transportadora.Entity.Cidade;
import br.com.uniamerica.transportadora.Repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Transactional
    public Cidade save(Cidade cidade) {
        return this.cidadeRepository.save(cidade);
    }

    public List<Cidade> listAll() {
        return this.cidadeRepository.findAll();
    }

    public Optional<Cidade> findById(Long id) {
        return this.cidadeRepository.findById(id);
    }

    @Transactional
    public void update(Long id, Cidade cidade) {
        if(id == cidade.getId()) {
            this.cidadeRepository.save(cidade);
        } else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void delete(Long id) {
        var cidade = this.cidadeRepository.findById(id);
        if(id == cidade.get().getId()) {
            this.cidadeRepository.delete(cidade.get());
        } else {
            throw new RuntimeException();
        }
    }

}
