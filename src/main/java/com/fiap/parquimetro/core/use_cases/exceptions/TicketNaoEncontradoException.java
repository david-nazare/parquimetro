package com.fiap.parquimetro.core.use_cases.exceptions;

public class TicketNaoEncontradoException extends RuntimeException {
    public TicketNaoEncontradoException(String message) {
        super(message);
    }
}
