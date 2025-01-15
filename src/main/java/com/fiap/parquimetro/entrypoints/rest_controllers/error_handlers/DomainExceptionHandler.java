package com.fiap.parquimetro.entrypoints.rest_controllers.error_handlers;

import com.fiap.parquimetro.core.domain.exceptions.DomainStateException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class DomainExceptionHandler {
    private final DomainError domainError = new DomainError();

    @ExceptionHandler(DomainStateException.class)
    public ResponseEntity<DomainError> trataErroDominio(DomainStateException e, HttpServletRequest request) {
        var status = HttpStatus.BAD_REQUEST;

        domainError.setTimestamp(Instant.now());
        domainError.setStatus(status.value());
        domainError.setError("Parâmetros inconsistentes");
        domainError.setMessage(e.getMessage());
        domainError.setPath(request.getRequestURI());

        return ResponseEntity.status(status).body(domainError);
    }
}
