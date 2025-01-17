package com.fiap.parquimetro.core.use_cases.exceptions;

public class PagamentoPendenteException extends RuntimeException {
    public PagamentoPendenteException(String message) {
        super(message);
    }
}
