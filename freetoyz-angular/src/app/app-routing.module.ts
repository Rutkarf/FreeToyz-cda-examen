// app-routing.module.ts

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HomeComponent } from './home/home.component';
import { UserProfileComponent } from './user-profil/user-profile.component';
import { ToyFormComponent } from './toy-form/toy-form.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { SearchComponent } from './search/search.component';
import { ToysComponent } from './toys/toys.component';
import { HowItWorkComponent } from './how-it-work/how-it-work.component';
import { UserProfilEditComponent } from './user-profil-edit/user-profil-edit.component';
import { NavbarSearchToyComponent } from './navbar-search-toy/navbar-search-toy.component';
import { CarouselAccueilComponent } from './carouselAccueil/carouselAccueil.component';
import { ChatComponent } from './chat/chat.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'user-profil', component: UserProfileComponent },
  { path: 'toys', component: ToysComponent },
  { path: 'toy-form', component: ToyFormComponent },
  { path: 'user-profil-edit', component: UserProfilEditComponent },
  { path: 'profile', component: UserProfileComponent },
  { path: 'add-toy', component: ToyFormComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegistrationComponent },
  { path: 'search', component: SearchComponent },
  { path: 'how-it-work', component: HowItWorkComponent},
  { path: 'navbar-search-toy', component: NavbarSearchToyComponent},
  { path: 'carousel-accueil', component: CarouselAccueilComponent },
  { path: 'chat', component: ChatComponent}
  // Ajoutez d'autres routes selon les besoins de votre application
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],

  
})

export class AppRoutingModule { }