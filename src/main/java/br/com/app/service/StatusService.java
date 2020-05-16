package br.com.app.service;

import br.com.app.entity.Status;
import br.com.app.repository.StatusRepository;
import br.com.app.service.generic.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class StatusService extends GenericServiceImpl<Status, StatusRepository> {
}
