package com.fiap.parquimetro.entrypoints.rest_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.parquimetro.core.use_cases.EntrarGaragem;
import com.fiap.parquimetro.core.use_cases.dtos.TicketDTO;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/entrada")
public class EntrarGaragemController {
    @Autowired
    EntrarGaragem entrarGaragem;

    @PostMapping
    public ResponseEntity<TicketDTO> registrarEntrada(@RequestBody TicketDTO ticketDTO) {
        ticketDTO = entrarGaragem.execute(ticketDTO);
        return new ResponseEntity<>(ticketDTO, HttpStatus.CREATED);
    }
}
