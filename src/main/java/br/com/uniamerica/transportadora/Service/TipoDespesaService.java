package br.com.uniamerica.transportadora.Service;

import br.com.uniamerica.transportadora.Repository.TipoDespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoDespesaService {

    @Autowired
    private TipoDespesaRepository tipoDespesaRepository;

}
