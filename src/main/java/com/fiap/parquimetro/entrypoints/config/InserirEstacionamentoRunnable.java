package com.fiap.parquimetro.entrypoints.config;

import com.fiap.parquimetro.core.domain.Estacionamento;
import com.fiap.parquimetro.infrastructure.repositories.EstacionamentoRepository;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class InserirEstacionamentoRunnable implements Runnable {

    @Autowired
    EstacionamentoRepository estacionamentoRepository;

    Estacionamento estacionamento1 = new Estacionamento("Parquimetro Barueri", "Rua A, 123", 40, 40, 14.5);
    Estacionamento estacionamento2 = new Estacionamento("Parquimetro Parana", "Rua Parana, 280", 50, 50, 12.0);

    @Override
    public void run() {
        estacionamentoRepository.save(estacionamento1);
        estacionamentoRepository.save(estacionamento2);
        log.info("Estacionamentos cadastrados com sucesso");
    }
}
