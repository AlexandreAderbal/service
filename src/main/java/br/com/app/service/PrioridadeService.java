package br.com.app.service;

import br.com.app.entity.Prioridade;
import br.com.app.entity.Usuario;
import br.com.app.exception.CustomException;
import br.com.app.repository.PrioridadeRepository;
import br.com.app.service.generic.GenericServiceImpl;
import br.com.app.utils.AppUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PrioridadeService extends GenericServiceImpl<Prioridade, PrioridadeRepository> {

    private static final Logger logger = LoggerFactory.getLogger(PrioridadeService.class);

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Prioridade alterarAtivo(Prioridade prioridade) {
        try{

            Long id = prioridade.getId();
            prioridade = this.findById(id).orElseThrow(
                    ()->new CustomException("Não foi possivel localizar a prioridade com o id: " + id)
            );

            prioridade.setAtivo(!prioridade.getAtivo());
            super.save(prioridade);

            return prioridade;

        }catch (Exception e){
            logger.error("Erro ao tentar ativa/desativar a prioridade:");
            throw new CustomException(e.getMessage());
        }
    }
}
