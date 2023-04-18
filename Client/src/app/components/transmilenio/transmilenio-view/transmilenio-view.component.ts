import { Component, OnInit } from '@angular/core';
import { Transmilenio } from 'src/app/model/transmilenio/transmilenio';
import { TransmilenioService } from 'src/app/services/transmilenio/transmilenio.service';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { Ruta } from 'src/app/model/ruta/ruta';
import { Conductor } from 'src/app/model/conductor/conductor';
import { ConductorService } from 'src/app/services/conductor/conductor.service';

@Component({
  selector: 'app-transmilenio-view',
  templateUrl: './transmilenio-view.component.html',
  styleUrls: ['./transmilenio-view.component.css']
})
export class TransmilenioViewComponent implements OnInit {

  transmilenio: Transmilenio = new Transmilenio();
  rutasBus: Ruta[] = [];
  conductoresTransmilenio: Conductor[] = [];

  constructor(
    private transmilenioService: TransmilenioService,
    private conductorService: ConductorService,
    private route: ActivatedRoute
    ) { } 

    ngOnInit(): void {
      this.route.paramMap.pipe(switchMap(params =>
       this.transmilenioService.findById(+params.get('id')!)
     )).subscribe(transmilenio => {
      this.transmilenio = transmilenio;
      this.rutasBus = this.transmilenio.rutas!;
      this.conductorService.findAll().subscribe(response => {
        for(let conductor of response){
          if(this.contains(conductor, this.transmilenio)){
            this.conductoresTransmilenio.push(conductor);
          }
        }
      });
    });
   }

   public contains(conductor: Conductor, transmilenio: Transmilenio): boolean{
    let comprobante = false;
    for(let trans of conductor.transmilenios!){
      if(trans.id === transmilenio.id){
        comprobante = true;
      }
    }
    return comprobante;
   }
}
