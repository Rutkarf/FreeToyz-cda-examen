import { Component, OnInit } from '@angular/core';
import { CarouselService } from 'src/services/carousel-accueil.service'; // Met le bon chemin

@Component({
  selector: 'app-carousel',
  templateUrl: './carouselAccueil.component.html',
  styleUrls: ['./carouselAccueil.component.css'],
})
export class CarouselAccueilComponent implements OnInit {
  carouselItems: any[] = []; // Initialisation par un tableau vide

  constructor(private carouselService: CarouselService) {}

  ngOnInit(): void {
    this.carouselService.getCarouselItems().subscribe((data) => {
      this.carouselItems = data;
    });
  }
}