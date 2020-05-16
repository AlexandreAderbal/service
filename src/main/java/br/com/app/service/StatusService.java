package br.com.app.service;

import br.com.app.entity.Status;
import br.com.app.exception.CustomException;
import br.com.app.repository.StatusRepository;
import br.com.app.service.generic.GenericServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StatusService extends GenericServiceImpl<Status, StatusRepository> {

    private static final Logger logger = LoggerFactory.getLogger(StatusService.class);

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Status alterarAtivo(Status status) {

        try{

            Long id = status.getId();
            status = this.findById(id).orElseThrow(
                    ()->new CustomException("Não foi possivel localizar o status com o id: " + id)
            );

            status.setAtivo(!status.getAtivo());
            super.save(status);

            return status;

        }catch (Exception e){
            logger.error("Erro ao tentar ativa/desativar a status:");
            throw new CustomException(e.getMessage());
        }

    }
}
