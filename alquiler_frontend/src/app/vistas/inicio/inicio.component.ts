import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-inicio',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './inicio.component.html',
  styleUrl: './inicio.component.css'
})
export class InicioComponent  {

  // Datos dinámicos (luego los reemplazas con servicios HTTP)
  vehiculosDestacados = [
    {
      nombre: 'Auto Compacto',
      precio: 'S/120',
      imagen: '/images/ejem1.jpg'
    },
    {
      nombre: 'Sedán Ejecutivo',
      precio: 'S/180',
      imagen: '/images/ejem2.jpg'
    },
    {
      nombre: 'SUV Familiar',
      precio: 'S/220',
      imagen: '/images/ejem3.jpg'
    },
    {
      nombre: 'Camioneta 4x4',
      precio: 'S/250',
      imagen: '/images/ejem4.jpg'
    }
  ];

  servicios = [
    {
      titulo: 'Alquiler por Día',
      descripcion: 'Renta el vehículo que prefieras por días con tarifas flexibles.',
      icono: 'https://cdn-icons-png.flaticon.com/512/743/743131.png'
    },
    {
      titulo: 'Alquiler Mensual',
      descripcion: 'Ideal para empresas o clientes que necesitan movilidad prolongada.',
      icono: 'https://cdn-icons-png.flaticon.com/512/1513/1513496.png'
    },
    {
      titulo: 'Entrega a Domicilio',
      descripcion: 'Recibe y devuelve el vehículo donde más te convenga.',
      icono: 'https://cdn-icons-png.flaticon.com/512/3202/3202926.png'
    }
  ];

  constructor() {}

  ngOnInit(): void {}
}
