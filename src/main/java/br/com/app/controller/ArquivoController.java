package br.com.app.controller;

import br.com.app.controller.generic.GenericControllerImpl;
import br.com.app.entity.Arquivo;
import br.com.app.service.ArquivoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/arquivo")
public class ArquivoController extends GenericControllerImpl<Arquivo, ArquivoService> {
}
