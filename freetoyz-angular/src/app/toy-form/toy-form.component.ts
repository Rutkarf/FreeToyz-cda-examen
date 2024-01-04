// toy-form.component.ts

import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Toy } from '../interfaces/toy.interface';
import { NgForm } from '@angular/forms';
import { ToyService } from 'src/services/toy.service';

@Component({
  selector: 'app-toy-form',
  templateUrl: './toy-form.component.html',
  styleUrls: ['./toy-form.component.css']
})
export class ToyFormComponent implements OnInit {
toy: Toy = { name: '', categories: '', description: '', cotation: '', quantite: 0, picture: undefined, picturePath: "" };
ngForm :   any

  quantityOptions: number[] = Array.from({ length: 9 }, (_, i) => i + 1);
  // Assure-toi de remplir cette liste avec les catégories disponibles
  categoriesList: string[] = ["Outdoor", "Indoor", "Electronique", "Collection"];

  constructor(
    private toyService : ToyService
  ){

  }
  ngOnInit() {
    // Initialisation ou logique supplémentaire à l'initialisation
  }




  onSubmit(form: NgForm) {
    console.log('Form:', form);
    console.log('Form controls:', form.controls);

    if (form && form.valid) {
      this.toyService.submitToy(this.toy).subscribe(
        response => {
          // Gestion de la réponse (optionnelle)
          console.log('Enregistrement réussi', response);
        },
        error => {
          // Gestion des erreurs
          console.error('Erreur lors de l\'enregistrement', error);
        }
      );
    } else {
      console.error('Formulaire invalide. Veuillez corriger les erreurs.');
    }
  }
}
