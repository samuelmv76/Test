import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-contador',
  imports: [CommonModule],
  templateUrl: './contador.html',
  styleUrls: ['./contador.css']
})
export class Contador {
  esVisible: boolean = false;
  numero: number = 10;
  incrementar(){
    this.numero++;
  }

  decrementar(){
    this.numero--;
  }

  resetear(){
    this.numero=10;
  }


}
