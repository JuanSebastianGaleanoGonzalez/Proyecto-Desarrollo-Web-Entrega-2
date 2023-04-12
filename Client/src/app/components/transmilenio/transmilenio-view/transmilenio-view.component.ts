import { Component, OnInit } from '@angular/core';
import { Transmilenio } from 'src/app/model/transmilenio/transmilenio';
import { TransmilenioService } from 'src/app/services/transmilenio/transmilenio.service';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { Ruta } from 'src/app/model/ruta/ruta';

@Component({
  selector: 'app-transmilenio-view',
  templateUrl: './transmilenio-view.component.html',
  styleUrls: ['./transmilenio-view.component.css']
})
export class TransmilenioViewComponent implements OnInit {

  transmilenio: Transmilenio | undefined;
  rutasBus: Ruta[] | undefined;
  constructor(
    private transmilenioService: TransmilenioService,
    private route: ActivatedRoute // captura el parametro
    ) { } 

    ngOnInit(): void {
      //se recomienda switchMap para quedarse con el tultimo dato y manejar varias suscripciones
      this.route.paramMap.pipe(switchMap(params =>
       //cuando se tenga certeza que no es null agregar "!", "+" indica que es tipo numerico 
       this.transmilenioService.findById(+params.get('id')!)
       //otra forma cuando llegan un valor null automaticamente pone el numero 1 
       //this.personService.findById(+(params.get('id') || 1)) 
 
     )).subscribe(transmilenio => {
      this.transmilenio = transmilenio;
      this.rutasBus = this.transmilenio?.rutas;
    });
   }
}
