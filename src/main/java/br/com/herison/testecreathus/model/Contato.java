package br.com.herison.testecreathus.model;

import br.com.herison.testecreathus.enums.Sexo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "contatos")
@Getter@Setter
@AllArgsConstructor
public class Contato {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O campo Nome é Obrigatório")
    @Column(nullable = false, length = 150)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 1)
    @NotNull(message = "Campo Sexo é Obrigatório")
    private Sexo sexo;

    @Column(nullable = false, length = 15)
    @NotBlank(message = "O campo Telefone é Obrigatório")
    private String telefone;

    @Column(length = 100)
    @Email
    private String email;

    public Contato(String nome, Sexo sexo, String telefone, String email) {
        this.nome = nome;
        this.sexo = sexo;
        this.telefone = telefone;
        this.email = email;
    }

    @Deprecated
    public Contato() {
    }
}
