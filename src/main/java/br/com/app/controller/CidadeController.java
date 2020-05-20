package br.com.app.controller;

import br.com.app.controller.generic.GenericControllerImpl;
import br.com.app.entity.Cidade;
import br.com.app.exception.CustomException;
import br.com.app.service.CidadeService;
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
@RequestMapping("/cidade")
public class CidadeController extends GenericControllerImpl<Cidade, CidadeService> {

    private static final Logger logger = LoggerFactory.getLogger(CidadeController.class);

    @Autowired
    private CidadeService cidadeService;

    @GetMapping(value = "/find/by/estado/{id}")
    public ResponseEntity<List<Cidade>> findByEstado(@PathVariable Long id ) {
        try{
            return new ResponseEntity<List<Cidade>>(cidadeService.findByEstado(id), HttpStatus.OK);
        }catch (Exception e){
            throw new CustomException(e);
        }
    }

}
