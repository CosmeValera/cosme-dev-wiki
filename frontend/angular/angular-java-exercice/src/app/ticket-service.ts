import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { NewTicket, Ticket } from './types.model';

@Injectable({
  providedIn: 'root',
})
export class TicketService {
  private http = inject(HttpClient);

  getAllTickets() {
    return this.http.get<Ticket[]>(`/api/tickets`);
  }
  getTicketById(id: number) {
    return this.http.get<Ticket>(`/api/tickets/${id}`);
  }
  createTicket(ticket: NewTicket) {
    return this.http.post<Ticket>(`/api/tickets`, ticket);
  }
  updateTicket(id: number, ticket: NewTicket) {
    return this.http.put<Ticket>(`/api/tickets/${id}`, ticket);
  }
  deleteTicket(id: number) {
    return this.http.delete<void>(`/api/tickets/${id}`);
  }
}
