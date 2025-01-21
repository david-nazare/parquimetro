package com.fiap.parquimetro.entrypoints.rest_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.parquimetro.core.use_cases.EntrarGaragem;
import com.fiap.parquimetro.core.use_cases.PagarEstadia;
import com.fiap.parquimetro.core.use_cases.SairGaragem;
import com.fiap.parquimetro.core.use_cases.dtos.TicketDTO;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    EntrarGaragem entrarGaragem;

    @Autowired
    SairGaragem sairGaragem;

    @Autowired
    PagarEstadia pagarEstadia;

    @PostMapping
    public ResponseEntity<TicketDTO> registrarEntrada(@RequestBody TicketDTO ticketDTO) {
        ticketDTO = entrarGaragem.registraEntrada(ticketDTO);
        return new ResponseEntity<>(ticketDTO, HttpStatus.CREATED);
    }

    @PutMapping("/pagar/{ticketId}")
    public ResponseEntity<TicketDTO> pagarEstadia(@PathVariable Long ticketId) {
        TicketDTO ticketDTO = pagarEstadia.realizaPagamento(ticketId);
        return new ResponseEntity<>(ticketDTO, HttpStatus.OK);
    }

    @PutMapping("/sair/{ticketId}")
    public ResponseEntity<TicketDTO> sairGaragem(@PathVariable Long ticketId) {
        TicketDTO ticketDTO = sairGaragem.registraSaida(ticketId);
        return new ResponseEntity<>(ticketDTO, HttpStatus.OK);
    }
}
