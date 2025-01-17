package com.fiap.parquimetro.core.use_cases.dtos;

import java.time.LocalDateTime;

public record TicketDTO(
    Long id,
    String placaVeiculo,
    LocalDateTime horarioEntrada,
    LocalDateTime horarioSaida,
    boolean pago,
    Long estacionamentoId,
    Double valorPago
) {}
