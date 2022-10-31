package br.com.uniamerica.transportadora.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Getter @Setter
    @Column(name = "id", length = 25, nullable = false, unique = true)
    private Long id;

    @Getter @Setter
    @Column(name = "cadastrar", nullable = false)
    private LocalDateTime cadastrar;

    @Getter @Setter
    @Column(name = "alterar")
    private LocalDateTime alterar;

    @Getter @Setter
    @Column(name = "ativo", nullable = false)
    private boolean ativo;

    @PrePersist
    public void dataCadastrar() {
        this.setCadastrar(LocalDateTime.now());
        this.setAtivo(true);
    }

    @PreUpdate
    public void dataAlterar() {
        this.setAlterar(LocalDateTime.now());
    }
}
