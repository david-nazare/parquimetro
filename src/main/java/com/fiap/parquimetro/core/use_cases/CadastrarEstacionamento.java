package com.fiap.parquimetro.core.use_cases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.parquimetro.core.use_cases.dtos.EstacionamentoDTO;
import com.fiap.parquimetro.core.use_cases.factories.Factories;
import com.fiap.parquimetro.infrastructure.repositories.EstacionamentoRepository;

@Service
public class CadastrarEstacionamento {
    @Autowired
    EstacionamentoRepository estacionamentoRepository;

    public EstacionamentoDTO cadastra(EstacionamentoDTO dto) {
        var estacionamento = Factories.buildFrom(dto);
        estacionamentoRepository.save(estacionamento);
        return Factories.buildFrom(estacionamento);
    }
}
