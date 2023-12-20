// toy-form.component.ts

import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Toy } from '../interfaces/toy.interface';


@Component({
  selector: 'app-toy-form',
  templateUrl: './toy-form.component.html',
  styleUrls: ['./toy-form.component.css']
})
export class ToyFormComponent implements OnInit {
  @Input() toy: Toy = { name: '', categories: '', description: '', cotation: '', quantite: 0, picture: undefined,picturePath : "" };
  @Input() formTitle!: string;
  @Input() submitButtonText!: string;
  @Output() submitForm: EventEmitter<Toy> = new EventEmitter();

  ngOnInit() {
    // Initialisation ou logique supplémentaire à l'initialisation
  }

  onSubmit() {
    this.submitForm.emit(this.toy);
  }

  // Assure-toi de remplir cette liste avec les catégories disponibles
  categoriesList: string[] = ["Outdoor", "Indoor", "Electronique", "Collection"];

}