package com.fiap.parquimetro.core.use_cases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fiap.parquimetro.core.use_cases.dtos.TicketDTO;
import com.fiap.parquimetro.infrastructure.repositories.TicketRepository;

@Service
public class PagarEstadia {
    @Autowired
    TicketRepository ticketRepository;

    public TicketDTO execute(TicketDTO dto) {
        // transformar dto em entity
        // buscar ticket na base
        // verificar se ticket está consistente e se já foi pago previamente
        // calcular valor a ser pago
        // efetivar pagamento
        // retornar dto atualizado
        return null;
    }
    
}
