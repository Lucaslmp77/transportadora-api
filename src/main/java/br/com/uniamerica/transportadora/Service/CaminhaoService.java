package br.com.uniamerica.transportadora.Service;

import br.com.uniamerica.transportadora.Entity.Caminhao;
import br.com.uniamerica.transportadora.Repository.CaminhaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CaminhaoService {

    @Autowired
    private CaminhaoRepository caminhaoRepository;

    @Transactional
    public Caminhao save(Caminhao caminhao) {
        return this.caminhaoRepository.save(caminhao);
    }

    public List<Caminhao> listAll() {
        return this.caminhaoRepository.findAll();
    }

    public Caminhao findById(Long id) {
        return this.caminhaoRepository.findById(id).orElse(new Caminhao());
    }

    @Transactional
    public void update(Long id, Caminhao caminhao) {
        if(id == caminhao.getId()) {
            this.caminhaoRepository.save(caminhao);
        } else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void delete(Long id, Caminhao caminhao) {
        if(id == caminhao.getId()) {
            this.caminhaoRepository.delete(caminhao);
        } else {
            throw new RuntimeException();
        }
    }

}
