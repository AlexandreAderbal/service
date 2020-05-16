package br.com.app.controller;

import br.com.app.controller.generic.GenericControllerImpl;
import br.com.app.entity.Usuario;
import br.com.app.exception.CustomException;
import br.com.app.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController extends GenericControllerImpl<Usuario, UsuarioService> {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(value = "/by/email")
    public ResponseEntity<Usuario> save(@RequestBody String email) throws Exception {
        try{
            return new ResponseEntity<Usuario>(this.usuarioService.findByEmail(email).orElse(new Usuario()),HttpStatus.OK);
        }catch (Exception e){
            logger.error(e.getMessage());
            throw new CustomException(e);
        }
    }

    @PutMapping(value = "/update/permissao/{idPermissao}")
    public ResponseEntity<HttpStatus> updateUsuarioPermissao(@PathVariable Long idPermissao,@RequestBody Long idUsuario) throws Exception {
        try{
            this.usuarioService.updateUsuarioPermissao(idUsuario,idPermissao);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            logger.error(e.getMessage());
            throw new CustomException(e);
        }
    }

    @PutMapping(value = "/update/senha/{idUsuario}")
    public ResponseEntity<HttpStatus> updateUsuarioSenha(@PathVariable String senha,@RequestBody Long idUsuario) throws Exception {
        try{
            this.usuarioService.updateSenha(senha,idUsuario);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            logger.error(e.getMessage());
            throw new CustomException(e);
        }
    }

    @PostMapping(value = "/update/ativo")
    public ResponseEntity<HttpStatus> updateAtivo(@RequestBody Long idUsuario) throws Exception {
        try{
            this.usuarioService.updateAtivo(idUsuario);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            logger.error(e.getMessage());
            throw new CustomException(e);
        }
    }

}
