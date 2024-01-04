import { Component, OnInit } from '@angular/core';
import { ToyService } from 'src/services/toy.service';
import { Toy } from 'src/app/interfaces/toy.interface';
import { ToyzsBySearchService } from '../services/toyzs-by-search.service';

@Component({
  selector: 'app-carousel-accueil',
  templateUrl: './carouselAccueil.component.html',
  styleUrls: ['./carouselAccueil.component.css'],
})
export class CarouselAccueilComponent implements OnInit {
  carouselToys: Toy[] = [];  // Make sure this property is declared

  constructor(private toyService: ToyService,  private toyzBySearchService: ToyzsBySearchService) { }

  ngOnInit(): void {

    this.toyService.getAllToys().subscribe(
      {
        next: toys => {
          this.carouselToys = toys;
        },
        error: (err:Error)=> {
          console.log(err.message);
        }
      }
    )
  }

  


}
