package com.fiap.parquimetro.entrypoints.rest_controllers.error_handlers;

import com.fiap.parquimetro.core.use_cases.exceptions.LowLevelException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class LowLevelExceptionHandler {
    private final LowLevelError lowLevelError = new LowLevelError();

    @ExceptionHandler(LowLevelException.class)
    public ResponseEntity<LowLevelError> trataErroLowLevel(LowLevelException e, HttpServletRequest request) {
        var status = HttpStatus.BAD_REQUEST;

        lowLevelError.setTimestamp(Instant.now());
        lowLevelError.setStatus(status.value());
        lowLevelError.setError("Parâmetros inconsistentes");
        lowLevelError.setMessage(e.getMessage());
        lowLevelError.setPath(request.getRequestURI());

        return ResponseEntity.status(status).body(lowLevelError);
    }
}

