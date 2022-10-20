package br.com.uniamerica.transportadora.Controller;

import br.com.uniamerica.transportadora.Service.TipoDespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/tipo-despesa")
public class TipoDespesaController {

    @Autowired
    private TipoDespesaService tipoDespesaService;

}
