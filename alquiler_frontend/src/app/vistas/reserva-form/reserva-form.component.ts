import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { CatalogoService } from '../../servicios/catalogo.service';
import { ReservaService } from '../../servicios/reserva.service';

declare var bootstrap: any;
@Component({
  imports: [CommonModule, FormsModule, RouterModule],
  selector: 'app-reserva',
  standalone: true,
  templateUrl: './reserva-form.component.html',
  styleUrls: ['./reserva-form.component.css']
})
export class ReservaComponent implements OnInit {

  vehiculo: any;
  fechaInicio: string = '';
  fechaFin: string = '';

  metodoEntrega = 'tienda';
  direccion = '';

  costoTotal: number | null = null;
  dias: number = 0;

  errorFecha = false;

  constructor(
    private route: ActivatedRoute,
    private router: Router, 
    private catalogoService: CatalogoService,
    private reservaService: ReservaService
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.catalogoService.getVehiculoPorId(id).subscribe(v => {
        this.vehiculo = v;
      });
    }
  }

 calcularCosto() {
    if (!this.fechaInicio || !this.fechaFin) {
      this.costoTotal = null;
      return;
    }

    const inicio = new Date(this.fechaInicio);
    const fin = new Date(this.fechaFin);

    const diff = (fin.getTime() - inicio.getTime()) / (1000 * 60 * 60 * 24);

    if (diff <= 0) {
      this.errorFecha = true;
      this.costoTotal = null;
      return;
    }

    this.errorFecha = false;
    this.dias = diff;
    this.costoTotal = diff * this.vehiculo.precioDiario;
  }

 confirmarReserva() {

    // Aquí debe ir la lógica real para crear la reserva
    this.crearReserva();

    // Abrir modal de éxito
    const modal = new bootstrap.Modal(document.getElementById('successModal'));
    modal.show();
  }

  crearReserva() {
    if (this.errorFecha) {
      return;
    }

    this.calcularCosto();

    const reserva = {
      fechaInicio: this.fechaInicio,
      fechaFin: this.fechaFin,
      metodoEntrega: this.metodoEntrega,
      direccionEntrega: this.metodoEntrega === 'domicilio' ? this.direccion : null,
      vehiculo: { idVehiculo: this.vehiculo.idVehiculo },
      cliente: { idCliente: 1 },
      costoEstimado: this.costoTotal, 
      estado: 'reservado'  
    };

    this.reservaService.crearReserva(reserva).subscribe(() => {
      alert('Reserva creada exitosamente');
    });
  }

  cerrarYVolver() {
    // Cerrar modal manualmente
    const modalElement = document.getElementById('successModal');
    const modal = bootstrap.Modal.getInstance(modalElement);
    modal.hide();

    // Redirigir al inicio
    this.router.navigate(['/']);
  }
}