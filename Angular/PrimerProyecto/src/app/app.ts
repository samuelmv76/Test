import { Component, OnInit, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Semaforo } from './semaforo/semaforo';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Semaforo],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App implements OnInit {

  protected readonly title = signal('PrimerProyecto');
//inicializar numero
  numero: number = 3;

  ngOnInit(): void {
    const intervalId = setInterval(() => {
      if (this.numero > 0) {
        this.numero--; //resta de numero
      } else {
        clearInterval(intervalId);

        //cambiar el color de marco 2 a verde
        const marco2 = document.getElementById('marco2');
        if (this.numero === 0 && marco2) {
          marco2.style.borderColor = 'green';
        }

      }
    }, 1000);
  }

}
