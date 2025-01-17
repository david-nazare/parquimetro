package com.fiap.parquimetro.core.use_cases.exceptions;

public class VagaIndisponivelException extends RuntimeException {
    public VagaIndisponivelException(String message) {
        super(message);
    }
}
