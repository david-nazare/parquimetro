package com.fiap.parquimetro.core.use_cases;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.parquimetro.core.domain.Ticket;
import com.fiap.parquimetro.core.use_cases.exceptions.PagamentoPendenteException;
import com.fiap.parquimetro.core.use_cases.exceptions.TicketNaoEncontradoException;
import com.fiap.parquimetro.infrastructure.repositories.TicketRepository;

@Service
public class SairGaragem {
    @Autowired
    TicketRepository ticketRepository;

    public Ticket execute(Long ticketId) {
        // Tentar encontrar ticket na base
        Ticket ticket = ticketRepository.findById(ticketId).orElseThrow(() -> new TicketNaoEncontradoException("Ticket not found"));
        // verificar se ticket foi pago
        if (!ticket.isPago()) {
            throw new PagamentoPendenteException("Pagamento pendente");
        }
        // persistir saida no banco
        ticket.setHorarioSaida(LocalDateTime.now());
        // liberar uma vaga do estacionamento
        // retornar dto com status atualizado
        return ticketRepository.save(ticket);
    }
}
