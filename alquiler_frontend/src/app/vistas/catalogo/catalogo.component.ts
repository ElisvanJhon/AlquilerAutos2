import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { Catalogo } from '../../clases/catalogo';
import { CatalogoService } from '../../servicios/catalogo.service';



@Component({
  selector: 'app-catalogo',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './catalogo.component.html',
  styleUrls: ['./catalogo.component.css']
})
export class CatalogoComponent implements OnInit {

  catalogos : Catalogo []=[];
  marcaFiltro: string = "";
  anioFiltro: number | null = null;
  marcas: string[] = [];
  anios: number[] = [];

  filtro = {
  marca: "",
  anio: ""
};

  constructor(private catalogoService:CatalogoService) { }

  ngOnInit(): void {
    this.listarCatalogo();
  }

  listarCatalogo(){
    this.catalogoService.getVehiculos().subscribe(
      (data: Catalogo[]) => {
        this.catalogos = data;

        this.marcas = [...new Set(data.map(v => v.marca))];

        // Llenar años únicos para el select, ordenados de mayor a menor
        this.anios = [...new Set(data.map(v => v.anio))].sort((a, b) => b - a);
      },
      (error) => {
        console.error('Error al obtener el catálogo:', error);
      }
    );
  } 


  filtrar() {

  // Si no hay filtros → listar todo
  if (!this.filtro.marca && !this.filtro.anio) {
    this.listarCatalogo();
    return;
  }

  // Si solo hay marca → filtrar por marca
  if (this.filtro.marca && !this.filtro.anio) {
    this.catalogoService.getVehiculosPorMarca(this.filtro.marca).subscribe(
      data => this.catalogos = data,
      error => console.error('Error filtrando por marca', error)
    );
    return;
  }

  // Si solo hay año → filtrar por año
  if (!this.filtro.marca && this.filtro.anio) {
    this.catalogoService.getVehiculosPorAnio(Number(this.filtro.anio)).subscribe(
      data => this.catalogos = data,
      error => console.error('Error filtrando por año', error)
    );
    return;
  }
}

limpiar() {
  this.filtro = {
    marca: "",
    anio: ""
  };

  this.listarCatalogo(); // recarga el catálogo completo
}
verDetalles(vehiculo: Catalogo) {
    console.log("Detalles del vehículo:", vehiculo);
    // Si tienes ruta → navegar:
    // this.router.navigate(['/catalogo', vehiculo.id]);
  }

  reservar(vehiculo: Catalogo) {
    console.log("Reservando vehículo:", vehiculo);
    // Aquí normalmente abres un modal o navegas a la reserva
  }
}