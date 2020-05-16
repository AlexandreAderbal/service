package br.com.app.controller;

import br.com.app.exception.CustomException;
import br.com.app.payload.ErrorDetails;
import br.com.app.payload.ErrorResponse;
import org.json.JSONException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@ControllerAdvice
public class ControllerCustomException extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        return super.handleHttpMessageNotReadable(ex, headers, status, request);
    }

    @ExceptionHandler(value = {CustomException.class})
    public final ResponseEntity<Object> handleCustomException(CustomException ex,
                                                              WebRequest request) throws JSONException {

        List<ErrorDetails> errors = new ArrayList<ErrorDetails>();

        if(ex.getListErrors().size() > 0){

            errors.addAll(ex.getListErrors().stream()
                    .map(constraintViolation ->
                                    new ErrorDetails(  constraintViolation.getMessage(),
                                                       constraintViolation.getPropertyPath().toString()))
                    .collect(Collectors.toList()));

        }else{

            errors.add( new ErrorDetails(   ex.getMessage(),
                                            null));
        }

        ErrorResponse errorResponse = getErrorResponse("Ocorreu um erro interno.",
                                                            ex.getObject(),
                                                            HttpStatus.BAD_REQUEST,
                                                            errors,
                                                            request.getDescription(false));

        return new ResponseEntity<Object>(errorResponse,  HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {

        List<ErrorDetails> errors = getErrors(ex);

        ErrorResponse errorResponse = getErrorResponse("Requisição possui campos inválidos",
                                                        ex.getBindingResult().getObjectName(),
                                                        status,
                                                        errors,
                                                        request.getDescription(false));

        return new ResponseEntity<>(errorResponse, status);
    }

    private List<ErrorDetails> getErrors(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors().stream()
                .map(error -> new ErrorDetails(error.getDefaultMessage(),
                                               error.getField())).collect(Collectors.toList());
    }

    private ErrorResponse getErrorResponse(String titulo,
                                           String objetoName,
                                           HttpStatus status,
                                           List<ErrorDetails> errors,
                                           String endPoint) {

        return new ErrorResponse(   titulo,
                                    status.value(),
                                    status.getReasonPhrase(),
                                    objetoName,
                                    errors,
                                    endPoint);
    }

}
