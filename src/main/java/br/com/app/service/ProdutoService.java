package br.com.app.service;

import br.com.app.entity.Permissao;
import br.com.app.entity.Produto;
import br.com.app.repository.PermissaoRepository;
import br.com.app.repository.ProdutoRepository;
import br.com.app.service.generic.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService extends GenericServiceImpl<Produto, ProdutoRepository> {
}
