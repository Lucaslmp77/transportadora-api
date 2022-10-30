package br.com.uniamerica.transportadora.Service;

import br.com.uniamerica.transportadora.Entity.Despesa;
import br.com.uniamerica.transportadora.Entity.Frete;
import br.com.uniamerica.transportadora.Entity.StatusFrete;
import br.com.uniamerica.transportadora.Repository.DespesaRepository;
import br.com.uniamerica.transportadora.Repository.FreteRepository;
import net.bytebuddy.implementation.bytecode.Throw;
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
            this.freteRepository.save(frete);
        } else {
            throw new RuntimeException();
        }
    }

    public boolean checkCamposFreteIsNull(Frete frete) {
        if (frete.getId() == null && frete.getStatusFrete() == null && frete.getCaminhao() == null
                && frete.getProduto() == null && frete.getMotorista() == null && frete.getCidadeOrigem() == null
                && frete.getCidadeDestino() == null && frete.getDataInicio() == null && frete.getDataFim() == null
                && frete.getQuilometragemIni() == null && frete.getQuilometragemFim() == null
                && frete.getTotalBrutoRecebidoNota() == null && frete.getTotalLiquidoRecebido() == null
                && frete.getPrecoTonelada() == null && frete.getPesoInicial() == null && frete.getPesoFinal() == null
                && frete.getPesoFinalTransportado() == null) {
            return false;
        }else {
            return true;
        }
    }

    @Transactional
    public void postarFrete(final Long idFrete) {

        final Frete frete = this.freteRepository.findById(idFrete).orElse(null);

        Assert.isTrue(frete != null, "Não foi possível localizar o frete informado.");

        Assert.isTrue(checkCamposFreteIsNull(frete), "Erro, algum campo do frete é nulo");

        frete.setStatusFrete(StatusFrete.CARGA);
        this.freteRepository.save(frete);

        this.historicoFreteService.cadastrar(frete, StatusFrete.CARGA);
    }

    @Transactional
    public void atualizarStatusCargaParaEmTransporte(final Long idFrete) {

        final Frete frete = this.freteRepository.findById(idFrete).orElse(null);

        Assert.isTrue(frete != null, "Não foi possível localizar o frete informado.");

        Assert.isTrue(!frete.getStatusFrete().equals(StatusFrete.CARGA),
                "Não é possível iniciar o transporte do frete, pois seu status é diferente de em carga.");

        frete.setStatusFrete(StatusFrete.EM_TRANSPORTE);
        this.freteRepository.save(frete);

        this.historicoFreteService.cadastrar(frete, StatusFrete.EM_TRANSPORTE);
    }

    @Transactional
    public void atualizarStatusInterrompidoParaEmTransporte(final Long idFrete) {

        final Frete frete = this.freteRepository.findById(idFrete).orElse(null);

        Assert.isTrue(frete != null, "Não foi possível localizar o frete informado.");

        Assert.isTrue(!frete.getStatusFrete().equals(StatusFrete.INTERROMPIDO),
                "Não é possível iniciar o transporte do frete, pois seu status é diferente de interrompido.");

        frete.setStatusFrete(StatusFrete.EM_TRANSPORTE);
        this.freteRepository.save(frete);

        this.historicoFreteService.cadastrar(frete, StatusFrete.EM_TRANSPORTE);
    }

    @Transactional
    public void atualizarStatusEmTransporteParaInterrompido(final Long idFrete) {

        final Frete frete = this.freteRepository.findById(idFrete).orElse(null);

        Assert.isTrue(frete != null, "Não foi possível localizar o frete informado.");

        Assert.isTrue(!frete.getStatusFrete().equals(StatusFrete.EM_TRANSPORTE),
                "Não é possível iniciar o transporte do frete, pois seu status é diferente de em transporte.");

        frete.setStatusFrete(StatusFrete.INTERROMPIDO);
        this.freteRepository.save(frete);

        this.historicoFreteService.cadastrar(frete, StatusFrete.INTERROMPIDO);
    }

    @Transactional
    public void atualizarStatusEmTransporteParaDescarga(final Long idFrete) {

        final Frete frete = this.freteRepository.findById(idFrete).orElse(null);

        Assert.isTrue(frete != null, "Não foi possível localizar o frete informado.");

        Assert.isTrue(!frete.getStatusFrete().equals(StatusFrete.EM_TRANSPORTE),
                "Não é possível iniciar o transporte do frete, pois seu status é diferente de em transporte.");

        frete.setStatusFrete(StatusFrete.DESCARGA);
        this.freteRepository.save(frete);

        this.historicoFreteService.cadastrar(frete, StatusFrete.DESCARGA);
    }

    @Transactional
    public void atualizarStatusFaturado(final Long idFrete) {

        final Frete frete = this.freteRepository.findById(idFrete).orElse(new Frete());

        Assert.isTrue(frete != null, "Não foi possível localizar o frete informado.");

        Assert.isTrue(!frete.getStatusFrete().equals(StatusFrete.DESCARGA),
                "Não é possível faturar um frete que não está com o sucesso de descarte.");

        final List<Despesa> despesa = this.despesaRepository.findByFreteAndAprovadorIsNull(frete.getId());

        Assert.isTrue(despesa.size() == 0,
                "Não é possível faturar um frete com despesas abertas.");

        frete.setStatusFrete(StatusFrete.FATURADO);
        this.freteRepository.save(frete);

        this.historicoFreteService.cadastrar(frete, StatusFrete.FATURADO);
    }

    @Transactional
    public void atualizarStatusCancelado(final Long idFrete) {

        final Frete frete = this.freteRepository.findById(idFrete).orElse(null);

        Assert.isTrue(frete != null, "Não foi possível localizar o frete informado.");

        try {
            if (frete.getStatusFrete().equals(StatusFrete.INTERROMPIDO)
                    || frete.getStatusFrete().equals(StatusFrete.CARGA)) {
                frete.setStatusFrete(StatusFrete.CANCELADO);
                this.freteRepository.save(frete);
                this.historicoFreteService.cadastrar(frete, StatusFrete.CANCELADO);
            }
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
