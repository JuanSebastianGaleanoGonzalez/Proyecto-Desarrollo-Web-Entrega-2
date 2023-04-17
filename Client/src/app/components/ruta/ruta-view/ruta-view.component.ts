import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { Ruta } from 'src/app/model/ruta/ruta';
import { RutaService } from 'src/app/services/ruta/ruta.service';
import { Estacion } from 'src/app/model/estacion/estacion';
import { Transmilenio } from 'src/app/model/transmilenio/transmilenio';
import { Horario } from 'src/app/model/horario/horario';
import { TransmilenioService } from 'src/app/services/transmilenio/transmilenio.service';

@Component({
  selector: 'app-ruta-view',
  templateUrl: './ruta-view.component.html',
  styleUrls: ['./ruta-view.component.css']
})
export class RutaViewComponent implements OnInit {

  ruta: Ruta = new Ruta();
  estacionesRuta: Estacion[] = [];
  transmileniosRuta: Transmilenio[] = [];
  horariosRuta: Horario[] = [];

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
      this.estacionesRuta = this.ruta?.estaciones!;
      this.horariosRuta = this.ruta?.horarios!;
      this.transmilenioService.findAll().subscribe(response => {
        for(let transmilenio of response){
          if(this.contains(transmilenio, this.ruta)){
            this.transmileniosRuta.push(transmilenio);
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
}