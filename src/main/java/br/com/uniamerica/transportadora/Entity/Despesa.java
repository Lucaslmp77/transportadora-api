package br.com.uniamerica.transportadora.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "td_despesa", schema = "public")
public class Despesa extends AbstractEntity {

    @ManyToOne
    @Getter @Setter
    private TipoDespesa tipoDespesa;

    @Getter @Setter
    @Column(name = "valor", nullable = false, precision = 5, scale = 3)
    private BigDecimal valor;

    @ManyToOne
    @Getter @Setter
    private Usuario motorista;

    @Getter @Setter
    @Column(name = "data", length = 25, nullable = false)
    private LocalDateTime data;

    @ManyToOne
    @Getter @Setter
    private Usuario aprovador;

    @ManyToOne
    @Getter @Setter
    private Frete frete;
}
