package com.fiap.parquimetro.core.use_cases;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.parquimetro.core.domain.Estacionamento;
import com.fiap.parquimetro.core.domain.Ticket;
import com.fiap.parquimetro.core.use_cases.exceptions.EstacionamentoNaoEncontradoException;
import com.fiap.parquimetro.core.use_cases.exceptions.PagamentoPendenteException;
import com.fiap.parquimetro.core.use_cases.exceptions.TicketNaoEncontradoException;
import com.fiap.parquimetro.infrastructure.repositories.EstacionamentoRepository;
import com.fiap.parquimetro.infrastructure.repositories.TicketRepository;

@Service
public class SairGaragem {
    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    EstacionamentoRepository estacionamentoRepository;

    public Ticket execute(Long ticketId) {
        // Tentar encontrar ticket na base
        Ticket ticket = ticketRepository.findById(ticketId).orElseThrow(() -> new EstacionamentoNaoEncontradoException("Estacionamento não encontrado"));

        // verificar se ticket foi pago
        if (!ticket.isPago()) {
            throw new PagamentoPendenteException("Pagamento pendente");
        }

        // liberar uma vaga do estacionamento
        Estacionamento estacionamento = estacionamentoRepository.findById(ticket.getEstacionamentoId()).orElseThrow(() -> new TicketNaoEncontradoException("Ticket não encontrado"));

        estacionamento.setVagasDisponiveis(estacionamento.getVagasDisponiveis() + 1);
        estacionamentoRepository.save(estacionamento);

        ticket.setHorarioSaida(LocalDateTime.now());

        // persistir saida no banco e retornar ticket com status atualizado
        return ticketRepository.save(ticket);
    }
}
