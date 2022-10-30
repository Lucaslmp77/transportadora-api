package br.com.uniamerica.transportadora.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_frete", schema = "transportadora")
public class Frete extends AbstractEntity {

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @Getter @Setter
    @NotNull
    @JoinColumn(name = "id_produto", nullable = false)
    private Produto produto;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @Getter @Setter
    @NotNull
    @JoinColumn(name = "id_cidade_origem", nullable = false)
    private Cidade cidadeOrigem;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @Getter @Setter
    @NotNull
    @JoinColumn(name = "id_cidade_destino", nullable = false)
    private Cidade cidadeDestino;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @Getter @Setter
    @NotNull
    @JoinColumn(name = "id_motorista", nullable = false)
    private Usuario motorista;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @Getter @Setter
    @NotNull
    @JoinColumn(name = "id_caminhao", nullable = false)
    private Caminhao caminhao;

    @Getter @Setter
    @NotNull
    @Column(name = "status_frete", length = 25, nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusFrete statusFrete;

    @Getter @Setter
    @NotNull
    @Column(name = "quilometragem_ini", length = 25, nullable = false)
    private int quilometragemIni;

    @Getter @Setter
    @NotNull
    @Column(name = "quilometragem_fim", length = 25, nullable = false)
    private int quilometragemFim;

    @Getter @Setter
    @NotNull
    @Column(name = "total_bruto_recebido_nota", nullable = false, precision = 5, scale = 3)
    private BigDecimal totalBrutoRecebidoNota;

    @Getter @Setter
    @NotNull
    @Column(name = "total_liquido_recebido", nullable = false, precision = 5, scale = 3)
    private BigDecimal totalLiquidoRecebido;

    @Getter @Setter
    @NotNull
    @Column(name = "peso_inicial", nullable = false, precision = 5, scale = 3)
    private BigDecimal pesoInicial;

    @Getter @Setter
    @NotNull
    @Column(name = "peso_final", nullable = false, precision = 5, scale = 3)
    private BigDecimal pesoFinal;

    @Getter @Setter
    @NotNull
    @Column(name = "peso_final_transportado", nullable = false, precision = 5, scale = 3)
    private BigDecimal pesoFinalTransportado;

    @Getter @Setter
    @NotNull
    @Column(name = "preco_tonelada", nullable = false, precision = 5, scale = 3)
    private BigDecimal precoTonelada;

    @Getter @Setter
    @NotNull
    @Column(name = "data_inicio", length = 25, nullable = false)
    private LocalDateTime dataInicio;

    @Getter @Setter
    @NotNull
    @Column(name = "data_fim", length = 25, nullable = false)
    private LocalDateTime dataFim;

    @Getter @Setter
    @Column(name = "observacao", length = 255, nullable = false)
    private String observacao;
}
