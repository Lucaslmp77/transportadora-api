package br.com.uniamerica.transportadora.Service;

import br.com.uniamerica.transportadora.Entity.Cidade;
import br.com.uniamerica.transportadora.Repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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

    public Cidade findById(Long id) {
        return this.cidadeRepository.findById(id).orElse(new Cidade());
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
    public void disable(Long id){
        var cidade = this.cidadeRepository.findById(id);
        if (id == cidade.get().getId()) {
            this.cidadeRepository.disable(id);
        }
        else {
            throw new RuntimeException();
        }
    }

    public List<Cidade> findByEstado(Long id) {
        return this.cidadeRepository.findByEstado(id);
    }

}
