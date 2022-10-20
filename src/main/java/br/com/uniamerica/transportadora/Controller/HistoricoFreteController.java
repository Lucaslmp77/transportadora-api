package br.com.uniamerica.transportadora.Controller;

import br.com.uniamerica.transportadora.Service.HistoricoFreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/historico-frete")
public class HistoricoFreteController {

    @Autowired
    private HistoricoFreteService historicoFreteService;

}
