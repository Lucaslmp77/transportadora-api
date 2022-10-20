package br.com.uniamerica.transportadora.Service;

import br.com.uniamerica.transportadora.Repository.CaminhaoRepository;
import br.com.uniamerica.transportadora.Repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

}
