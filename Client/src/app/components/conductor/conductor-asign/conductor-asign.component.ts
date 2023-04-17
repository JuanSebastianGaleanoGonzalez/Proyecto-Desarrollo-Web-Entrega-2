import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { switchMap, toArray } from 'rxjs';
import { Conductor } from 'src/app/model/conductor/conductor';
import { Transmilenio } from 'src/app/model/transmilenio/transmilenio';
import { ConductorService } from 'src/app/services/conductor/conductor.service';
import { TransmilenioService } from 'src/app/services/transmilenio/transmilenio.service';

@Component({
  selector: 'app-conductor-asign',
  templateUrl: './conductor-asign.component.html',
  styleUrls: ['./conductor-asign.component.css']
})
export class ConductorAsignComponent implements OnInit {

  conductor: Conductor = new Conductor();
  transmilenios: Transmilenio[] = [];
  busesNoAsignados: Transmilenio[] = [];
  busesAsignados: Transmilenio[] = [];

  constructor(
    private transmilenioService: TransmilenioService,
    private conductorService: ConductorService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.route.paramMap.pipe(switchMap(params =>
      this.conductorService.findById(+params.get('id')!)
    )).subscribe(conductor => {
      this.conductor = conductor;
      this.busesAsignados = this.conductor.transmilenios!;
      this.transmilenioService.findAll().subscribe(resp => {
        this.transmilenios = resp;
        for (let bus of this.transmilenios) {
          if (!this.contains(this.conductor.transmilenios!, bus)) {
            this.busesNoAsignados.push(bus);
          }
        }
      });
    });
  }

  public contains(Array: Transmilenio[], object: Transmilenio): boolean{
    let comprobante: boolean = false;
    for(let obj of Array){
      if(obj.id === object.id){
        comprobante = true;
      }
    }
    return comprobante;
  }

  public agregarTransmilenioConductor(transmilenio: Transmilenio){
    this.busesNoAsignados.splice(this.busesNoAsignados.indexOf(transmilenio), 1);
    this.conductor.transmilenios?.push(transmilenio);
    this.conductorService.update(this.conductor).subscribe(response => {
    });
  }

  public eliminarTransmilenioConductor(transmilenio: Transmilenio){
    this.busesNoAsignados.push(transmilenio);
    this.conductor.transmilenios?.splice(this.conductor.transmilenios.indexOf(transmilenio), 1);
    this.conductorService.update(this.conductor).subscribe(response => {
    });
  }
}
