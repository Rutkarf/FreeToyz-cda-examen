import { Injectable } from '@angular/core';
import { Toy } from '../interfaces/toy.interface';

@Injectable({
  providedIn: 'root'
})
export class ToyzsBySearchService {

  toyzs!: Toy[];

  setToyzComponent(toyzs: Toy[]): void {
    this.toyzs = toyzs;
  }

  getToyzComponent(): Toy[] {
    return this.toyzs;
  }
}
