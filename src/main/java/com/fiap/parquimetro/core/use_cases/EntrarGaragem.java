package com.fiap.parquimetro.core.use_cases;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.parquimetro.core.domain.Ticket;
import com.fiap.parquimetro.infrastructure.repositories.TicketRepository;

@Service
public class EntrarGaragem {

    @Autowired
    TicketRepository ticketRepository;

    public Ticket execute(String placaVeiculo) {
        var ticket = new Ticket();

        ticket.setPlacaVeiculo(placaVeiculo);
        ticket.setHorarioEntrada(LocalDateTime.now());
        ticket.setPago(false);
        
        // validar consistencia do ticket
        ticket.valida();

        // verificar se há vaga disponível
        // deduzir uma vaga do estacionamento
        
        // persistir entrada no banco
        return ticketRepository.save(ticket);
    }
}
