package br.com.uniamerica.transportadora.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "td_estado", schema = "transportadora")
public class Estado extends AbstractEntity {

    @Getter @Setter
    @Column(name = "estado", length = 25, nullable = false)
    private String estado;
}
