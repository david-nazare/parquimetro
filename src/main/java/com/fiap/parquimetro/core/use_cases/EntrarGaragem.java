package com.fiap.parquimetro.core.use_cases;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.parquimetro.core.domain.Estacionamento;
import com.fiap.parquimetro.core.domain.Ticket;
import com.fiap.parquimetro.core.use_cases.exceptions.EstacionamentoNaoEncontradoException;
import com.fiap.parquimetro.core.use_cases.exceptions.PagamentoPendenteException;
import com.fiap.parquimetro.core.use_cases.exceptions.TicketNaoEncontradoException;
import com.fiap.parquimetro.core.use_cases.exceptions.VagaIndisponivelException;
import com.fiap.parquimetro.infrastructure.repositories.EstacionamentoRepository;
import com.fiap.parquimetro.infrastructure.repositories.TicketRepository;

@Service
public class EntrarGaragem {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    EstacionamentoRepository estacionamentoRepository;

    public Ticket execute(String placaVeiculo, Long estacionamentoId) {
        // verificar se há vaga disponível
        Estacionamento estacionamento = estacionamentoRepository.findById(estacionamentoId).orElseThrow(() -> new EstacionamentoNaoEncontradoException("Estacionamento não encontrado"));

        if (estacionamento.getVagasDisponiveis() == 0) {
            throw new VagaIndisponivelException("Não há vagas disponíveis neste estacionamento");
        }

        var ticket = new Ticket();

        ticket.setPlacaVeiculo(placaVeiculo);
        ticket.setHorarioEntrada(LocalDateTime.now());
        ticket.setEstacionamentoId(estacionamento.getId());
        ticket.setPago(false);

        // deduzir uma vaga do estacionamento
        estacionamento.setVagasDisponiveis(estacionamento.getVagasDisponiveis() - 1);
        estacionamentoRepository.save(estacionamento);

        // persistir entrada no banco
        return ticketRepository.save(ticket);
    }
}
