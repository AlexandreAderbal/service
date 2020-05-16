package br.com.app.controller;

import br.com.app.controller.generic.GenericControllerImpl;
import br.com.app.entity.ChamadoAlteracao;
import br.com.app.service.ChamadoAlteracaoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chamado/alteracao")
public class ChamadoAlteracaoController extends GenericControllerImpl<ChamadoAlteracao, ChamadoAlteracaoService> {
}
