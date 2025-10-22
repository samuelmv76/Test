import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { NavBar } from './nav-bar/nav-bar';
import { HalloweenService } from './halloween.service';
import { CommonModule } from '@angular/common';




@Component({
  selector: 'app-root',
  imports: [RouterOutlet, NavBar, CommonModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('Introduccion');

  constructor(public halloweenService: HalloweenService) {}
}
