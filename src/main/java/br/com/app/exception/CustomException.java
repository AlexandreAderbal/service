package br.com.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashSet;
import java.util.Set;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CustomException extends RuntimeException {

    private Set<ConstraintViolation<?>> listErrors = new HashSet<>();
    private String object;

    public CustomException(String message) {
        super(message);
    }
    public CustomException(Exception e) {

        super(e.getMessage());

        if(e instanceof CustomException && ((CustomException) e).listErrors.size() > 0){
            setListErrors(((CustomException) e).getListErrors());
            setObject(((CustomException) e).getObject());
        }

    }

    public CustomException(ConstraintViolationException e,Class<?> tClass) {

        super(e.getMessage());

        setListErrors(((ConstraintViolationException) e).getConstraintViolations());
        setObject(tClass.getSimpleName());

    }

    public Set<ConstraintViolation<?>> getListErrors() {
        return listErrors;
    }

    public void setListErrors(Set<ConstraintViolation<?>> listErrors) {
        this.listErrors = listErrors;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

}
