package br.com.uniamerica.transportadora.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "td_cidade", schema = "public")
public class Cidade extends AbstractEntity{

    @Getter @Setter
    @Column(name = "nome", length = 25, nullable = false)
    private String nome;

    @ManyToOne
    @Getter @Setter
    private Estado estado;
}
