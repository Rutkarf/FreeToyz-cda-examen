// user-profil.component.ts

import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
  // ... le reste du code

  user: any = { // Assure-toi d'avoir une structure de données correspondante
    email: '',
    username: '', 
    location:'',
    telephone:'',
    description:'',
    profil_picture:'',
    adresse:'',
    avatar: ''
    // Ajoute d'autres propriétés selon tes besoins
  };

  constructor() { }

  ngOnInit(): void {
    // Logique d'initialisation, si nécessaire
  }

}