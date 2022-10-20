package br.com.uniamerica.transportadora.Controller;

import br.com.uniamerica.transportadora.Service.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/modelo")
public class ModeloController {

    @Autowired
    private ModeloService modeloService;

}
