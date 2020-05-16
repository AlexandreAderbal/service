package br.com.app.controller;

import br.com.app.controller.generic.GenericControllerImpl;
import br.com.app.entity.Chamado;
import br.com.app.service.ChamadoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chamado")
public class ChamadoController extends GenericControllerImpl<Chamado, ChamadoService> {
}
