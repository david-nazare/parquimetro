package com.fiap.parquimetro.core.use_cases.events;

import java.time.Instant;

import com.fiap.parquimetro.core.use_cases.CoreEvent;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PagamentoCompletedEvent implements CoreEvent {
    private final Long ticketId;
    private Instant ocorridoEm;

    public PagamentoCompletedEvent(final Long ticketId) {
        this.ticketId = ticketId;
        this.ocorridoEm = Instant.now();
    }
}
