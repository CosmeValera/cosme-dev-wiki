import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';

export interface Greeting { message: string; }

@Injectable({ providedIn: 'root' })
export class HelloService {
  private http = inject(HttpClient);
  getSaludo(name: string, edad: number) {
    return this.http.get<Greeting>(`/api/saludo/${name}/${edad}`);
  }
}