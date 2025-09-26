import { Routes } from '@angular/router';
import { Matatopos } from './matatopos/matatopos';
import { Menu } from './menu/menu';

export const routes: Routes = [
  { path: 'menu', component: Menu },
  { path: 'matatopos', component: Matatopos },
  { path: '', redirectTo: 'menu', pathMatch: 'full' }
];
