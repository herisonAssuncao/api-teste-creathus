package br.com.herison.testecreathus.service;

import br.com.herison.testecreathus.response.Response;
import br.com.herison.testecreathus.model.Contato;
import br.com.herison.testecreathus.repository.ContatoRepository;
import br.com.herison.testecreathus.request.ContatoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    public Response paginacao(Integer page) {
        Pageable pageable = PageRequest.of(page, 3);
        Page<Contato> lista = contatoRepository.findAll(pageable);
        return new Response("Page ok", HttpStatus.OK, lista);
    }

    public Response lista() {
        try {
            return new Response("Lista Contatos", HttpStatus.OK, contatoRepository.findAll());
        } catch (Exception e) {
            return new Response("Erro ao Buscar Contatos", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public Response buscaPorId(Long id) {
            Optional<Contato> contato = contatoRepository.findById(id);
            if (contato.isPresent()) {
                return new Response("Contato Atualizado", HttpStatus.OK, contatoRepository.findById(id));
            }

            return new Response("Contato não encontrado", HttpStatus.NOT_FOUND);
    }

    public Response salva(ContatoRequest contatoRequest) {
        try {
            Contato contato = contatoRequest.toModel();
            contato = contatoRepository.save(contato);
            return new Response("Contato Salvo", HttpStatus.OK, contato);
        } catch (Exception e) {
            return new Response("Erro ao salvar contato", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public Response atualiza(Long id, ContatoRequest contatoRequest) {
        try {
            Optional<Contato> contatoExistente = contatoRepository.findById(id);
            if (contatoExistente.isPresent()) {
                Contato contato = contatoRequest.toModel();
                contato.setId(contatoExistente.get().getId());
                contatoRepository.save(contato);
                return new Response("Contato Atualizado", HttpStatus.OK);
            }

            return new Response("Contato não encontrado", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new Response("Erro ao atualizar contato", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public Response remove(Long id) {
        Optional<Contato> contatoExistente = contatoRepository.findById(id);
        if (contatoExistente.isPresent()) {
            contatoRepository.delete(contatoExistente.get());
            return new Response("Contato Removido", HttpStatus.OK);
        }

        return new Response("Contato não encontrado", HttpStatus.NOT_FOUND);
    }
}
