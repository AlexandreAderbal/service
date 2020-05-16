package br.com.app.controller;

import br.com.app.controller.generic.GenericControllerImpl;
import br.com.app.entity.Prioridade;
import br.com.app.exception.CustomException;
import br.com.app.service.PrioridadeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/prioridade")
public class PrioridadeController extends GenericControllerImpl<Prioridade, PrioridadeService> {

    private static final Logger logger = LoggerFactory.getLogger(PrioridadeController.class);

    @Autowired
    private PrioridadeService prioridadeService;

    @PostMapping(value = "/update/ativo")
    public ResponseEntity<Prioridade> alterarAtivo(@RequestBody Prioridade prioridade) {
        try{
            return new ResponseEntity<Prioridade>(prioridadeService.alterarAtivo(prioridade),HttpStatus.OK);
        }catch (Exception e){
            logger.error(e.getMessage());
            throw new CustomException(e);
        }
    }

}
