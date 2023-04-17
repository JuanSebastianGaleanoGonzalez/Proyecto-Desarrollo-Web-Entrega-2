import { Component, OnInit } from '@angular/core';
import { Conductor } from 'src/app/model/conductor/conductor';
import { ConductorService } from 'src/app/services/conductor/conductor.service';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-conductor-view',
  templateUrl: './conductor-view.component.html',
  styleUrls: ['./conductor-view.component.css']
})
export class ConductorViewComponent implements OnInit {

  conductor: Conductor | undefined;

  constructor(
    private conductorService: ConductorService,
    private route: ActivatedRoute, // captura el parametro
    private router: Router) { } // redirecciona a otra ruta

  ngOnInit(): void {
     //se recomienda switchMap para quedarse con el tultimo dato y manejar varias suscripciones
    this.route.paramMap.pipe(switchMap(params =>
      //cuando se tenga certeza que no es null agregar "!", "+" indica que es tipo numerico 
    this.conductorService.findById(+params.get('id')!)
      //otra forma cuando llegan un valor null automaticamente pone el numero 1 
      //this.personService.findById(+(params.get('id') || 1)) 

    )).subscribe(conductor => this.conductor = conductor);
  }
}