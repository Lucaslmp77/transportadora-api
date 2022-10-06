package br.com.uniamerica.transportadora.Entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "td_produto", schema = "transportadora")
public class Produto extends AbstractEntity{

    @Getter @Setter
    @Length(min = 3, max = 25, message = "O nome devera ter no minimo {min} caracteres e no maximo {max} caracteres")
    @Column(name = "nome", length = 25, nullable = false)
    private String nome;
}
