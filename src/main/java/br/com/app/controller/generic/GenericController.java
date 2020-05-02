package br.com.app.controller.generic;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface GenericController<T,Long> {

    ResponseEntity<HttpStatus> save(T entity);
    ResponseEntity<T>findById(Long id);
    ResponseEntity<List<T>> findAll();
    ResponseEntity<HttpStatus>  delete(T entity);

}
