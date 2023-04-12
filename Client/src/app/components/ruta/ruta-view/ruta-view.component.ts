import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { Ruta } from 'src/app/model/ruta/ruta';
import { RutaService } from 'src/app/services/ruta/ruta.service';

@Component({
  selector: 'app-ruta-view',
  templateUrl: './ruta-view.component.html',
  styleUrls: ['./ruta-view.component.css']
})
export class RutaViewComponent implements OnInit {

  ruta: Ruta | undefined;
  constructor(
    private rutaService: RutaService,
    private route: ActivatedRoute // captura el parametro
    ) { } 

    ngOnInit(): void {
      //se recomienda switchMap para quedarse con el tultimo dato y manejar varias suscripciones
      this.route.paramMap.pipe(switchMap(params =>
       //cuando se tenga certeza que no es null agregar "!", "+" indica que es tipo numerico 
       this.rutaService.findById(+params.get('id')!)
       //otra forma cuando llegan un valor null automaticamente pone el numero 1 
       //this.personService.findById(+(params.get('id') || 1)) 
     )).subscribe(ruta => this.ruta = ruta);
   }
}