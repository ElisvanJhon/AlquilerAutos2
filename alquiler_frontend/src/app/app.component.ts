import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {InicioComponent} from '../app/vistas/inicio/inicio.component';

@Component({
  selector: 'app-root',
  imports: [InicioComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'alquiler_autos';
}
