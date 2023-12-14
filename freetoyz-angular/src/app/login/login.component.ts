// login.component.ts

import { AuthenticationService } from 'src/services/authentication.service'
import { Router } from '@angular/router';
import { Component } from '@angular/core';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username: string = '';
  password: string = '';

  constructor(private authenticationService: AuthenticationService, private router: Router) {}

  onSubmit() {
    // Appelle la fonction d'authentification du service
    if (this.authenticationService.authenticate(this.username, this.password)) {
      console.log(this.username)
      console.log('Connexion réussie!');
      // Redirige vers la page d'accueil ou une autre page appropriée
      this.router.navigate(['/']);
    } else {
      console.log('Échec de la connexion. Vérifiez vos informations.');
    }
  }
}
