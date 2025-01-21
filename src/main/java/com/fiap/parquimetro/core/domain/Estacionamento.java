package com.fiap.parquimetro.core.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="estacionamento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    public Estacionamento(String estacionamento, String s, int i, int i1, double v) {
    }

    @Override
    public String toString() {
        return "Estacionamento [id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", capacidadeTotal="
                + capacidadeTotal + ", vagasDisponiveis=" + vagasDisponiveis + ", valorVaga=" + valorVaga + "]";
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getCapacidadeTotal() {
        return capacidadeTotal;
    }
    public void setCapacidadeTotal(Integer capacidadeTotal) {
        this.capacidadeTotal = capacidadeTotal;
    }

    public Integer getVagasDisponiveis() {
        return vagasDisponiveis;
    }
    public void setVagasDisponiveis(Integer vagasDisponiveis) {
        this.vagasDisponiveis = vagasDisponiveis;
    }
    
    public Double getValorVaga() {
        return valorVaga;
    }
    public void setValorVaga(Double valorVaga) {
        this.valorVaga = valorVaga;
    }
}
