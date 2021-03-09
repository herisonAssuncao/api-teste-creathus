package br.com.herison.testecreathus.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;
public class Response {

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private Object dados;
    private final String mensagem;
    private final HttpStatus status;

    public Object getDados() {
        return dados;
    }

    public String getMensagem() {
        return mensagem;
    }

    @JsonIgnore
    public HttpStatus getStatus() {
        return status;
    }

    public Response(String mensagem, HttpStatus status, Object dados) {
        this.mensagem = mensagem;
        this.status = status;
        this.dados = dados;
    }

    public Response(String mensagem, HttpStatus status) {
        this.mensagem = mensagem;
        this.status = status;
    }
}
