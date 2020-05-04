package br.com.app.controller;

import br.com.app.controller.generic.GenericControllerImpl;
import br.com.app.entity.TipoEmbalagem;
import br.com.app.service.TipoEmbalagemService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/tipo/embalagem")
public class TipoEmbalagemController extends GenericControllerImpl<TipoEmbalagem, TipoEmbalagemService> {
}
