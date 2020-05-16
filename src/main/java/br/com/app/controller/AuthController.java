package br.com.app.controller;

import br.com.app.exception.CustomException;
import br.com.app.payload.LoginRequest;
import br.com.app.payload.LoginResponse;
import br.com.app.service.PermissaoService;
import br.com.app.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PermissaoService permissaoService;

    @PostMapping(value = "/login")
    public ResponseEntity<LoginResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequestDTO) {
        try{
            return new ResponseEntity<LoginResponse>(usuarioService.autenticacao(loginRequestDTO),HttpStatus.OK);
        }catch (Exception e){
            logger.error(e.getMessage());
            throw new CustomException(e);
        }
    }

    @GetMapping("/save/adm")
    public ResponseEntity<HttpStatus> saveAdm() {
        try{

            usuarioService.saveAdm();
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);

        }catch (Exception e){
            logger.error(e.getMessage());
            throw new CustomException(e);
        }
    }

    @GetMapping(value = "/inicializar/persmissao")
    public ResponseEntity<HttpStatus> inicializaPermissao() throws Exception {
        try{
            this.permissaoService.inicializaPermissao();
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            logger.error(e.getMessage());
            throw new CustomException(e);
        }
    }
}
