package br.com.uniamerica.transportadora.Service;

import br.com.uniamerica.transportadora.Repository.FreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FreteService {
    
    @Autowired
    private FreteRepository freteRepository;

}
