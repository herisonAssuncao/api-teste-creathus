package br.com.herison.testecreathus.controller;

import br.com.herison.testecreathus.response.Response;
import br.com.herison.testecreathus.repository.ContatoRepository;
import br.com.herison.testecreathus.request.ContatoRequest;
import br.com.herison.testecreathus.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/contatos")
public class ContatoController {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private ContatoService contatoService;

    @GetMapping
    public ResponseEntity<Response> paginacao(@RequestParam(defaultValue = "0") Integer page) {
        Response response = contatoService.paginacao(page);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<Response> buscaPeloId(@PathVariable("id") Long id) {
        Response response = contatoService.buscaPorId(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PostMapping
    public ResponseEntity<Response> salvar(@Valid @RequestBody ContatoRequest contatoRequest) {
        Response response = contatoService.salva(contatoRequest);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<Response> atualiza(@PathVariable("id") Long id, @Valid @RequestBody ContatoRequest contato) {
        Response response = contatoService.atualiza(id, contato);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Response> remove(@PathVariable("id") Long id) {
        Response response = contatoService.remove(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
