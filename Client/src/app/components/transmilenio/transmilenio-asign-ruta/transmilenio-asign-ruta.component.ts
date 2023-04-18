import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { switchMap } from 'rxjs';
import { Ruta } from 'src/app/model/ruta/ruta';
import { Transmilenio } from 'src/app/model/transmilenio/transmilenio';
import { RutaService } from 'src/app/services/ruta/ruta.service';
import { TransmilenioService } from 'src/app/services/transmilenio/transmilenio.service';

@Component({
  selector: 'app-transmilenio-asign-ruta',
  templateUrl: './transmilenio-asign-ruta.component.html',
  styleUrls: ['./transmilenio-asign-ruta.component.css']
})
export class TransmilenioAsignRutaComponent implements OnInit {

  transmilenio: Transmilenio = new Transmilenio();
  rutasNoAsignadas: Ruta[] = [];

  constructor(
    private transmilenioService: TransmilenioService,
    private rutaService: RutaService,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.route.paramMap.pipe(switchMap(params =>
      this.transmilenioService.findById(+params.get('id')!)
    )).subscribe(transmilenio => {
      this.transmilenio = transmilenio;
      this.rutaService.findAll().subscribe(response => {
        for(let ruta of response){
          if(!this.contains(this.transmilenio.rutas!, ruta)){
            this.rutasNoAsignadas.push(ruta);
          }
        }
      });
    });
  }

  public contains(rutas: Ruta[], ruta: Ruta): boolean{
    let comprobante = false;
    for(let rut of rutas){
      if(rut.id === ruta.id){
        comprobante = true;
      }
    }
    return comprobante;
  }


  public agregarRutaTransmilenio(ruta: Ruta){
    this.transmilenio.rutas?.push(ruta);
    this.rutasNoAsignadas.splice(this.getIndex(this.rutasNoAsignadas, ruta), 1);
    this.transmilenioService.update(this.transmilenio).subscribe(response => {
    });
  }

  public eliminarRutaTransmilenio(ruta: Ruta){
    this.transmilenio.rutas?.splice(this.getIndex(this.transmilenio.rutas, ruta), 1);
    this.rutasNoAsignadas.push(ruta);
    this.transmilenioService.update(this.transmilenio).subscribe(response => {
    });
  }

  public getIndex(rutas: Ruta[], ruta: Ruta): number{
    let id: number = -1;
    let contador: number = 0;
    for(let rut of rutas){
      if(rut.id === ruta.id){
        id = contador;
      }
      contador++;
    }
    return id;
  }
}
