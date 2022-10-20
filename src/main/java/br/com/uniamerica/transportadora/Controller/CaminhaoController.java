package br.com.uniamerica.transportadora.Controller;

import br.com.uniamerica.transportadora.Service.CaminhaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/caminhao")
public class CaminhaoController {

    @Autowired
    private CaminhaoService caminhaoService;

}
