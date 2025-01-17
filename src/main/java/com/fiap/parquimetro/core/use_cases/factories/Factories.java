package com.fiap.parquimetro.core.use_cases.factories;

import com.fiap.parquimetro.core.domain.Estacionamento;
import com.fiap.parquimetro.core.domain.Ticket;
import com.fiap.parquimetro.core.use_cases.dtos.EstacionamentoDTO;
import com.fiap.parquimetro.core.use_cases.dtos.TicketDTO;

public class Factories {
    public static Ticket buildFrom(TicketDTO dto) {
        return new Ticket(
            dto.id(),
            dto.placaVeiculo(),
            dto.horarioEntrada(),
            dto.horarioSaida(),
            dto.pago(),
            dto.estacionamentoId(),
            dto.valorPago()
        );
    }

    public static TicketDTO buildFrom(Ticket ticket) {
        return new TicketDTO(
            ticket.getId(), 
            ticket.getPlacaVeiculo(), 
            ticket.getHorarioEntrada(), 
            ticket.getHorarioSaida(), 
            ticket.isPago(), 
            ticket.getEstacionamentoId(), 
            ticket.getValorPago()
        );
    }

    public static Estacionamento buildFrom(EstacionamentoDTO dto) {
        return new Estacionamento(
            dto.id(), 
            dto.nome(), 
            dto.endereco(), 
            dto.capacidadeTotal(), 
            dto.vagasDisponiveis(), 
            dto.valorVaga()
        );
    }

    public static EstacionamentoDTO buildFrom(Estacionamento estacionamento) {
        return new EstacionamentoDTO(
            estacionamento.getId(), 
            estacionamento.getNome(), 
            estacionamento.getEndereco(), 
            estacionamento.getCapacidadeTotal(), 
            estacionamento.getVagasDisponiveis(), 
            estacionamento.getValorVaga()
        );
    }
}
