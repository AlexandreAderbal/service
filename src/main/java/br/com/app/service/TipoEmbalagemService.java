package br.com.app.service;

import br.com.app.entity.TipoEmbalagem;
import br.com.app.repository.TipoEmbalagemRepository;
import br.com.app.service.generic.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class TipoEmbalagemService extends GenericServiceImpl<TipoEmbalagem, TipoEmbalagemRepository>{}
