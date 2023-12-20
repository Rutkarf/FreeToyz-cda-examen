// authentication.service.ts

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { NgForm } from '@angular/forms';
import { Token } from '@angular/compiler';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private baseUrl = 'http://localhost:9000';

  constructor(private http: HttpClient) {}

  register(form: NgForm): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/register`, form.value);
  }

  authenticate(username: string, password: string): boolean {
    // Vérifie si les informations d'identification sont valides
    let b=false;
    var x = this.http.post<any>(`${this.baseUrl}/authorize`, { username, password }).subscribe((
      value)=> {
        if (value) {
          sessionStorage.setItem('isAuthenticated', 'true');
          sessionStorage.setItem('username', value.user.username);
          sessionStorage.setItem('token', value.token);
          b=true;
        }
      });
    return x!=null;
  }

  isAuthenticated(): boolean {
    return  sessionStorage.getItem('isAuthenticated') === 'true';
  }

  getUserName(): string {
  return sessionStorage.getItem('username') as string;
    
  }

  logout(): Observable<void> {
    // Ajoute ici les appels nécessaires pour déconnecter côté serveur si besoin
    // Exemple : this.http.post<void>(`${this.baseUrl}/logout`, null);
    

    sessionStorage.removeItem('isAuthenticated');
    sessionStorage.removeItem('username');
    sessionStorage.removeItem('token');

    return new Observable(observer => observer.complete());
  }
}