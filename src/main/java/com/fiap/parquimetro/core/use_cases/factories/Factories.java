package com.fiap.parquimetro.core.use_cases.factories;

import com.fiap.parquimetro.core.domain.Ticket;
import com.fiap.parquimetro.core.use_cases.dtos.TicketDTO;

public class Factories {
    public static TicketDTO buildFrom(Ticket ticket) {
        return new TicketDTO(
            ticket.getId(), 
            ticket.getHorarioEntrada(), 
            ticket.getHorarioSaida(), 
            ticket.getStatus(), 
            ticket.getValorPago(), 
            ticket.getIdMotorista(), 
            ticket.getIdVeiculo()
        );
    }

    public static Ticket buildFrom(TicketDTO ticketDTO) {
        return new Ticket(
            ticketDTO.id(),
            ticketDTO.horarioEntrada(),
            ticketDTO.horarioSaida(),
            ticketDTO.status(),
            ticketDTO.valorPago(),
            ticketDTO.idMotorista(),
            ticketDTO.idVeiculo()
        );
    }
}
