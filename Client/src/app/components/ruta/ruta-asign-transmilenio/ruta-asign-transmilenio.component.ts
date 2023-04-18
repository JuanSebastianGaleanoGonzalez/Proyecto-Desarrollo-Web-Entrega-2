import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { switchMap } from 'rxjs';
import { Ruta } from 'src/app/model/ruta/ruta';
import { Transmilenio } from 'src/app/model/transmilenio/transmilenio';
import { RutaService } from 'src/app/services/ruta/ruta.service';
import { TransmilenioService } from 'src/app/services/transmilenio/transmilenio.service';

@Component({
  selector: 'app-ruta-asign-transmilenio',
  templateUrl: './ruta-asign-transmilenio.component.html',
  styleUrls: ['./ruta-asign-transmilenio.component.css']
})
export class RutaAsignTransmilenioComponent implements OnInit {

  ruta: Ruta = new Ruta();
  transmileniosAsignados: Transmilenio[] = [];
  transmileniosNoAsignados: Transmilenio[] = [];

  constructor(
    private rutaService: RutaService,
    private transmilenioService: TransmilenioService,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.route.paramMap.pipe(switchMap(params =>
      this.rutaService.findById(+params.get('id')!)
    )).subscribe(ruta => {
      this.ruta = ruta;
      this.transmilenioService.findAll().subscribe(response => {
        for (let transmilenio of response) {
          if (this.contains(transmilenio, ruta)) {
            this.transmileniosAsignados.push(transmilenio);
          } else {
            this.transmileniosNoAsignados.push(transmilenio);
          }
        }
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

  public agregarTransmilenioRuta(transmilenio: Transmilenio) {
    this.transmileniosNoAsignados.splice(this.transmileniosNoAsignados.indexOf(transmilenio), 1);
    this.transmileniosAsignados.push(transmilenio);
    transmilenio.rutas?.push(this.ruta);
    this.transmilenioService.update(transmilenio).subscribe(response => {
    });
  }

  public eliminarTransmilenioRuta(transmilenio: Transmilenio) {
    this.transmileniosAsignados.splice(this.transmileniosAsignados.indexOf(transmilenio), 1);
    this.transmileniosNoAsignados.push(transmilenio);
    this.transmilenioService.findById(transmilenio.id!).subscribe(response => {
      response.rutas?.splice(this.getIndex(response, this.ruta), 1);
      this.transmilenioService.update(response).subscribe(resp => {
      });
    });
  }

  public getIndex(transmilenio: Transmilenio, ruta: Ruta): number {
    let id: number = -1;
    let contador: number = 0;
    for (let rut of transmilenio.rutas!) {
      if (rut.id === ruta.id) {
        id = contador;
      }
      contador++;
    }
    return id;
  }
}
