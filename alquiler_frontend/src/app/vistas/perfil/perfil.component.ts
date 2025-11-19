import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';


interface Reserva {
  vehiculo: string;
  fechaInicio: string;
  fechaFin: string;
  estado: string;
}

interface Cliente {
  nombre: string;
  apellido: string;
  correo: string;
  telefono: string;
  documento: string;
}

@Component({
  imports: [CommonModule, FormsModule, RouterModule],
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.css']
})
export class PerfilComponent {
  cliente: Cliente = {
    nombre: 'Juan',
    apellido: 'Pérez',
    correo: 'juan@example.com',
    telefono: '+51 999999999',
    documento: '12345678'
  };

  reservas: Reserva[] = [
    {
      vehiculo: 'Toyota Corolla',
      fechaInicio: '2025-10-15',
      fechaFin: '2025-10-18',
      estado: 'Activa'
    },
    {
      vehiculo: 'Hyundai Tucson',
      fechaInicio: '2025-09-01',
      fechaFin: '2025-09-05',
      estado: 'Finalizada'
    }
  ];

  editarPerfil() {
    console.log('Editar perfil...');
  }

  verReserva(reserva: Reserva) {
    console.log('Ver reserva:', reserva);
  }

  cancelarReserva(reserva: Reserva) {
    console.log('Cancelar reserva:', reserva);
  }
}
