package br.com.app.controller;

import br.com.app.controller.generic.GenericControllerImpl;
import br.com.app.entity.Status;
import br.com.app.exception.CustomException;
import br.com.app.service.StatusService;
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
@RequestMapping(value = "/status")
public class StatusController extends GenericControllerImpl<Status, StatusService> {

    private static final Logger logger = LoggerFactory.getLogger(StatusController.class);

    @Autowired
    private StatusService statusService;

    @PostMapping(value = "/update/ativo")
    public ResponseEntity<Status> alterarAtivo(@RequestBody Status status) {
        try{
            return new ResponseEntity<Status>(statusService.alterarAtivo(status), HttpStatus.OK);
        }catch (Exception e){
            logger.error(e.getMessage());
            throw new CustomException(e);
        }
    }
}
