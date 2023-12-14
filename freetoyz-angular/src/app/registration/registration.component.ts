// registration.component.ts

import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Register } from '../interfaces/register.interface';
import { AuthenticationService } from 'src/services/authentication.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent {

  constructor(private auth:AuthenticationService){}

 user: Register = {
    username: '',
    password: ''
 }

 token!:string;


  onSubmit(form: NgForm) {
    // Ajoute la logique de traitement du formulaire d'inscription ici
    console.log('User registered:', form.value);
    this.auth.register(form).subscribe({
      next: (response) => {
        console.log("response",response)
        this.token = response.token,
        console.log("token",this.token)
      },
      error: (err: Error) => console.log(err.message)
    })
  }
}