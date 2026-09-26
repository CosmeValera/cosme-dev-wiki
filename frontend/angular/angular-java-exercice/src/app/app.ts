import { Component, inject, signal } from '@angular/core';
import { TicketService } from './ticket-service';
import { Ticket } from './types.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  private ticketService = inject(TicketService);
  tickets = signal<Ticket[]>([]);

  constructor() {
    this.ticketService.getAllTickets().subscribe(t => this.tickets.set(t));
  }

  deleteTicket(id: number) {
    this.ticketService.deleteTicket(id).subscribe(() =>
      this.tickets.update(list => list.filter(t => t.id !== id))
    );
  }
}