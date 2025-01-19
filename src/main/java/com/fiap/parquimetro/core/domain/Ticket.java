package com.fiap.parquimetro.core.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="placa_veiculo")
    private String placaVeiculo;
    
    @Column(name="horario_entrada")
    private LocalDateTime horarioEntrada;

    @Column(name="horario_saida")
    private LocalDateTime horarioSaida;

    @Column(name="pago")
    private Boolean pago;

    @Column(name="estacionamento_id")
    private Long estacionamentoId;

    @Column(name="valor_pago")
    private Double valorPago;

    public Ticket() {
    }

    public Ticket(Long id, String placaVeiculo, LocalDateTime horarioEntrada, LocalDateTime horarioSaida, Boolean pago,
            Long estacionamentoId, Double valorPago) {
        this.id = id;
        this.placaVeiculo = placaVeiculo;
        this.horarioEntrada = horarioEntrada;
        this.horarioSaida = horarioSaida;
        this.pago = pago;
        this.estacionamentoId = estacionamentoId;
        this.valorPago = valorPago;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public LocalDateTime getHorarioEntrada() {
        return horarioEntrada;
    }

    public void setHorarioEntrada(LocalDateTime horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    public LocalDateTime getHorarioSaida() {
        return horarioSaida;
    }

    public void setHorarioSaida(LocalDateTime horarioSaida) {
        this.horarioSaida = horarioSaida;
    }

    public Boolean isPago() {
        return pago;
    }

    public void setPago(Boolean pago) {
        this.pago = pago;
    }

    public Long getEstacionamentoId() {
        return estacionamentoId;
    }

    public void setEstacionamentoId(Long estacionamentoId) {
        this.estacionamentoId = estacionamentoId;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    @Override
    public String toString() {
        return "Ticket [id=" + id + ", placaVeiculo=" + placaVeiculo + ", horarioEntrada=" + horarioEntrada
                + ", horarioSaida=" + horarioSaida + ", pago=" + pago + ", estacionamentoId=" + estacionamentoId
                + ", valorPago=" + valorPago + "]";
    }
}
