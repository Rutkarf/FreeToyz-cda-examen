import { Component, OnInit } from '@angular/core';
import { CarouselService } from 'src/services/carousel-accueil.service'; // Met le bon chemin

@Component({
  selector: 'app-navbar-search-toy',
  templateUrl: './navbar-search-toy.component.html',
  styleUrls: ['./navbar-search-toy.component.css'],
})
export class NavbarSearchToyComponent implements OnInit {
  categories: any[] | undefined; // Assure-toi que le type correspond à la structure des données du CarouselAccueil

  constructor(private carouselService: CarouselService) {}

  ngOnInit(): void {
    this.carouselService.getCarouselItems().subscribe((data) => {
      this.categories = data;
    });
  }
}


