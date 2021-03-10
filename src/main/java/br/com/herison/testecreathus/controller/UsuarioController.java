package br.com.herison.testecreathus.controller;

import br.com.herison.testecreathus.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

    @GetMapping("auth")
    public ResponseEntity<Response> auth() {
        Response response = new Response("logado", HttpStatus.OK);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
