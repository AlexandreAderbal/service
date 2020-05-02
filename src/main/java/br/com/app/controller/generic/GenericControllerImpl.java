package br.com.app.controller.generic;

import br.com.app.exception.CustomException;
import br.com.app.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class GenericControllerImpl<T, Service extends GenericServiceImpl> implements GenericController<T,Long> {

    @Autowired
    private Service service;

    @Override
    @PostMapping(value = "/save")
    public ResponseEntity<HttpStatus>  save(@RequestBody @Validated T entity) {
        try{
            service.save(entity);
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        }catch (Exception e){
            throw new CustomException(e);
        }
    }

    @Override
    @GetMapping(value = "/find/by/{id}")
    public ResponseEntity<T> findById(@PathVariable Long id) {
        try{
            return new ResponseEntity<T>((T) service.findById(id),HttpStatus.OK);
        }catch (Exception e){
            throw new CustomException(e);
        }
    }

    @Override
    @GetMapping(value = "/find/all")
    public ResponseEntity<List<T>> findAll() {
        try{
            return new ResponseEntity<List<T>>(service.findAll(),HttpStatus.OK);
        }catch (Exception e){
            throw new CustomException(e);
        }
    }

    @Override
    @PostMapping(value = "/delete")
    public ResponseEntity<HttpStatus>  delete(@RequestBody T entity) {
        try{
            service.delete(entity);
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        }catch (Exception e){
            throw new CustomException(e);
        }
    }
}
