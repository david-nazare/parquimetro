package com.fiap.parquimetro.entrypoints.rest_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.parquimetro.core.use_cases.SairGaragem;
import com.fiap.parquimetro.core.use_cases.dtos.TicketDTO;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/saida")
public class SairGaragemController {
    @Autowired
    SairGaragem sairGaragem;

    @PostMapping
    public ResponseEntity<TicketDTO> sairGaragem(@RequestBody TicketDTO ticketDTO) {
        ticketDTO = sairGaragem.execute(ticketDTO);
        return new ResponseEntity<>(ticketDTO, HttpStatus.CREATED);
    }
}
