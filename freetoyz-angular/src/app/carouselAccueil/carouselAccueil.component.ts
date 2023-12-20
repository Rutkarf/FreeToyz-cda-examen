import { Component, OnInit } from '@angular/core';
import { ToyService } from 'src/services/toy.service';
import { Toy } from 'src/app/interfaces/toy.interface';

@Component({
  selector: 'app-carousel-accueil',
  templateUrl: './carouselAccueil.component.html',
  styleUrls: ['./carouselAccueil.component.css'],
})
export class CarouselAccueilComponent implements OnInit {
  carouselToys: Toy[] = [];  // Make sure this property is declared

  constructor(private toyService: ToyService) {}

  ngOnInit(): void {

    this.toyService.getAllToys().subscribe(
      (toys) => {
        console.log("toys",toys);
        
        this.carouselToys = toys;
      },
      (error) => {
        console.error('Error fetching toys:', error);
      }
    );
  }


}
