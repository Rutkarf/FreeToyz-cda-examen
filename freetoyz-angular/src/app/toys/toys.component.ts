import { Component, OnInit } from '@angular/core';
import { ToyService } from 'src/services/toy.service';
import { Toy } from '../interfaces/toy.interface'; // Assure-toi d'ajuster le chemin correctement
import { ToyFormComponent } from '../toy-form/toy-form.component';
import { ViewChild } from '@angular/core';
import { CarouselAccueilComponent } from '../carouselAccueil/carouselAccueil.component';
@Component({
  selector: 'app-toys',
  templateUrl: './toys.component.html',
  styleUrls: ['./toys.component.css']
})
export class ToysComponent implements OnInit {
  toys: Toy[] = []; // Assure-toi d'ajuster le type pour correspondre à la structure de Toy

  @ViewChild(ToyFormComponent) toyForm!: ToyFormComponent;

  @ViewChild(CarouselAccueilComponent) carousel!: CarouselAccueilComponent;

  showToyzBySearch = (listToyzsBySearch: any) => {
    // console.log( "get", listToyzsBySearch);
    this.carousel.carouselToys = listToyzsBySearch;
  }

  constructor(private toyService: ToyService) { }

  ngOnInit(): void {
    this.toyService.toys$.subscribe((toys) => {
      this.toys = toys;
    });

    this.toyService.updateToys();
  }

  submitToy(submittedToy: Toy) {
    console.log('Jouet soumis:', submittedToy);
    this.toyService.submitToy(submittedToy)
    // Tu peux effectuer d'autres actions ici
    // Assure-toi d'importer le service nécessaire si tu en as un.
  }
}
