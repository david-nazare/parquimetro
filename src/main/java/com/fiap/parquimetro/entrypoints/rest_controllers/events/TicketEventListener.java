package com.fiap.parquimetro.entrypoints.rest_controllers.events;

import org.springframework.context.event.EventListener;

import com.fiap.parquimetro.core.use_cases.events.EntradaGaragemCompletedEvent;
import com.fiap.parquimetro.core.use_cases.events.PagamentoCompletedEvent;
import com.fiap.parquimetro.core.use_cases.events.SaidaGaragemCompletedEvent;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TicketEventListener {
    @EventListener
    public void onEntradaGaragem(final EntradaGaragemCompletedEvent evento) {
        log.info("Entrada do ticket {} registrada em {}", evento.getTicketId(), evento.getOcorridoEm());
    }

    @EventListener
    public void onPagamento(final PagamentoCompletedEvent evento) {
        log.info("Pagamento do ticket {} registrado em {}", evento.getTicketId(), evento.getOcorridoEm());
    }

    @EventListener
    public void onSaidaGaragem(final SaidaGaragemCompletedEvent evento) {
        log.info("Saida do ticket {} registrada em {}", evento.getTicketId(), evento.getOcorridoEm());
    }
}
