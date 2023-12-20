// toy.service.ts
import { BehaviorSubject, Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Toy } from 'src/app/interfaces/toy.interface';



@Injectable({
  providedIn: 'root',
})
export class ToyService {
  private baseUrl = 'http://localhost:9000/freetoyz/toys'; // Assure-toi que l'URL est correcte

  private toysSubject: BehaviorSubject<any[]> = new BehaviorSubject<any[]>([]);
  toys$: Observable<any[]> = this.toysSubject.asObservable();

  constructor(private http: HttpClient) {}


  getAllToys(): Observable<Toy[]> {
    const getAllUrl = `${this.baseUrl}`;
    return this.http.get<Toy[]>(getAllUrl);
  }

  getToysByCategory(category: string): Observable<any> {
    const categoryUrl = `${this.baseUrl}/category/${category}`;
    return this.http.get(categoryUrl);
  }

 getToyById(id: number): Observable<any> {
    const getByIdUrl = `${this.baseUrl}/${id}`;
    return this.http.get(getByIdUrl);
  }

  findByIdLast(): Observable<any> {
    const findByIdLastUrl = `${this.baseUrl}/last`;
    return this.http.get<any>(findByIdLastUrl);
  }

  submitToy(toy: Toy): Observable<any> {
    const submitUrl = `${this.baseUrl}/submit`;
    return this.http.post(submitUrl, toy);
  }

  updateToys() {
    this.http.get<any[]>(`${this.baseUrl}`).subscribe((toys: any[]) => {
      this.toysSubject.next(toys);
    });
  }

  deleteToy(id: number): Observable<any> {
    const deleteUrl = `${this.baseUrl}/${id}`;
    return this.http.delete(deleteUrl);
  }

 


  }


