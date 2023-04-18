import { Component, OnInit } from '@angular/core';
import { Ruta } from 'src/app/model/ruta/ruta';
import { Transmilenio } from 'src/app/model/transmilenio/transmilenio';
import { RutaService } from 'src/app/services/ruta/ruta.service';
import { TransmilenioService } from 'src/app/services/transmilenio/transmilenio.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-ruta-list',
  templateUrl: './ruta-list.component.html',
  styleUrls: ['./ruta-list.component.css']
})
export class RutaListComponent implements OnInit {

  rutas: Ruta[] = [];
  transmilenios: Transmilenio[] = [];

  constructor(
    private rutaService: RutaService,
    private transmilenioService: TransmilenioService
  ) { }

  ngOnInit(): void {
    this.rutaService.findAll().subscribe(rutas => {
      this.rutas = rutas;
      this.transmilenioService.findAll().subscribe(transmilenios => {
        this.transmilenios = transmilenios;
      });
    });
  }

  public contains(bus: Transmilenio, ruta: Ruta): boolean {
    let comprobante: boolean = false;
    for (let rutaTransmilenio of bus.rutas!) {
      if (ruta.id === rutaTransmilenio.id) {
        comprobante = true;
      }
    }
    return comprobante;
  }

  public eliminarRuta(id: number) {

    Swal.fire({
      title: '¿Seguro de Eliminarla?',
      text: "Eliminar esta Ruta",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Sí'
    }).then((result) => {
      if (result.isConfirmed) {
        let ruta: Ruta = new Ruta();
        let transmileniosRuta: Transmilenio[] = [];
        this.rutaService.findAll().subscribe(responseRutas => {
          this.rutas = responseRutas;
          this.rutaService.findById(id).subscribe(response => {
            ruta = response;
            for (let transmilenio of this.transmilenios) {
              if (this.contains(transmilenio, ruta)) {
                transmileniosRuta.push(transmilenio);
              }
            }
            if (transmileniosRuta.length >= 1) {
              Swal.fire({
                icon: 'error',
                title: 'No Eliminada',
                text: 'La Ruta ' + ruta.nombre + ' no se puede eliminar porque tiene buses asignados.'
              })
            } else {
              this.rutaService.delete(id).subscribe(response => {
                this.rutas.splice(this.getIndex(this.rutas, ruta), 1);
                Swal.fire({
                  position: 'top-end',
                  icon: 'success',
                  title: 'Ruta Eliminada',
                  showConfirmButton: false,
                  timer: 1500
                })
              });
            }
          });
        });
      }
    });
  }

  public getIndex(rutas: Ruta[], ruta: Ruta): number {
    let id: number = -1;
    let contador: number = 0;
    for (let rut of rutas) {
      if (rut.id === ruta.id) {
        id = contador;
      }
      contador++;
    }
    return id;
  }
}