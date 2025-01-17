package com.fiap.parquimetro.entrypoints.rest_controllers.error_handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fiap.parquimetro.core.use_cases.exceptions.PagamentoPendenteException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PagamentoPendenteException.class)
    public ResponseEntity<String> handleRuntimeException(PagamentoPendenteException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
