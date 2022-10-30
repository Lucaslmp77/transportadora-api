package br.com.uniamerica.transportadora.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_despesa", schema = "transportadora")
public class Despesa extends AbstractEntity {

    @ManyToOne
    @Getter @Setter
    private TipoDespesa tipoDespesa;

    @Getter @Setter
    @Column(name = "valor", nullable = false, precision = 5, scale = 3)
    private BigDecimal valor;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @Getter @Setter
    @JoinColumn(name = "id_motorista", nullable = false)
    private Usuario motorista;

    @Getter @Setter
    @Column(name = "data", length = 25, nullable = false)
    private LocalDateTime data;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @Getter @Setter
    @JoinColumn(name = "id_aprovador")
    private Usuario aprovador;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @Getter @Setter
    @JoinColumn(name = "id_frete", nullable = false)
    private Frete frete;

    @Getter @Setter
    @Column(name = "aprovada", nullable = false)
    private Boolean aprovada;
}
