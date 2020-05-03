package br.com.app.controller;

import br.com.app.controller.generic.GenericControllerImpl;
import br.com.app.entity.Fornecedor;
import br.com.app.service.FornecedorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController extends GenericControllerImpl<Fornecedor, FornecedorService> {
}
