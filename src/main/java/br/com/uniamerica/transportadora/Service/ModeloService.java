package br.com.uniamerica.transportadora.Service;

import br.com.uniamerica.transportadora.Repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModeloService {

    @Autowired
    private ModeloRepository modeloRepository;

}
