package br.com.uniamerica.transportadora.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tb_cidade", schema = "transportadora",
        uniqueConstraints = {
            @UniqueConstraint(
                    columnNames = {"nome", "id_estado"}
            )
        }
)
public class Cidade extends AbstractEntity{

    @Getter @Setter
    @Column(name = "nome", length = 25, nullable = false)
    private String nome;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @Getter @Setter
    @JoinColumn(name = "id_estado", nullable = false)
    private Estado estado;
}
