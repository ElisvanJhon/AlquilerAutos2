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
  loading = true;
  error = false;

  constructor(
    private route: ActivatedRoute,
    private catalogoService: CatalogoService
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');

    if (id) {
      this.catalogoService.getVehiculoPorId(id).subscribe({
        next: data => {
          this.vehiculo = data;
          this.loading = false;
        },
        error: err => {
          this.error = true;
          this.loading = false;
        }
      });
    }
  }
}
