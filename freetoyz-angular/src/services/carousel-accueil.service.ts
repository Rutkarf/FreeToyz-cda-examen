import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CarouselService {
  private apiUrl = 'http://localhost:9000/freetoyz/toys'; // Remplace avec l'URL de ton backend

  constructor(private http: HttpClient) {}

  getCarouselToys(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }
}