package com.fiap.parquimetro.entrypoints.rest_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.parquimetro.core.use_cases.CadastrarEstacionamento;
import com.fiap.parquimetro.core.use_cases.dtos.EstacionamentoDTO;

@RestController
@RequestMapping("/api/estacionamento")
public class EstacionamentoController {
    @Autowired
    private CadastrarEstacionamento cadastrarEstacionamento;

    @PostMapping("/cadastrar")
    public EstacionamentoDTO cadastrarEstacionamento(@RequestParam String nome, @RequestParam String endereco, @RequestParam int capacidadeTotal, @RequestParam Double valorVaga) {
        var dto = new EstacionamentoDTO(
            null, 
            nome, 
            endereco, 
            capacidadeTotal, 
            capacidadeTotal, 
            valorVaga
        );

        return cadastrarEstacionamento.cadastra(dto);
    }    
}
