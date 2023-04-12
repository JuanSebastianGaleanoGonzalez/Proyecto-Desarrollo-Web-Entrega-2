import { Component, OnInit,Input } from '@angular/core';
import { Estacion } from 'src/app/model/estacion/estacion';
import { EstacionesService } from 'src/app/services/estaciones/estaciones.service';

@Component({
  selector: 'app-estacion-list',
  templateUrl: './estacion-list.component.html',
  styleUrls: ['./estacion-list.component.css']
})
export class EstacionListComponent implements OnInit {

  @Input()
  estaciones: Estacion[] | undefined;
  
  constructor(
   // private estacionService: EstacionesService
  ) { }

  ngOnInit(): void {
    //this.estacionService.findAll().subscribe(estaciones => this.estaciones = estaciones);
  }
}