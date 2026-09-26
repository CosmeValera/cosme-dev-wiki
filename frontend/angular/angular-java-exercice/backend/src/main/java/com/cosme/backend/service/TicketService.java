package com.cosme.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cosme.backend.exception.TicketNotFoundException;
import com.cosme.backend.model.Ticket;
import com.cosme.backend.repository.TicketRepository;

@Service 
public class TicketService {
  private final TicketRepository ticketRepository;

  public TicketService(TicketRepository ticketRepository) {
    this.ticketRepository = ticketRepository;
  }

  public List<Ticket> getAllTickets() {
    return this.ticketRepository.findAll();
  }
  
  public Ticket getTicketById(long id) {
    return this.ticketRepository.findById(id)
      .orElseThrow(() -> new TicketNotFoundException(id));
  }

  public Ticket createTicket(Ticket ticket) {
    return this.ticketRepository.save(ticket);
  }

  public Ticket updateTicket(long id, Ticket ticket) {
      Ticket existingTicket = this.ticketRepository.findById(id).orElseThrow(() -> new TicketNotFoundException(id));

      existingTicket.setTableNumber(ticket.getTableNumber());
      existingTicket.setItems(ticket.getItems());
      existingTicket.setTotal(ticket.getTotal());
      existingTicket.setPaid(ticket.isPaid());

      Ticket updatedTicket = this.ticketRepository.save(existingTicket);

      return updatedTicket;
  }
  
  public void deleteTicket(long id) {
    if (!this.ticketRepository.existsById(id)) {
      throw new TicketNotFoundException(id);
    }
    this.ticketRepository.deleteById(id);
  }
}
