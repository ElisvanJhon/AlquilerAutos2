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
  tipoFiltro: string = "";
  marcas: string[] = [];
  anios: number[] = [];
  errorMsg: string = '';
  tipos: string[] = [];

  filtro = {
  marca: "",
  anio: "",
  precioMax: '',
  tipoVehiculo: ""
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

        this.tipos = [...new Set(data.map(v => v.tipoVehiculo))];
      },
      (error) => {
        console.error('Error al obtener el catálogo:', error);
      }
    );
  } 


filtrar() {
  // Si no hay filtros → listar todo
  if (!this.filtro.marca && !this.filtro.anio && !this.filtro.precioMax && !this.filtro.tipoVehiculo) {
    this.listarCatalogo();
    return;
  }

  // Traemos todos los vehículos primero
  this.catalogoService.getVehiculos().subscribe(
    data => {
      let resultado = data;

      // Filtrar por marca
      if (this.filtro.marca) {
        resultado = resultado.filter(v => v.marca === this.filtro.marca);
      }

      // Filtrar por año
      if (this.filtro.anio) {
        resultado = resultado.filter(v => v.anio === Number(this.filtro.anio));
      }

      // Filtrar por tipo de vehículo
      if (this.filtro.tipoVehiculo) {
        resultado = resultado.filter(v => v.tipoVehiculo === this.filtro.tipoVehiculo);
      }


        // Filtrar por precio máximo
      if (this.filtro.precioMax) {
        resultado = resultado.filter(v => v.precioDiario <= Number(this.filtro.precioMax));
      }

      this.catalogos = resultado;
     if (resultado.length === 0) {
        this.errorMsg = 'No se encontraron coinsidencias!';
      } else {
        this.errorMsg = '';
      }
    },
    error => this.errorMsg = 'Error al filtrar vehículos'
  );
}


limpiar() {
  this.filtro = {
    marca: "",
    anio: "",
    precioMax: '',
    tipoVehiculo: ""
  };

  this.errorMsg = '';

  this.listarCatalogo(); // recarga el catálogo completo
}
verDetalles(vehiculo: Catalogo) {
    console.log("Detalles del vehículo:", vehiculo);
    // Si tienes ruta → navegar:
    // this.router.navigate(['/catalogo', vehiculo.id]);
  }

}