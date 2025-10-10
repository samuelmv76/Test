import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-ficha-personaje',
  imports: [CommonModule],
  templateUrl: './ficha-personaje.html',
  styleUrl: './ficha-personaje.css'
})
export class FichaPersonaje {
  @Input() personaje: any;

  getStars(power: number): any[] {
    return new Array(power);
  }
}
