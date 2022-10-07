package br.com.uniamerica.transportadora.Service;

import br.com.uniamerica.transportadora.Entity.Caminhao;
import br.com.uniamerica.transportadora.Repository.CaminhaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaminhaoService {

    @Autowired
    private CaminhaoRepository caminhaoRepository;

    public List<Optional<Caminhao>> findByAtivo(){
        return this.caminhaoRepository.findByAtivo();
    }
}
