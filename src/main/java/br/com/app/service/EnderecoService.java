package br.com.app.service;

import br.com.app.entity.Endereco;
import br.com.app.repository.EnderecoRepository;
import br.com.app.service.generic.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService extends GenericServiceImpl<Endereco, EnderecoRepository> {
}
