// toy.service.ts
import { BehaviorSubject, Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Toy } from 'src/app/interfaces/toy.interface';
import { tap } from 'rxjs/operators';


@Injectable({
  providedIn: 'root',
})
export class ToyService {
  private baseUrl = 'http://localhost:9000/freetoyz/toys'; // Assure-toi que l'URL est correcte

  constructor(private http: HttpClient) {}

  private toysSubject: BehaviorSubject<any[]> = new BehaviorSubject<any[]>([]);
  toys$: Observable<any[]> = this.toysSubject.asObservable();


  getAllToys = (): Observable<Toy[]> =>  {
    return this.http.get<Toy[]>(this.baseUrl);
  }

  getToysByCategory = (category: string): Observable<Toy[]> => {
    const categoryUrl = `${this.baseUrl}/categories/${category}`;
    console.log("categoryUrl",categoryUrl);
    return this.http.get<Toy[]>(categoryUrl);
  }

 getToyById(id: number): Observable<any> {
    const getByIdUrl = `${this.baseUrl}/${id}`;
    return this.http.get(getByIdUrl);
  }

  findByIdLast(): Observable<any> {
    const findByIdLastUrl = `${this.baseUrl}/last`;
    return this.http.get<any>(findByIdLastUrl);
  }

  submitToy(toy: any): Observable<any> {
    const submitUrl = `${this.baseUrl}/submit`;
    return this.http.post(submitUrl, toy).pipe(
      tap(() => {
        this.updateToys(); // Appelle updateToys après avoir soumis un nouveau Toyz
      })
    );
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


