package com.fiap.parquimetro.entrypoints.rest_controllers.error_handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fiap.parquimetro.core.use_cases.exceptions.PagamentoPendenteException;
import com.fiap.parquimetro.core.use_cases.exceptions.TicketNaoEncontradoException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PagamentoPendenteException.class)
    public ResponseEntity<String> handlePagamentoPendenteException(PagamentoPendenteException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TicketNaoEncontradoException.class)
    public ResponseEntity<String> handleTicketNaoEncontradoException(TicketNaoEncontradoException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
