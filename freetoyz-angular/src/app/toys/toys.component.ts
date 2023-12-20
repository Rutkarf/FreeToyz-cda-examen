// Importe les modules nécessaires depuis Angular
import { Component, OnInit } from '@angular/core';
import { ToyService } from 'src/services/toy.service'; // Assure-toi d'ajuster le chemin correctement
// Définit le composant Angular avec son sélecteur, son template et son style
@Component({
  selector: 'app-toys',
  templateUrl: './toys.component.html',
  styleUrls: ['./toys.component.css']  // N'oublie pas d'ajuster ce chemin si nécessaire
})

// Exporte la classe du composant
export class ToysComponent implements OnInit {
  toys: any[] = []; // Déclare une propriété pour stocker la liste des jouets

  constructor(private toyService: ToyService) {} // Injecte le service ToyService dans le constructeur

  ngOnInit(): void {
    // Utilise l'observateur toys$ du ToyService pour écouter les changements dans la liste des jouets
    this.toyService.toys$.subscribe((toys) => {
      this.toys = toys;
    });

    // Appelle la méthode updateToys pour récupérer la liste initiale des jouets
    this.toyService.updateToys();
  }
}