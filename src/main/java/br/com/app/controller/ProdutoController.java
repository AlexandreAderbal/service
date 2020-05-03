package br.com.app.controller;

import br.com.app.controller.generic.GenericControllerImpl;
import br.com.app.entity.Produto;
import br.com.app.entity.Usuario;
import br.com.app.service.ProdutoService;
import br.com.app.service.UsuarioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController extends GenericControllerImpl<Produto, ProdutoService> {
}
