import { Component, signal } from "@angular/core"
import { MatIconModule } from "@angular/material/icon"
import { MatButtonModule } from "@angular/material/button"
import { RouterLink, RouterLinkActive } from "@angular/router"
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { HalloweenService } from '../halloween.service';
import { CommonModule } from "@angular/common";

@Component({
  selector: "app-nav-bar",
  imports: [RouterLink, RouterLinkActive, MatIconModule, MatButtonModule, MatSlideToggleModule, CommonModule],
  templateUrl: "./nav-bar.html",
  styleUrl: "./nav-bar.css",
})
export class NavBar {
  pi = "pi pi piiiiiiiiii"
  isCollapsed = signal(false)

  constructor(public halloweenService: HalloweenService) {}

  toggleSidebar() {
    this.isCollapsed.set(!this.isCollapsed())
  }

  toggleHalloweenMode() {
    this.halloweenService.toggleHalloweenMode();
  }
}
