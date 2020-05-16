package br.com.app.service;

import br.com.app.entity.Departamento;
import br.com.app.repository.DepartamentoRepository;
import br.com.app.service.generic.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class DepartamentoService extends GenericServiceImpl<Departamento, DepartamentoRepository> {
}
