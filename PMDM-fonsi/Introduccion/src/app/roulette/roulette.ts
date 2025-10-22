import { Component, ElementRef, ViewChild } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-roulette',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './roulette.html',
  styleUrls: ['./roulette.css']
})
export class RouletteComponent {
  @ViewChild('spinSound') spinSound!: ElementRef<HTMLAudioElement>;
  @ViewChild('winSound') winSound!: ElementRef<HTMLAudioElement>;

  // segmentos: label, color y valor real
  segments = [
    { label: '1000', color: '#FF5733', value: 1000 },
    { label: '200$', color: '#33FF57', value: 200 },
    { label: '300$', color: '#3357FF', value: 300 },
    { label: '100$',   color: '#888888', value: 100 },
    { label: '300$', color: '#FFD700', value: 300 },
    { label: '0$',color: '#AA00FF', value: 0 },
  ];

  // UI / estado
  lights = new Array(20).fill(0);
  rotation = 'rotate(0deg)';
  isSpinning = false;
  winner: any = null;
  totalMoney = 1000; // saldo inicial
  spinCost = 200;    // coste por tirada

  // estado interno
  private currentRotation = 0; // rotación acumulada en grados
  private pointerAngle = 270;  // puntero está en "arriba" = 270° en nuestra referencia

  spin() {
    if (this.isSpinning) return;
    if (this.totalMoney < this.spinCost) {
      alert('❌ No tienes suficiente dinero para girar.');
      return;
    }

    // cobrar el giro inmediatamente
    this.totalMoney -= this.spinCost;
    this.isSpinning = true;
    this.winner = null;

    // reproducir sonido de giro si existe <audio> en template, si no usar fallback
    try {
      if (this.spinSound && this.spinSound.nativeElement) {
        this.spinSound.nativeElement.pause();
        this.spinSound.nativeElement.currentTime = 0;
        this.spinSound.nativeElement.play();
      }
    } catch {
      // ignoramos errores si no existe el elemento
    }


    // configuración del giro
    const segmentAngle = 360 / this.segments.length;

    // Generamos una rotación: entre 5 y 8 vueltas + un offset aleatorio (0..360)
    const vueltas = 5 + Math.random() * 3; // entre 5 y 8
    const offset = Math.random() * 360;   // offset libre
    const spinDegrees = 360 * vueltas + offset;

    // acumulamos la rotación total
    this.currentRotation += spinDegrees;
    this.rotation = `rotate(${this.currentRotation}deg)`;

    // esperar a que acabe la animación (ajusta el tiempo si tu CSS usa otro)
    const ANIMATION_MS = 4200;
    setTimeout(() => {
      // detener sonido de giro
      try { this.spinSound?.nativeElement.pause(); } catch {}

      // calcular índice ganador con la fórmula robusta:
      // relative = (pointerAngle - (R mod 360) + 360) mod 360
      const normalizedRotation = ((this.currentRotation % 360) + 360) % 360; // 0..359.999...
      const relative = (this.pointerAngle - normalizedRotation + 360) % 360; // 0..359.999...
      const winningIndex = Math.floor(relative / segmentAngle);

      // asegurar índice en rango
      const idx = ((winningIndex % this.segments.length) + this.segments.length) % this.segments.length;
      this.winner = this.segments[idx];

      // sumar premio si lo hay
      if (this.winner.value > 0) {
        this.totalMoney += this.winner.value;
      }

      // reproducir sonido de victoria
      try {
        if (this.winSound && this.winSound.nativeElement) {
          this.winSound.nativeElement.currentTime = 0;
          this.winSound.nativeElement.play();
        }
      } catch {}


      this.isSpinning = false;
    }, ANIMATION_MS);
  }
}
