package br.com.app.controller;

import br.com.app.controller.generic.GenericControllerImpl;
import br.com.app.entity.Estado;
import br.com.app.entity.Fornecedor;
import br.com.app.service.EstadoService;
import br.com.app.service.FornecedorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estado")
public class EstadoController extends GenericControllerImpl<Estado, EstadoService> {
}
