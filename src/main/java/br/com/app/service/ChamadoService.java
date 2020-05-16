package br.com.app.service;

import br.com.app.entity.Chamado;
import br.com.app.repository.ChamadoRepository;
import br.com.app.service.generic.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ChamadoService extends GenericServiceImpl<Chamado, ChamadoRepository> {
}
