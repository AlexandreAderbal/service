package br.com.app.service.generic;

import br.com.app.exception.CustomException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;

@Service
public abstract class GenericServiceImpl<T,Repository extends JpaRepository<T,Long>> implements GenericoService<T,Long> {

    private static final Logger logger = LoggerFactory.getLogger(GenericServiceImpl.class);

    @Autowired
    private Repository repository;

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void save(T entity) {
        try {
            
            this.validate(entity);
            this.repository.save(entity);

        } catch (ConstraintViolationException e){
            throw new CustomException(e, entity.getClass());
        }catch (Exception e){
            logger.error("Erro ao registrar " + GenericServiceImpl.class + " :",e.getMessage());
            throw new CustomException(e.getMessage());
        }
    }

    @Override
    public void validate(T entity){
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Optional<T> findById(Long id) {
        try {
            return  this.repository.findById(id);
        }catch (Exception e){
            logger.error("Erro ao buscar o " + GenericServiceImpl.class + " com id - " + id + ":",e.getMessage());
            throw new CustomException(e.getMessage());
        }
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<T> findAll() {
        try {
            return  this.repository.findAll();
        }catch (Exception e){
            logger.error("Erro ao buscar a lista de " + GenericServiceImpl.class + " :",e.getMessage());
            throw new CustomException(e.getMessage());
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void delete(T entity) {
        try {
            this.repository.delete(entity);
        }catch (Exception e){
            logger.error("Erro ao excluir o " + GenericServiceImpl.class + " :",e.getMessage());
            throw new CustomException(e.getMessage());
        }
    }

}
