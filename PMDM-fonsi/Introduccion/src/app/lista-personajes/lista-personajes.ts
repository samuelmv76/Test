import { Component } from '@angular/core';
import { FichaPersonaje } from '../ficha-personaje/ficha-personaje';

@Component({
  selector: 'app-lista-personajes',
  imports: [FichaPersonaje],
  templateUrl: './lista-personajes.html',
  styleUrl: './lista-personajes.css'
})
export class ListaPersonajes {
  personajes = [
    {
      nombre: 'Goku',
      raza: 'Saiyan',
      poder: 5,
      imagen: '/images/goku.jpg'
    },
    {
      nombre: 'Piccolo',
      raza: 'Namekiano',
      poder: 3,
      imagen: '/images/piccolo.jpg'
    },
    {
      nombre: 'Luffy',
      raza: 'Sombrero de paja',
      poder: 4,
      imagen: '/images/luffy.jpg'
    },
    {
      nombre: 'Zoro',
      raza: 'Humano',
      poder: 4,
      imagen: '/images/zoro.jpg'
    },
    {
      nombre: 'Shanks',
      raza: 'Humano',
      poder: 4,
      imagen: '/images/shanks.jpg'
    },
    {
      nombre: 'Davo',
      raza: 'Humano',
      poder: 0,
      imagen: '/images/davo.jpg'
    }
  ];
}
