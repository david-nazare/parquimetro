package com.fiap.parquimetro.core.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="estacionamento")
public class Estacionamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nome")
    private String nome;
    
    @Column(name="endereco")
    private String endereco;
    
    @Column(name="capacidade_total")
    private int capacidadeTotal;
    
    @Column(name="vagas_disponiveis")
    private int vagasDisponiveis;
    
    @Column(name="valor_vaga")
    private Double valorVaga;

    public Estacionamento() {
    }

    public Estacionamento(Long id, String nome, String endereco, int capacidadeTotal, int vagasDisponiveis, Double valorVaga) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.capacidadeTotal = capacidadeTotal;
        this.vagasDisponiveis = vagasDisponiveis;
        this.valorVaga = valorVaga;
    }

    public Estacionamento(String nome, String endereco, int capacidadeTotal, int vagasDisponiveis, Double valorVaga) {
        this.nome = nome;
        this.endereco = endereco;
        this.capacidadeTotal = capacidadeTotal;
        this.vagasDisponiveis = vagasDisponiveis;
        this.valorVaga = valorVaga;
    }

    public Long getId() {
        return id;
    }

    public Estacionamento setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Estacionamento setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getEndereco() {
        return endereco;
    }

    public Estacionamento setEndereco(String endereco) {
        this.endereco = endereco;
        return this;
    }

    public int getCapacidadeTotal() {
        return capacidadeTotal;
    }

    public Estacionamento setCapacidadeTotal(int capacidadeTotal) {
        this.capacidadeTotal = capacidadeTotal;
        return this;
    }

    public int getVagasDisponiveis() {
        return vagasDisponiveis;
    }

    public Estacionamento setVagasDisponiveis(int vagasDisponiveis) {
        this.vagasDisponiveis = vagasDisponiveis;
        return this;
    }

    public Double getValorVaga() {
        return valorVaga;
    }

    public Estacionamento setValorVaga(Double valorVaga) {
        this.valorVaga = valorVaga;
        return this;
    }

    @Override
    public String toString() {
        return "Estacionamento [id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", capacidadeTotal="
                + capacidadeTotal + ", vagasDisponiveis=" + vagasDisponiveis + ", valorVaga=" + valorVaga + "]";
    }
}
