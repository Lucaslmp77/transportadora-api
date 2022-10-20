package br.com.uniamerica.transportadora.Service;

import br.com.uniamerica.transportadora.Repository.HistoricoFreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoricoFreteService {

    @Autowired
    private HistoricoFreteRepository historicoFreteRepository;

}
