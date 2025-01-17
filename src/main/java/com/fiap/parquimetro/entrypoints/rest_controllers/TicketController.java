package com.fiap.parquimetro.entrypoints.rest_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.parquimetro.core.domain.Ticket;
import com.fiap.parquimetro.core.use_cases.EntrarGaragem;
import com.fiap.parquimetro.core.use_cases.PagarEstadia;
import com.fiap.parquimetro.core.use_cases.SairGaragem;

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
    public ResponseEntity<Ticket> registrarEntrada(@RequestParam String placaVeiculo, @RequestParam Long estacionamentoId) {
        var ticketDTO = entrarGaragem.execute(placaVeiculo, estacionamentoId);
        return new ResponseEntity<>(ticketDTO, HttpStatus.CREATED);
    }

    @PostMapping("/pagar-estadia/{ticketId}")
    public ResponseEntity<Ticket> pagarEstadia(@PathVariable Long ticketId) {
        var ticket = pagarEstadia.execute(ticketId);
        return new ResponseEntity<>(ticket, HttpStatus.CREATED);
    }

    @PostMapping("/sair-garagem/{ticketId}")
    public ResponseEntity<Ticket> sairGaragem(@PathVariable Long ticketId) {
        var ticket = sairGaragem.execute(ticketId);
        return new ResponseEntity<>(ticket, HttpStatus.CREATED);
    }
}
