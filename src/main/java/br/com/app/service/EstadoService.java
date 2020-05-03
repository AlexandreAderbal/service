package br.com.app.service;

import br.com.app.entity.Estado;
import br.com.app.repository.EstadoRepository;
import br.com.app.service.generic.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class EstadoService extends GenericServiceImpl<Estado, EstadoRepository> {}
