package com.fiap.parquimetro.core.use_cases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.parquimetro.core.use_cases.dtos.TicketDTO;
import com.fiap.parquimetro.infrastructure.repositories.TicketRepository;

@Service
public class SairGaragem {
    @Autowired
    TicketRepository ticketRepository;

    public TicketDTO execute(TicketDTO dto) {
        // Transformar dto em entity
        // Tentar encontrar ticket na base, com status valido
        // verificar se ticket foi pago
        // persistir saida no banco
        // liberar uma vaga do estacionamento
        // retornar dto com status atualizado

        return null;
    }
}
