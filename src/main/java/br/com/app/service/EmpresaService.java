package br.com.app.service;

import br.com.app.entity.Empresa;
import br.com.app.repository.EmpresaRepository;
import br.com.app.service.generic.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService extends GenericServiceImpl<Empresa, EmpresaRepository> {
}
