package com.fiap.parquimetro.core.use_cases.dtos;

import java.util.UUID;

public record TicketDTO(
    UUID id,
    String horarioEntrada,
    String horarioSaida,
    String status,
    Double valorPago,
    UUID idMotorista,
    UUID idVeiculo
) {}
