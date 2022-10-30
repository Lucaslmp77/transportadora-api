package br.com.uniamerica.transportadora.Service;

import br.com.uniamerica.transportadora.Entity.Despesa;
import br.com.uniamerica.transportadora.Entity.Frete;
import br.com.uniamerica.transportadora.Entity.StatusFrete;
import br.com.uniamerica.transportadora.Repository.DespesaRepository;
import br.com.uniamerica.transportadora.Repository.FreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FreteService {
    
    @Autowired
    private FreteRepository freteRepository;

    @Autowired
    private DespesaRepository despesaRepository;

    @Autowired
    private HistoricoFreteService historicoFreteService;

    @Transactional
    public Frete save(Frete frete) {
        frete.setStatusFrete(StatusFrete.CARGA);
        return this.freteRepository.save(frete);
    }

    public List<Frete> listAll() {
        return this.freteRepository.findAll();
    }

    public Frete findById(Long id) {
        return this.freteRepository.findById(id).orElse(new Frete());
    }

    @Transactional
    public void update(Long id, Frete frete) {
        if(id == frete.getId()) {
            validatiosUpdate(frete);
            this.freteRepository.save(frete);
        } else {
            throw new RuntimeException();
        }
    }

    public void validatiosUpdate(Frete frete) {
        Assert.isTrue(validateStatusFreteEmTransporte(frete), "erro, o estatus de frete nao e CARGA");
        Assert.isTrue(validateStatusFreteInterrompido(frete), "erro, o estatus de frete nao e EM_TRANSPORTE");
        Assert.isTrue(validateStatusFreteInterrompidoParaTransporte(frete), "erro, o status de frete nao e " +
                "INTERROMPIDO");
        Assert.isTrue(validateStatusFreteEmTransporteParaDescarga(frete), "erro, o status de frete nao e " +
                "EM_TRANSPORTE");
        Assert.isTrue(validateStatusFreteinterrompidoOuCarga(frete), "erro, o status de frete nao e " +
                "INTERROMPIDO ou EM_CARGA");
    }

    public boolean validateStatusFreteEmTransporte(Frete frete) {
        if (frete.getStatusFrete().equals(StatusFrete.CARGA)) {
            frete.setStatusFrete(StatusFrete.EM_TRANSPORTE);
            return true;
        } else {
            return false;
        }
    }

    public boolean validateStatusFreteInterrompido(Frete frete) {
        if (frete.getStatusFrete().equals(StatusFrete.EM_TRANSPORTE)) {
            frete.setStatusFrete(StatusFrete.INTERROMPIDO);
            return true;
        } else {
            return false;
        }
    }

    public boolean validateStatusFreteInterrompidoParaTransporte(Frete frete) {
        if (frete.getStatusFrete().equals(StatusFrete.INTERROMPIDO)) {
            frete.setStatusFrete(StatusFrete.EM_TRANSPORTE);
            return true;
        } else {
            return false;
        }
    }

    public boolean validateStatusFreteEmTransporteParaDescarga(Frete frete) {
        if (frete.getStatusFrete().equals(StatusFrete.EM_TRANSPORTE)) {
            frete.setStatusFrete(StatusFrete.DESCARGA);
            return true;
        } else {
            return false;
        }
    }

    public boolean validateStatusFreteinterrompidoOuCarga(Frete frete) {
        if (frete.getStatusFrete().equals(StatusFrete.INTERROMPIDO) || frete.getStatusFrete().equals(StatusFrete.CARGA)) {
            frete.setStatusFrete(StatusFrete.CANCELADO);
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public void atualizarStatusFaturado(final Long idFrete) {

        final Frete frete = this.freteRepository.findById(idFrete).orElse(new Frete());

        Assert.isTrue(frete != null, "Não foi possível localizar o frete informado");

        Assert.isTrue(!frete.getStatusFrete().equals(StatusFrete.DESCARGA),
                "Não é possível faturar um frete que não está com o sucesso de descarte");

        final List<Despesa> despesa = this.despesaRepository.findByFreteAndAprovadorIsNull(frete.getId());

        Assert.isTrue(despesa.size() == 0,
                "Não é possível faturar um frete com despesas abertas");

        frete.setStatusFrete(StatusFrete.FATURADO);
        this.freteRepository.save(frete);

        this.historicoFreteService.cadastrar(frete, StatusFrete.FATURADO);
    }

    @Transactional
    public void atualizarStatusEmTransporte(final Long idFrete) {

        final Frete frete = this.freteRepository.findById(idFrete).orElse(null);

        Assert.isTrue(frete != null, "Não foi possível localizar o frete informado");

        Assert.isTrue(!frete.getStatusFrete().equals(StatusFrete.INTERROMPIDO),
                "Não é possível iniciar o transporte do frete, pois seu status é diferente de interrompido");

        frete.setStatusFrete(StatusFrete.EM_TRANSPORTE);
        this.freteRepository.save(frete);

        this.historicoFreteService.cadastrar(frete, StatusFrete.EM_TRANSPORTE);
    }

}
