package com.fiap.parquimetro.infrastructure.repositories;

import com.fiap.parquimetro.core.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    
}
