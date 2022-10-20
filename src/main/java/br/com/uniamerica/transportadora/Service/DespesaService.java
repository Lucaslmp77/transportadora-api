package br.com.uniamerica.transportadora.Service;

import br.com.uniamerica.transportadora.Repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DespesaService {

    @Autowired
    private DespesaRepository despesaRepository;

}
