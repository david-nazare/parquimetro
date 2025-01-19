package com.fiap.parquimetro.core.use_cases.dtos;

public record EstacionamentoDTO(
    Long id,
    String nome,
    String endereco,
    Integer capacidadeTotal,
    Integer vagasDisponiveis,
    Double valorVaga
) {}
