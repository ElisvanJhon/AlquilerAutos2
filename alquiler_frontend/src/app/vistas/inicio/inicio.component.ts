import { Component, AfterViewInit, OnDestroy } from '@angular/core';
import { CommonModule } from '@angular/common';
import AOS from 'aos';
import 'aos/dist/aos.css';
import fullpage from 'fullpage.js';
import 'fullpage.js/dist/fullpage.min.css';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-inicio',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.css']
})
export class InicioComponent implements AfterViewInit, OnDestroy {

  // referencia a la instancia de fullpage
  private fpInstance: any;

  vehiculosDestacados = [
    { nombre: 'Auto Compacto', precio: 'S/120', imagen: '/images/ejem1.jpg' },
    { nombre: 'Sedán Ejecutivo', precio: 'S/180', imagen: '/images/ejem2.jpg' },
    { nombre: 'SUV Familiar', precio: 'S/220', imagen: '/images/ejem3.jpg' },
    { nombre: 'Camioneta 4x4', precio: 'S/250', imagen: '/images/ejem4.jpg' }
  ];

  servicios = [
    { titulo: 'Alquiler por Día', descripcion: 'Renta el vehículo...', icono: '/images/day.png' },
    { titulo: 'Alquiler Mensual', descripcion: 'Ideal para empresas...', icono: '/images/mes.jpg' },
    { titulo: 'A Domicilio', descripcion: 'Recibe y devuelve...', icono: '/images/house.png' }
  ];

  ngAfterViewInit(): void {
    // Inicializa AOS
    AOS.init({
      duration: 900,
      easing: 'ease-in-out',
      once: true
    });

    // Inicializa fullpage.js
    this.fpInstance = new fullpage('#fullpage', {
      // opciones útiles
      licenseKey: '', // si tienes licencia, colócala. Para uso personal local puedes dejar vacío.
      autoScrolling: true,
      verticalCentered: true,
      navigation: true,           // puntos de navegación a la derecha
      navigationPosition: 'right',
      showActiveTooltip: false,
      scrollOverflow: true,       // permite scroll dentro de secciones si el contenido pasa
      responsiveWidth: 768,       // desactiva autoScrolling en pantallas < 768
      // callbacks para integrar AOS
      afterLoad: (origin: any, destination: any, direction: any) => {
        // refresca AOS para que anime elementos cuando la sección se muestra
        AOS.refresh();
      },
      onLeave: (origin: any, destination: any, direction: any) => {
        // opcional: hacer algo al salir
      }
    });
  }

  ngOnDestroy(): void {
    // destruir la instancia para evitar fugas de memoria
    try {
      if (this.fpInstance && typeof this.fpInstance.destroy === 'function') {
        this.fpInstance.destroy('all');
      }
    } catch (e) {
      // no crítico si falla
      console.warn('Error al destruir fullpage instance', e);
    }
  }
}
