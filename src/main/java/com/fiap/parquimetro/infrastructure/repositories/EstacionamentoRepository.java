package com.fiap.parquimetro.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fiap.parquimetro.core.domain.Estacionamento;

@Repository
public interface EstacionamentoRepository extends JpaRepository<Estacionamento, Long> {
    
}
