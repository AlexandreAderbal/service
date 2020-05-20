package br.com.app.service;

import br.com.app.entity.Cidade;
import br.com.app.entity.Estado;
import br.com.app.exception.CustomException;
import br.com.app.repository.CidadeRepository;
import br.com.app.service.generic.GenericServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CidadeService extends GenericServiceImpl<Cidade, CidadeRepository> {

    private static final Logger logger = LoggerFactory.getLogger(CidadeService.class);

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoService estadoService;

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Cidade> findByEstado(Long idEstado) {
        try {

            Estado estado = estadoService.findById(idEstado).orElseThrow(
                    () -> new CustomException("Não foi possivel encontrar o estado com id: "+ idEstado)
            );
            return cidadeRepository.findByEstado(estado);

        } catch (Exception e) {
            logger.error("Não foi encontrado o estado com o id: " + idEstado,e);
            throw new CustomException(e);
        }
    }
}
