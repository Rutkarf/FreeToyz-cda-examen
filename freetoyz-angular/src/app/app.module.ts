// app.module.ts

import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';

import { SocketService } from 'src/services/socket.service';

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { ToysComponent } from './toys/toys.component';
import { UserProfileComponent } from './user-profil/user-profile.component';
import { ToyFormComponent } from './toy-form/toy-form.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { SearchComponent } from './search/search.component';
import { NavbarSearchToyComponent } from './navbar-search-toy/navbar-search-toy.component';
import { CoverAccueilComponent } from './cover-accueil/cover-accueil.component';
import { CarouselAccueilComponent } from './carouselAccueil/carouselAccueil.component';
import { HowItWorkComponent } from './how-it-work/how-it-work.component';
import { UserProfilEditComponent } from './user-profil-edit/user-profil-edit.component';
import { ChatComponent } from './chat/chat.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    HomeComponent,
    ToysComponent,
    UserProfileComponent,
    ToyFormComponent,
    LoginComponent,
    RegistrationComponent,
    SearchComponent,
    NavbarSearchToyComponent,
    CoverAccueilComponent,
    CarouselAccueilComponent,
    HowItWorkComponent,
    UserProfilEditComponent,
    ChatComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot([
      { path: '', component: HomeComponent },
      { path: 'toys', component: ToysComponent, children: [
        { path: 'toy-form', component: ToyFormComponent },
        // Ajoute d'autres routes enfants au besoin
      ] },
      { path: 'profile', component: UserProfileComponent },
      // ... ajoute d'autres routes selon tes besoins
    ]),
  ],
  providers: [SocketService],
  bootstrap: [AppComponent]
})
export class AppModule { }
