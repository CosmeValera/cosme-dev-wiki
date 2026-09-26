import { Component, inject, signal } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { TicketService } from './ticket-service';
import { Ticket } from './types.model';

@Component({
  selector: 'app-root',
  imports: [ReactiveFormsModule],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  private ticketService = inject(TicketService);
  private fb = inject(FormBuilder);

  tickets = signal<Ticket[]>([]);

  form = this.fb.nonNullable.group({
    tableNumber: [1, [Validators.required, Validators.min(1)]],
    items: ['', Validators.required],
    total: [0, [Validators.required, Validators.min(0)]],
  });

  constructor() {
    this.ticketService.getAllTickets().subscribe(t => this.tickets.set(t));
  }

  createTicket() {
    if (this.form.invalid) return;

    const newTicket = { ...this.form.getRawValue(), paid: false };
    this.ticketService.createTicket(newTicket).subscribe(created => {
      this.tickets.update(list => [...list, created]);
      this.form.reset();
    });
  }

  markPaid(ticket: Ticket) {
    const { id, ...rest } = ticket;
    this.ticketService.updateTicket(id, { ...rest, paid: true }).subscribe(updated =>
      this.tickets.update(list => list.map(t => (t.id === updated.id ? updated : t)))
    );
  }

  deleteTicket(id: number) {
    this.ticketService.deleteTicket(id).subscribe(() =>
      this.tickets.update(list => list.filter(t => t.id !== id))
    );
  }
}