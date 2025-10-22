import { Injectable, signal } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HalloweenService {
  halloweenMode = signal(false);

  toggleHalloweenMode() {
    this.halloweenMode.set(!this.halloweenMode());
  }
}
