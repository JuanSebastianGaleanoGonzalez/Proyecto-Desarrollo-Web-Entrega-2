import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { switchMap } from 'rxjs';
import { Estacion } from 'src/app/model/estacion/estacion';
import { Ruta } from 'src/app/model/ruta/ruta';
import { EstacionesService } from 'src/app/services/estaciones/estaciones.service';
import { RutaService } from 'src/app/services/ruta/ruta.service';

@Component({
  selector: 'app-ruta-asign-estacion',
  templateUrl: './ruta-asign-estacion.component.html',
  styleUrls: ['./ruta-asign-estacion.component.css']
})
export class RutaAsignEstacionComponent implements OnInit {

  ruta: Ruta = new Ruta();
  estacionesAsignadas: Estacion[] = [];
  estacionesNoAsignadas: Estacion[] = [];

  constructor(
    private rutaService: RutaService,
    private estacionService: EstacionesService,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.route.paramMap.pipe(switchMap(params =>
      this.rutaService.findById(+params.get('id')!)
    )).subscribe(ruta => {
      this.ruta = ruta;
      this.estacionService.findAll().subscribe(response => {
        for(let estacion of response){
          if(this.contains(ruta, estacion)){
            this.estacionesAsignadas.push(estacion);
          }else{
            this.estacionesNoAsignadas.push(estacion);
          }
        }
      });
    });
  }

  public contains(ruta: Ruta, estacion: Estacion): boolean{
    let comprobante = false;
    for(let est of ruta.estaciones!){
      if(est.id === estacion.id){
        comprobante = true;
      }
    }
    return comprobante;
  }

  public agregarEstacionRuta(estacion: Estacion) {
    this.estacionesNoAsignadas.splice(this.estacionesNoAsignadas.indexOf(estacion), 1);
    this.estacionesAsignadas.push(estacion);
    this.ruta.estaciones?.push(estacion);
    this.rutaService.update(this.ruta).subscribe(response => {
    });
  }

  public eliminarEstacionRuta(estacion: Estacion) {
    this.estacionesAsignadas.splice(this.estacionesAsignadas.indexOf(estacion), 1);
    this.ruta.estaciones?.splice(this.ruta.estaciones.indexOf(estacion), 1);
    this.estacionesNoAsignadas.push(estacion);
    this.rutaService.update(this.ruta).subscribe(response => {
    });
  }
}
