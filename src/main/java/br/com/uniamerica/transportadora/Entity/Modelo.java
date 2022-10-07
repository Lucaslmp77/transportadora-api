package br.com.uniamerica.transportadora.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tb_modelo", schema = "transportadora")
public class Modelo extends AbstractEntity{

    @Getter @Setter
    @Column(name = "nome", length = 25, nullable = false)
    private String nome;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @Getter @Setter
    @JoinColumn(name = "id_marca", nullable = false)
    private Marca marca;
}
