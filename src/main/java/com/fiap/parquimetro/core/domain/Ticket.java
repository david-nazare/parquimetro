package com.fiap.parquimetro.core.domain;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="ticket")
public class Ticket {
    @Id
    private UUID id;
    private Date horarioEntrada;
    private Date horarioSaida;
    private String status;
    private Double valorPago;
    private UUID idMotorista;
    private UUID idVeiculo;

    public void validar() {
        
    }
}
