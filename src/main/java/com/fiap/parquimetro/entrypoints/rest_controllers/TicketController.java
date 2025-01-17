package com.fiap.parquimetro.entrypoints.rest_controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.parquimetro.core.use_cases.EntrarGaragem;
import com.fiap.parquimetro.core.use_cases.PagarEstadia;
import com.fiap.parquimetro.core.use_cases.SairGaragem;
import com.fiap.parquimetro.core.use_cases.dtos.TicketDTO;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {
    @Autowired
    EntrarGaragem entrarGaragem;

    @Autowired
    SairGaragem sairGaragem;

    @Autowired
    PagarEstadia pagarEstadia;

    @PostMapping("/entrar-garagem")
    public ResponseEntity<TicketDTO> registrarEntrada(@RequestParam String placaVeiculo, @RequestParam Long estacionamentoId) {
        var dto = new TicketDTO(
            null, 
            placaVeiculo, 
            LocalDateTime.now(), 
            null, 
            false, 
            estacionamentoId, 
            null
        );

        TicketDTO ticketDTO = entrarGaragem.registraEntrada(dto);
        return new ResponseEntity<>(ticketDTO, HttpStatus.CREATED);
    }

    @PostMapping("/pagar-estadia/{ticketId}")
    public ResponseEntity<TicketDTO> pagarEstadia(@PathVariable Long ticketId) {
        TicketDTO ticketDTO = pagarEstadia.realizaPagamento(ticketId);
        return new ResponseEntity<>(ticketDTO, HttpStatus.CREATED);
    }

    @PostMapping("/sair-garagem/{ticketId}")
    public ResponseEntity<TicketDTO> sairGaragem(@PathVariable Long ticketId) {
        TicketDTO ticketDTO = sairGaragem.registraSaida(ticketId);
        return new ResponseEntity<>(ticketDTO, HttpStatus.CREATED);
    }
}
