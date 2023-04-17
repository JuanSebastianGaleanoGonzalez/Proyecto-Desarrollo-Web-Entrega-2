import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Conductor } from 'src/app/model/conductor/conductor';
import { ConductorService } from 'src/app/services/conductor/conductor.service';

@Component({
  selector: 'app-conductor-list',
  templateUrl: './conductor-list.component.html',
  styleUrls: ['./conductor-list.component.css']
})
export class ConductorListComponent implements OnInit {

  conductores: any;
  constructor(
    private conductorService: ConductorService
  ) { }

  ngOnInit(): void {
    this.conductorService.findAll().subscribe(conductores => this.conductores = conductores);
  }

  public eliminarConductor(id: number) {
    this.conductorService.findById(id).subscribe(conductor => {
      if (conductor?.transmilenios!.length >= 1) {
        window.alert(`El conductor ${conductor.nombre} no se puede eliminar porque tiene buses asignados.`);
      } else { 
        this.conductorService.delete(id).subscribe(response =>{
          console.log(response);  
        });
        this.conductores?.splice(this.conductores?.indexOf(conductor), 1);
      }
    },
      error => console.error(error));
  }
}
