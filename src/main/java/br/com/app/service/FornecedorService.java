package br.com.app.service;

import br.com.app.entity.Fornecedor;
import br.com.app.entity.Layout;
import br.com.app.repository.FornecedorRepository;
import br.com.app.repository.LayoutRepository;
import br.com.app.service.generic.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class FornecedorService extends GenericServiceImpl<Fornecedor, FornecedorRepository> {}
