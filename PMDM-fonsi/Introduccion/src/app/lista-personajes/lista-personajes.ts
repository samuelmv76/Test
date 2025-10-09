import { Component } from '@angular/core';

@Component({
  selector: 'app-lista-personajes',
  imports: [],
  template: `
  <div *ngFor="let personaje of personajes">
    {{ personaje.nombre }} - {{ personaje.raza }} - {{ personaje.poder }}
  </div>
`,
  templateUrl: './lista-personajes.html',
  styleUrl: './lista-personajes.css'
})
export class ListaPersonajes {
  personajes = [
    { nombre: 'Personaje 1', raza: 'Raza 1', poder: 'Poder 1' ,imagen: 'ruta/a/la/imagen1.jpg'},
    { nombre: 'Personaje 2', raza: 'Raza 2', poder: 'Poder 2' ,imagen: 'ruta/a/la/imagen2.jpg'},
    { nombre: 'Personaje 3', raza: 'Raza 3', poder: 'Poder 3' ,imagen: 'ruta/a/la/imagen3.jpg'}
  ];
}
