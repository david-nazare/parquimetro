package com.fiap.parquimetro.entrypoints.rest_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.parquimetro.core.use_cases.CadastrarEstacionamento;
import com.fiap.parquimetro.core.use_cases.dtos.EstacionamentoDTO;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estacionamento")
public class EstacionamentoController {
    @Autowired
    private CadastrarEstacionamento estacionamento;

    @PostMapping
    public ResponseEntity<EstacionamentoDTO> cadastrarEstacionamento(@RequestBody EstacionamentoDTO estacionamentoDTO) {
        estacionamentoDTO = estacionamento.cadastra(estacionamentoDTO);
        return new ResponseEntity<>(estacionamentoDTO, HttpStatus.CREATED);
    }    
}
