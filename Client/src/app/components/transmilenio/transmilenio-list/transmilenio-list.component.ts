import { Component, OnInit } from '@angular/core';
import { Conductor } from 'src/app/model/conductor/conductor';
import { Transmilenio } from 'src/app/model/transmilenio/transmilenio';
import { ConductorService } from 'src/app/services/conductor/conductor.service';
import { TransmilenioService } from 'src/app/services/transmilenio/transmilenio.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-transmilenio-list',
  templateUrl: './transmilenio-list.component.html',
  styleUrls: ['./transmilenio-list.component.css']
})
export class TransmilenioListComponent implements OnInit {

  transmilenios: Transmilenio[] = [];
  conductores: Conductor[] = [];

  constructor(
    private transmilenioService: TransmilenioService,
    private conductorService: ConductorService
  ) { }

  ngOnInit(): void {
    this.transmilenioService.findAll().subscribe(transmilenios => {
      this.transmilenios = transmilenios;
      this.conductorService.findAll().subscribe(conductores => {
        this.conductores = conductores;
      });
    });
  }

  public eliminarTransmilenio(id: number) {
    Swal.fire({
      title: '¿Seguro de Eliminarlo?',
      text: "Eliminar este Bus",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Sí'
    }).then((result) => {
      if (result.isConfirmed) {
        let transmilenio: Transmilenio = new Transmilenio();
        let conductoresTransmilenio: Conductor[] = [];
        this.transmilenioService.findAll().subscribe(rTransmilenios => {
          this.transmilenios = rTransmilenios;
          this.transmilenioService.findById(id).subscribe(rTransmilenio => {
            transmilenio = rTransmilenio;
            for (let conductor of this.conductores) {
              if (this.contains(conductor, transmilenio)) {
                conductoresTransmilenio.push(conductor);
              }
            }
            if (conductoresTransmilenio.length >= 1) {
              Swal.fire({
                icon: 'error',
                title: 'No Eliminado',
                text: 'El bus' + transmilenio.placa + ' no se puede eliminar porque tiene conductores asignados.'
              })
            } else {
              this.transmilenioService.delete(id).subscribe(response => {
                this.transmilenios.splice(this.getIndex(this.transmilenios, transmilenio), 1);
                Swal.fire({
                  position: 'top-end',
                  icon: 'success',
                  title: 'Bus Eliminado',
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

  public contains(conductor: Conductor, transmilenio: Transmilenio): boolean {
    let comprobante = false;
    for (let transmilenioConductor of conductor.transmilenios!) {
      if (transmilenioConductor.id === transmilenio.id) {
        comprobante = true;
      }
    }
    return comprobante;
  }

  public getIndex(transmilenios: Transmilenio[], transmilenio: Transmilenio): number {
    let id: number = -1;
    let contador: number = 0;
    for (let transmi of transmilenios) {
      if (transmi.id === transmilenio.id) {
        id = contador;
      }
      contador++;
    }
    return id;
  }
}
