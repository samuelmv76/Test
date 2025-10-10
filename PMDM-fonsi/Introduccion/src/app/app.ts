import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Contador } from './contador/contador/contador';
import { Matatopos } from './matatopos/matatopos/matatopos';
import { NavBar } from './nav-bar/nav-bar';
import { Carrera } from './carrera/carrera';
import { ListaPersonajes } from './lista-personajes/lista-personajes';
import { FichaPersonaje } from './ficha-personaje/ficha-personaje';



@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Contador, Matatopos, NavBar, Carrera, ListaPersonajes, FichaPersonaje],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('Introduccion');
}
