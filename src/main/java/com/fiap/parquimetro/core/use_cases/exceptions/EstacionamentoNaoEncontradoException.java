package com.fiap.parquimetro.core.use_cases.exceptions;

public class EstacionamentoNaoEncontradoException extends RuntimeException {
    public EstacionamentoNaoEncontradoException(String message) {
        super(message);
    }
}
