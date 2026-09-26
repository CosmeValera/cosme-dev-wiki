export type Ticket = {
  id: number;
  tableNumber: number;
  items: string;
  total: number;
  paid: boolean;
}

export type NewTicket = Omit<Ticket, 'id'>;