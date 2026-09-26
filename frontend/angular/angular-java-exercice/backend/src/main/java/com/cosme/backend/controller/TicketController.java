package com.cosme.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.cosme.backend.model.Ticket;
import com.cosme.backend.service.TicketService;

import jakarta.validation.Valid;

@RestController 
@RequestMapping("/api/tickets")
public class TicketController {
  private final TicketService ticketService;

  public TicketController(TicketService ticketService) {
    this.ticketService = ticketService;
  }

  @GetMapping()
  public List<Ticket> getAllTickets() {
    return this.ticketService.getAllTickets();
  }

  @GetMapping("/{id}")
  public Ticket getTicketById(@PathVariable long id) {
    return this.ticketService.getTicketById(id);
  }

  @PostMapping()
  @ResponseStatus(HttpStatus.CREATED)
  public Ticket createTicket(@Valid @RequestBody Ticket ticket) {
    return this.ticketService.createTicket(ticket);
  }

  @PutMapping("/{id}")
  public Ticket updateTicket(@PathVariable long id, @Valid @RequestBody Ticket ticket) {
    return this.ticketService.updateTicket(id, ticket);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteTicket(@PathVariable long id) {
    this.ticketService.deleteTicket(id);
  }
  
}
