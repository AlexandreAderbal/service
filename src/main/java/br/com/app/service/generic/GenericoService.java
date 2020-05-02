package br.com.app.service.generic;

import java.util.List;
import java.util.Optional;

public interface GenericoService<T,Long> {

    void save(T entity);
    void validate(T entity);
    Optional<T>  findById(Long id);
    List<T> findAll();
    void delete(T entity);

}
