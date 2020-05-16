package br.com.app.service;

import br.com.app.entity.Arquivo;
import br.com.app.repository.ArquivoRepository;
import br.com.app.service.generic.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ArquivoService extends GenericServiceImpl<Arquivo, ArquivoRepository> {
}
