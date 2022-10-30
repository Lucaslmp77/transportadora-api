package br.com.uniamerica.transportadora.Entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "tb_usuario", schema = "transportadora")
public class Usuario extends AbstractEntity{

    @Getter @Setter
    @Column(name = "perc_ganho", nullable = false, precision = 5, scale = 3)
    private BigDecimal percGanho;

    @Getter @Setter
    @Length(min = 3, max = 25, message = "O login devera ter no minimo {min} caracteres e no maximo {max} caracteres")
    @Column(name = "login", length = 25, nullable = false, unique = true)
    private String login;

    @Getter @Setter
    @Length(min = 3, max = 25, message = "A senha devera ter no minimo {min} caracteres e no maximo {max} caracteres")
    @Column(name = "senha", length = 25, nullable = false)
    private String senha;

    @Getter @Setter
    @Column(name = "grupo", length = 25, nullable = false)
    @Enumerated(EnumType.STRING)
    private Grupo grupo;

    @Getter @Setter
    @Column(name = "nome", length = 25, nullable = false)
    private String nome;

    @Getter @Setter
    @Column(name = "cpf", nullable = false, unique = true)
    @CPF
    private String cpf;

    @Getter @Setter
    @Column(name = "telefone", length = 25, nullable = false)
    private String telefone;

    @Getter @Setter
    @Column(name = "data_nascimento", length = 25, nullable = false)
    private Date dataNascimento;

    @Getter @Setter
    @Column(name = "endereco", length = 150, nullable = false)
    private String endereco;

    @Getter @Setter
    @Column(name = "observacao", length = 255, nullable = false)
    private String observacao;
}
