package com.fiap.parquimetro.core.use_cases;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.parquimetro.core.domain.Estacionamento;
import com.fiap.parquimetro.core.domain.Ticket;
import com.fiap.parquimetro.core.use_cases.dtos.TicketDTO;
import com.fiap.parquimetro.core.use_cases.events.PagamentoCompletedEvent;
import com.fiap.parquimetro.core.use_cases.exceptions.EstacionamentoNaoEncontradoException;
import com.fiap.parquimetro.core.use_cases.exceptions.TicketNaoEncontradoException;
import com.fiap.parquimetro.core.use_cases.factories.Factories;
import com.fiap.parquimetro.infrastructure.repositories.EstacionamentoRepository;
import com.fiap.parquimetro.infrastructure.repositories.TicketRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PagarEstadia {
    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    EstacionamentoRepository estacionamentoRepository;

    @Autowired
    private final CoreEventPublisher coreEventPublisher;

    public TicketDTO realizaPagamento(Long ticketId) {
        // buscar ticket na base
        Ticket ticket = ticketRepository.findById(ticketId).orElseThrow(() -> new TicketNaoEncontradoException("Ticket não encontrado"));
        
        // verificar se ticket está consistente e se já foi pago previamente
        Estacionamento estacionamento = estacionamentoRepository.findById(ticket.getEstacionamentoId()).orElseThrow(() -> new EstacionamentoNaoEncontradoException("Estacionamento não encontrado"));

        // calcular valor a ser pago
        ticket.setValorPago(estacionamento.getValorVaga() * (LocalDateTime.now().getHour() - ticket.getHorarioEntrada().getHour()));
        
        // efetivar pagamento
        ticket.setPago(true);

        // salva alteracoes na base
        ticketRepository.save(ticket);

        // sinaliza que houve o pagamento da estadia
        final var evento = new PagamentoCompletedEvent(ticket.getId());
        coreEventPublisher.publish(evento);

        return Factories.buildFrom(ticket);
    }
    
}
