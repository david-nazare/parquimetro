package com.fiap.parquimetro.core.use_cases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.parquimetro.core.domain.Estacionamento;
import com.fiap.parquimetro.infrastructure.repositories.EstacionamentoRepository;

@Service
public class CadastrarEstacionamento {
    @Autowired
    EstacionamentoRepository estacionamentoRepository;

    public Estacionamento cadastra(String nome, String endereco, int capacidadeTotal, Double valorVaga) {
        Estacionamento estacionamento = new Estacionamento();
        estacionamento.setNome(nome);
        estacionamento.setEndereco(endereco);
        estacionamento.setCapacidadeTotal(capacidadeTotal);
        estacionamento.setVagasDisponiveis(capacidadeTotal);
        estacionamento.setValorVaga(valorVaga);
        return estacionamentoRepository.save(estacionamento);
    }
}
