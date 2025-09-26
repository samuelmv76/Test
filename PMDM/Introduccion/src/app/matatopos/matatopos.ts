import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-matatopos',
  imports: [CommonModule],
  templateUrl: './matatopos.html',
  styleUrl: './matatopos.css'
})
export class Matatopos {
  contador: number = 0;
  numeroAleatorio: number = Math.floor(Math.random() * 9) + 1;//numero aleatorio del 1 al 9


  matartopo() {

    this.contador++;
    console.log(this.contador);
    this.numeroAleatorio = Math.floor(Math.random() * 9) + 1;

  }
  reiniciarContador() {
    this.contador = 0;
  }

}
