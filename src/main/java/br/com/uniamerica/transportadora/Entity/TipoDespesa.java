package br.com.uniamerica.transportadora.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "td_tipo_despesa", schema = "public")
public class TipoDespesa extends AbstractEntity {

    @Getter @Setter
    @Column(name = "nome", length = 25, nullable = false)
    private String nome;
}
