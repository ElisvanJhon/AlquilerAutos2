import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { CatalogoService } from '../../servicios/catalogo.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-catalogoDetalle',
  standalone: true,
  imports: [FormsModule, RouterLink, CommonModule],
  templateUrl: './catalogoDetalle.component.html',
  styleUrls: ['./catalogoDetalle.component.css']

})
export class CatalogoDetalleComponent implements OnInit {

  vehiculo: any;
  similares: any[] = [];

  constructor(
    private route: ActivatedRoute,
    private catalogoService: CatalogoService
  ) {}

ngOnInit(): void {

  this.route.paramMap.subscribe(params => {
    const id = params.get('id');

    if (id) {
      this.catalogoService.getVehiculoPorId(id).subscribe(data => {
        this.vehiculo = data;

        // Cargar vehículos similares al cambiar de ID
        this.cargarSimilares(data.marca, data.idVehiculo);
      });
    }

  });

}


  cargarSimilares(marca: string, idActual: number): void {
    this.catalogoService.getVehiculosPorMarca(marca).subscribe(lista => {
      this.similares = lista
        .filter(v => v.idVehiculo !== idActual) // excluye el vehículo actual
        .slice(0, 4); // muestra máximo 4
    });
  }

}
