package br.com.uniamerica.transportadora.Controller;

import br.com.uniamerica.transportadora.Service.FreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/frete")
public class FreteController {

    @Autowired
    private FreteService freteService;

}