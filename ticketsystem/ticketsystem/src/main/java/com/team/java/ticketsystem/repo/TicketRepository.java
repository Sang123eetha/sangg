package com.team.java.ticketsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team.java.ticketsystem.entity.Ticket;
@Repository
public interface TicketRepository extends JpaRepository<Ticket,Integer>{

}
