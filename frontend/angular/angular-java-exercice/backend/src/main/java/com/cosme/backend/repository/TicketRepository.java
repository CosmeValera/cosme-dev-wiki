package com.cosme.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cosme.backend.model.Ticket;

//  TicketRepository.java. It's only an interface that extends JpaRepository<Ticket, Long>. No code inside: you get findAll, findById, save and deleteById for free.

public interface TicketRepository extends JpaRepository<Ticket, Long> {
  
}
