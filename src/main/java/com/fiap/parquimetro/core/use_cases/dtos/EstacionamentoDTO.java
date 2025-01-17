package com.fiap.parquimetro.core.use_cases.dtos;

public record EstacionamentoDTO(
    Long id,
    String nome,
    String endereco,
    int capacidadeTotal,
    int vagasDisponiveis,
    Double valorVaga
) {}
