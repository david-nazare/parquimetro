package com.fiap.parquimetro.entrypoints.config;

import com.fiap.parquimetro.core.domain.Estacionamento;
import com.fiap.parquimetro.infrastructure.repositories.EstacionamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InserirEstacionamentoRunnable implements Runnable {

    @Autowired
    EstacionamentoRepository estacionamentoRepository;

    Estacionamento estacionamento1 = new Estacionamento("Estacionamento A", "Rua A, 123", 100, 80, 15.50);
    Estacionamento estacionamento2 = new Estacionamento("Estacionamento B", "Rua B, 456", 150, 100, 12.00);
    Estacionamento estacionamento3 = new Estacionamento("Estacionamento C", "Rua C, 789", 200, 150, 10.00);
    Estacionamento estacionamento4 = new Estacionamento("Estacionamento D", "Rua D, 101", 120, 90, 13.75);
    Estacionamento estacionamento5 = new Estacionamento("Estacionamento E", "Rua E, 202", 250, 200, 8.50);
    Estacionamento estacionamento6 = new Estacionamento("Estacionamento F", "Rua F, 303", 180, 130, 9.25);

    @Override
    public void run() {
        estacionamentoRepository.save(estacionamento1);
        estacionamentoRepository.save(estacionamento2);
        estacionamentoRepository.save(estacionamento3);
        estacionamentoRepository.save(estacionamento4);
        estacionamentoRepository.save(estacionamento5);
        estacionamentoRepository.save(estacionamento6);
        System.out.println("Estacionamentos inseridos");
    }
}
