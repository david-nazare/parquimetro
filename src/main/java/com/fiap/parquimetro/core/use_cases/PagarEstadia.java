package com.fiap.parquimetro.core.use_cases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.parquimetro.core.domain.Ticket;
import com.fiap.parquimetro.core.use_cases.exceptions.TicketNaoEncontradoException;
import com.fiap.parquimetro.infrastructure.repositories.TicketRepository;

@Service
public class PagarEstadia {
    @Autowired
    TicketRepository ticketRepository;

    public Ticket execute(Long ticketId) {
        // buscar ticket na base
        Ticket ticket = ticketRepository.findById(ticketId).orElseThrow(() -> new TicketNaoEncontradoException("Ticket not found"));
        
        // verificar se ticket está consistente e se já foi pago previamente
        // calcular valor a ser pago
        
        // efetivar pagamento
        ticket.setPago(true);
        // retornar dto atualizado
        return ticketRepository.save(ticket);
    }
    
}
