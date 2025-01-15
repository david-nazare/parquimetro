package com.fiap.parquimetro.core.use_cases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.parquimetro.core.use_cases.dtos.TicketDTO;
import com.fiap.parquimetro.core.use_cases.factories.Factories;
import com.fiap.parquimetro.infrastructure.repositories.TicketRepository;

@Service
public class EntrarGaragem {

    @Autowired
    TicketRepository ticketRepository;

    public TicketDTO execute(TicketDTO dto) {
        // Transformar dto em entity
        var ticket = Factories.buildFrom(dto);

        // validar consistencia do ticket
        ticket.validar();

        // verificar se há vaga disponível
        // persistir entrada no banco
        // deduzir uma vaga do estacionamento
        // retornar dto com status atualizado
        return null;
    }
}
