package br.com.uniamerica.transportadora.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "td_caminhoes", schema = "public")
public class Caminhao extends AbstractEntity {

    @Getter @Setter
    @Column(name = "placa", length = 25, nullable = false)
    private String placa;

    @ManyToOne
    @Getter @Setter
    private Modelo modelo;

    @Getter @Setter
    @Column(name = "ano", length = 25, nullable = false)
    private int ano;

    @Getter @Setter
    @Column(name = "cor", length = 25, nullable = false)
    @Enumerated(EnumType.STRING)
    private Cor cor;

    @Getter @Setter
    @Column(name = "observacao", length = 255, nullable = false)
    private String observacao;
}
