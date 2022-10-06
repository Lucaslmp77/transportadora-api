package br.com.uniamerica.transportadora.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "td_historico_frete", schema = "transportadora")
public class HistoricoFrete extends AbstractEntity {

    @Getter @Setter
    @Column(name = "data", length = 10, nullable = false)
    private LocalDateTime data;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @Getter @Setter
    @JoinColumn(name = "id_frete", nullable = false)
    private Frete frete;

    @Getter @Setter
    @Column(name = "status_frete", length = 25, nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusFrete statusFrete;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @Getter @Setter
    @JoinColumn(name = "id_executor", nullable = false)
    private Usuario executor;
}
