package br.com.uniamerica.transportadora.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Table(name = "tb_frete", schema = "transportadora")
public class Frete extends AbstractEntity {

    @ManyToOne
    @Getter @Setter
    @JoinColumn(name = "id_produto", nullable = false)
    private Produto produto;

    @ManyToOne
    @Getter @Setter
    @JoinColumn(name = "id_cidade_origem", nullable = false)
    private Cidade cidadeOrigem;

    @ManyToOne
    @Getter @Setter
    @JoinColumn(name = "id_cidade_destino", nullable = false)
    private Cidade cidadeDestino;

    @ManyToOne
    @Getter @Setter
    @JoinColumn(name = "id_motorista", nullable = false)
    private Usuario motorista;

    @ManyToOne
    @Getter @Setter
    @JoinColumn(name = "id_caminhao", nullable = false)
    private Caminhao caminhao;

    @Getter @Setter
    @Column(name = "status_frete", length = 25, nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusFrete statusFrete;

    @Getter @Setter
    @Column(name = "quilometragem_ini", nullable = true,  precision = 5, scale = 3)
    private BigDecimal quilometragemIni;

    @Getter @Setter
    @Column(name = "quilometragem_fim", nullable = true,  precision = 5, scale = 3)
    private BigDecimal quilometragemFim;

    @Getter @Setter
    @Column(name = "total_bruto_recebido_nota", nullable = true, precision = 5, scale = 3)
    private BigDecimal totalBrutoRecebidoNota;

    @Getter @Setter
    @Column(name = "total_liquido_recebido", nullable = true, precision = 5, scale = 3)
    private BigDecimal totalLiquidoRecebido;

    @Getter @Setter
    @Column(name = "peso_inicial", nullable = true, precision = 5, scale = 3)
    private BigDecimal pesoInicial;

    @Getter @Setter
    @Column(name = "peso_final", nullable = true, precision = 5, scale = 3)
    private BigDecimal pesoFinal;

    @Getter @Setter
    @Column(name = "peso_final_transportado", nullable = true, precision = 5, scale = 3)
    private BigDecimal pesoFinalTransportado;

    @Getter @Setter
    @Column(name = "preco_tonelada", nullable = false, precision = 5, scale = 3)
    private BigDecimal precoTonelada;

    @Getter @Setter
    @JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
    @Column(name = "data_inicio", length = 25, nullable = true)
    private LocalDateTime dataInicio;

    @Getter @Setter
    @JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
    @Column(name = "data_fim", length = 25, nullable = true)
    private LocalDateTime dataFim;

    @Getter @Setter
    @Column(name = "observacao", length = 255, nullable = true)
    private String observacao;
}
