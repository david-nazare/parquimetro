package com.fiap.parquimetro.core.use_cases.dtos;

import java.util.Date;
import java.util.UUID;

public record TicketDTO(
    UUID id,
    Date horarioEntrada,
    Date horarioSaida,
    String status,
    Double valorPago,
    UUID idMotorista,
    UUID idVeiculo
) {}
