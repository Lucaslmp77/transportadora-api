package br.com.uniamerica.transportadora.Controller;

import br.com.uniamerica.transportadora.Service.DespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/despesa")
public class DespesaController {

    @Autowired
    private DespesaService despesaService;

}
