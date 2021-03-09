package br.com.herison.testecreathus.request;

import br.com.herison.testecreathus.customrule.SexoCustomRule;
import br.com.herison.testecreathus.enums.Sexo;
import br.com.herison.testecreathus.model.Contato;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter@Setter
public class ContatoRequest {
    @NotBlank(message = "O campo Nome é Obrigatório")
    @Column(nullable = false, length = 150)
    private String nome;

    @Size(max = 1)
    @NotNull(message = "Campo Sexo é Obrigatório")
    @SexoCustomRule
    private String sexo;

    @NotBlank(message = "O campo Telefone é Obrigatório")
    private String telefone;

    @Column(length = 100)
    @Email
    private String email;

    public Contato toModel() {
        return new Contato(this.nome, Sexo.valueOf(this.sexo), this.telefone, this.email);
    }

    public ContatoRequest(String nome, String sexo, String telefone, String email) {
        this.nome = nome;
        this.sexo = sexo;
        this.telefone = telefone;
        this.email = email;
    }
}
