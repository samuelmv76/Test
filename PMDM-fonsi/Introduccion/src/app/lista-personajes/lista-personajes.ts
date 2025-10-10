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
      imagen: 'https://e.rpp-noticias.io/normal/2022/05/10/583858_1253093.jpg'
    },
    {
      nombre: 'Vegeta',
      raza: 'Saiyan',
      poder: 4,
      imagen: 'https://i.pinimg.com/originals/f0/91/97/f09197b28532f507204b3f6284d6333d.png'
    },
    {
      nombre: 'Piccolo',
      raza: 'Namekian',
      poder: 3,
      imagen: 'https://i.pinimg.com/originals/9d/2d/0c/9d2d0c67e914093910c51152dba62b0e.png'
    },
    {
      nombre: 'Frieza',
      raza: 'Frieza Race',
      poder: 4,
      imagen: 'https://i.pinimg.com/originals/3e/b3/63/3eb3634938a16701045b4104719f1873.png'
    },
    {
      nombre: 'Cell',
      raza: 'Android',
      poder: 4,
      imagen: 'https://i.pinimg.com/originals/6a/0c/7c/6a0c7c34e83f3e25b00e6a17f69205cb.png'
    }
  ];
}
