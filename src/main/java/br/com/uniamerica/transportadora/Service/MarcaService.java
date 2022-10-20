package br.com.uniamerica.transportadora.Service;

import br.com.uniamerica.transportadora.Repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

}
