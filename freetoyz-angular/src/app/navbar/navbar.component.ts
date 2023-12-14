// navbar.component.ts

import { Component } from '@angular/core';
import { AuthenticationService } from 'src/services/authentication.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent {


  constructor(private authenticationService: AuthenticationService) {

  }

  isLoggedIn(): boolean {
    return this.authenticationService.isAuthenticated();
  }

  logout(): void {
    this.authenticationService.logout();
  }

  getUserName(): string {
    return this.authenticationService.getUserName() as string;
  }
}