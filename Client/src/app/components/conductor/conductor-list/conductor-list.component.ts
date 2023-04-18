import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Conductor } from 'src/app/model/conductor/conductor';
import { ConductorService } from 'src/app/services/conductor/conductor.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-conductor-list',
  templateUrl: './conductor-list.component.html',
  styleUrls: ['./conductor-list.component.css']
})
export class ConductorListComponent implements OnInit {

  conductores: Conductor[] = [];
  constructor(
    private conductorService: ConductorService
  ) { }

  ngOnInit(): void {
    this.conductorService.findAll().subscribe(conductores => this.conductores = conductores);
  }

  public eliminarConductor(id: number) {
    
    Swal.fire({
      title: '¿Seguro de Eliminarlo?',
      text: "Eliminar este Conductor",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Sí'
    }).then((result) => {
      if (result.isConfirmed){
        this.conductorService.findAll().subscribe(response => {
          this.conductores = response;
          this.conductorService.findById(id).subscribe(conductor => {
            if (conductor?.transmilenios!.length >= 1) {
              Swal.fire({
                icon: 'error',
                title: 'No Eliminado',
                text: 'El Conductor ' + conductor.nombre +' no se puede eliminar porque tiene buses asignados.'
              })
            } else { 
              this.conductorService.delete(id).subscribe(response =>{
                this.conductores?.splice(this.getIndex(this.conductores, conductor), 1);
              });
              Swal.fire({
                position: 'top-end',
                icon: 'success',
                title: 'Conductor Eliminado',
                showConfirmButton: false,
                timer: 1500
              })
            }
        });
        },
          error => console.error(error));
      } 
    })
  }

  public getIndex(conductores: Conductor[], conductor: Conductor){
    let id: number = -1;
    let contador: number = 0;
    for(let cond of conductores){
      if(conductor.id === cond.id){
        id = contador;
      }
      contador++;
    }
    return id;
  }
}