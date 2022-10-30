package br.com.uniamerica.transportadora.Service;

import br.com.uniamerica.transportadora.Entity.*;
import br.com.uniamerica.transportadora.Repository.HistoricoFreteRepository;
import br.com.uniamerica.transportadora.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class HistoricoFreteService {

    @Autowired
    private HistoricoFreteRepository historicoFreteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public HistoricoFrete save(HistoricoFrete historicoFrete) {
        return this.historicoFreteRepository.save(historicoFrete);
    }

    public List<HistoricoFrete> listAll() {
        return this.historicoFreteRepository.findAll();
    }

    public HistoricoFrete findById(Long id) {
        return this.historicoFreteRepository.findById(id).orElse(new HistoricoFrete());
    }

    public List<HistoricoFrete> findByFrete(Long id) {
        return this.historicoFreteRepository.findByFrete(id);
    }

    @Transactional
    public void cadastrar(Frete frete, StatusFrete statusFrete) {

        final Usuario usuario = this.usuarioRepository.findById(1L).orElse(null);

        final HistoricoFrete historicoFrete = new HistoricoFrete();
        historicoFrete.setStatusFrete(statusFrete);
        historicoFrete.setData(LocalDateTime.now());
        historicoFrete.setFrete(frete);
        historicoFrete.setExecutor(usuario);

        this.historicoFreteRepository.save(historicoFrete);
    }


}
