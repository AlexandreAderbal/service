package br.com.app.controller;

import br.com.app.controller.generic.GenericControllerImpl;
import br.com.app.entity.Cidade;
import br.com.app.service.CidadeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cidade")
public class CidadeController extends GenericControllerImpl<Cidade, CidadeService> {
}
