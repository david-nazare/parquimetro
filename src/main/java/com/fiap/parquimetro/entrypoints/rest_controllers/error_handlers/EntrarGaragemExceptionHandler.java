package com.fiap.parquimetro.entrypoints.rest_controllers.error_handlers;

import com.fiap.parquimetro.core.use_cases.exceptions.EntrarGaragemException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class EntrarGaragemExceptionHandler {
    private final EntrarGaragemError entrarGaragemError = new EntrarGaragemError();

    @ExceptionHandler(EntrarGaragemException.class)
    public ResponseEntity<EntrarGaragemError> trataErroLowLevel(EntrarGaragemException e, HttpServletRequest request) {
        var status = HttpStatus.BAD_REQUEST;

        entrarGaragemError.setTimestamp(Instant.now());
        entrarGaragemError.setStatus(status.value());
        entrarGaragemError.setError("Parâmetros inconsistentes");
        entrarGaragemError.setMessage(e.getMessage());
        entrarGaragemError.setPath(request.getRequestURI());

        return ResponseEntity.status(status).body(entrarGaragemError);
    }
}

