package com.fiap.parquimetro.core.use_cases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.parquimetro.core.domain.Estacionamento;
import com.fiap.parquimetro.core.use_cases.dtos.TicketDTO;
import com.fiap.parquimetro.core.use_cases.exceptions.EstacionamentoNaoEncontradoException;
import com.fiap.parquimetro.core.use_cases.exceptions.VagaIndisponivelException;
import com.fiap.parquimetro.core.use_cases.factories.Factories;
import com.fiap.parquimetro.infrastructure.repositories.EstacionamentoRepository;
import com.fiap.parquimetro.infrastructure.repositories.TicketRepository;

@Service
public class EntrarGaragem {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    EstacionamentoRepository estacionamentoRepository;

    public TicketDTO registraEntrada(TicketDTO dto) {
        // verificar se há vaga disponível
        Estacionamento estacionamento = estacionamentoRepository.findById(dto.estacionamentoId()).orElseThrow(() -> new EstacionamentoNaoEncontradoException("Estacionamento não encontrado"));

        if (estacionamento.getVagasDisponiveis() == 0) {
            throw new VagaIndisponivelException("Não há vagas disponíveis neste estacionamento");
        }

        var ticket = Factories.buildFrom(dto);


        // deduzir uma vaga do estacionamento
        estacionamento.setVagasDisponiveis(estacionamento.getVagasDisponiveis() - 1);
        estacionamentoRepository.save(estacionamento);

        // persistir entrada no banco
        ticketRepository.save(ticket);

        return Factories.buildFrom(ticket);
    }
}
