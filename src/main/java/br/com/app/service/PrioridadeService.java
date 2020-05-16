package br.com.app.service;

import br.com.app.entity.Prioridade;
import br.com.app.repository.PrioridadeRepository;
import br.com.app.service.generic.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PrioridadeService extends GenericServiceImpl<Prioridade, PrioridadeRepository> {
}
