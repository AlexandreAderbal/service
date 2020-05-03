package br.com.app.controller;

import br.com.app.controller.generic.GenericControllerImpl;
import br.com.app.entity.Permissao;
import br.com.app.exception.CustomException;
import br.com.app.payload.ListaPermissao;
import br.com.app.service.PermissaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/permissao")
public class PermissaoController extends GenericControllerImpl<Permissao, PermissaoService> {

    private static final Logger logger = LoggerFactory.getLogger(PermissaoController.class);

    @Autowired
    private PermissaoService permissaoService;

    @GetMapping(value = "/lista/{idUsuario}")
    public ResponseEntity<List<ListaPermissao>> findAllListaPermissao(@PathVariable Long idUsuario) throws Exception {
        try{
            return new ResponseEntity(this.permissaoService.findAllListaPermissao(idUsuario), HttpStatus.OK);
        }catch (Exception e){
            logger.error(e.getMessage());
            throw new Exception(e);
        }
    }

    @GetMapping(value = "/inicializar/persmissao")
    public ResponseEntity<HttpStatus> inicializaPermissao() throws Exception {
        try{
            this.permissaoService.inicializaPermissao();
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            logger.error(e.getMessage());
            throw new Exception(e);
        }
    }


}
