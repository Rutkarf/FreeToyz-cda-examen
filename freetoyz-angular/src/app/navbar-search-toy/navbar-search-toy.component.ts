import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { NgForm } from '@angular/forms';
import { CarouselService } from 'src/services/carousel-accueil.service'; // Met le bon chemin
import { ToyService } from 'src/services/toy.service';
import { Toy } from '../interfaces/toy.interface';
import { ToyzsBySearchService } from '../services/toyzs-by-search.service';


@Component({
  selector: 'app-navbar-search-toy',
  templateUrl: './navbar-search-toy.component.html',
  styleUrls: ['./navbar-search-toy.component.css'],
})
export class NavbarSearchToyComponent {
  // toyz!:Toy[];
  categories: any[] | undefined; // Assure-toi que le type correspond à la structure des données du CarouselAccueil

  @Output() toyzsBycategory: EventEmitter<Toy[]> = new EventEmitter<Toy[]>();

  constructor(
    private carouselService: CarouselService,
    private toyService: ToyService,
    private toyzBySearchService: ToyzsBySearchService
  ) { }


  send(search: NgForm) {
    if (search.value.search != "") {
      this.toyService.getToysByCategory(search.value.search).subscribe({
        next: (listToyzsBySearch) => {
          console.log("retourne: ", listToyzsBySearch);
          this.toyzsBycategory.emit(listToyzsBySearch);
          // this.toyzBySearchService.setToyzComponent(listToyzsBySearch);
        }
      })
    }
  }
}


