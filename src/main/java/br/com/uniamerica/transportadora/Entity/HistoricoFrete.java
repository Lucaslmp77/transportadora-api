package br.com.uniamerica.transportadora.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "td_historico_frete", schema = "public")
public class HistoricoFrete extends AbstractEntity {

    @Getter @Setter
    @Column(name = "data", length = 10, nullable = false)
    private LocalDateTime data;

    @ManyToOne
    @Getter @Setter
    private Frete frete;

    @Getter @Setter
    @Column(name = "status_frete", length = 25, nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusFrete statusFrete;

    @ManyToOne
    @Getter @Setter
    private Usuario executor;
}
