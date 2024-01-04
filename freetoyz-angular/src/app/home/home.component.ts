


// Dans home.component.ts
import { Component, ViewChild } from '@angular/core';
import { CarouselAccueilComponent } from '../carouselAccueil/carouselAccueil.component';



@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  
})
export class HomeComponent {


  @ViewChild(CarouselAccueilComponent) carousel!: CarouselAccueilComponent;

  showToyzBySearch = (listToyzsBySearch:any) => {
    // console.log( "get", listToyzsBySearch);
    this.carousel.carouselToys = listToyzsBySearch;
  }
}

