import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { switchMap } from 'rxjs';
import { Horario } from 'src/app/model/horario/horario';
import { Ruta } from 'src/app/model/ruta/ruta';
import { HorarioService } from 'src/app/services/horario/horario.service';
import { RutaService } from 'src/app/services/ruta/ruta.service';

@Component({
  selector: 'app-ruta-asign-horario',
  templateUrl: './ruta-asign-horario.component.html',
  styleUrls: ['./ruta-asign-horario.component.css']
})
export class RutaAsignHorarioComponent implements OnInit {

  ruta: Ruta = new Ruta();
  horariosAsignados: Horario[] = [];
  horariosNoAsignados: Horario[] = [];

  constructor(
    private rutaService: RutaService,
    private horarioService: HorarioService,
    private route: ActivatedRoute
  ) {} 

  ngOnInit(): void {
    this.route.paramMap.pipe(switchMap(params =>
      this.rutaService.findById(+params.get('id')!)
    )).subscribe(ruta => {
      this.ruta = ruta;
      this.horarioService.findAll().subscribe(response => {
        for(let horario of response){
          if(this.contains(ruta, horario)){
            this.horariosAsignados.push(horario);
          }else{
            this.horariosNoAsignados.push(horario);
          }
        }
      });
    });
  }

  public contains(ruta: Ruta, horario: Horario): boolean{
    let comprobante = false;
    for(let hor of ruta.horarios!){
      if(hor.id === horario.id){
        comprobante = true;
      }
    }
    return comprobante;
  }
  
  public agregarHorarioRuta(horario: Horario) {
    this.horariosNoAsignados.splice(this.horariosNoAsignados.indexOf(horario), 1);
    this.horariosAsignados.push(horario);
    this.ruta.horarios?.push(horario);
    this.rutaService.update(this.ruta).subscribe(response => {
    });
  }

  public eliminarHorarioRuta(horario: Horario) {
    this.horariosAsignados.splice(this.horariosAsignados.indexOf(horario), 1);
    this.ruta.horarios?.splice(this.ruta.horarios.indexOf(horario), 1);
    this.horariosNoAsignados.push(horario);
    this.rutaService.update(this.ruta).subscribe(response => {
    });
  }
}
