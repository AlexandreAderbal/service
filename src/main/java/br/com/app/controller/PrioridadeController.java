package br.com.app.controller;

import br.com.app.controller.generic.GenericControllerImpl;
import br.com.app.entity.Prioridade;
import br.com.app.service.PrioridadeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/prioridade")
public class PrioridadeController extends GenericControllerImpl<Prioridade, PrioridadeService> {
}
