import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { switchMap } from 'rxjs';
import { Conductor } from 'src/app/model/conductor/conductor';
import { Transmilenio } from 'src/app/model/transmilenio/transmilenio';
import { ConductorService } from 'src/app/services/conductor/conductor.service';
import { TransmilenioService } from 'src/app/services/transmilenio/transmilenio.service';

@Component({
  selector: 'app-transmilenio-asign-conductor',
  templateUrl: './transmilenio-asign-conductor.component.html',
  styleUrls: ['./transmilenio-asign-conductor.component.css']
})
export class TransmilenioAsignConductorComponent implements OnInit {

  transmilenio: Transmilenio = new Transmilenio();
  conductoresNoAsignados: Conductor[] = [];
  conductoresAsignados: Conductor[] = [];

  constructor(
    private transmilenioService: TransmilenioService,
    private conductorService: ConductorService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.route.paramMap.pipe(switchMap(params =>
      this.transmilenioService.findById(+params.get('id')!)
    )).subscribe(transmilenio => {
      this.transmilenio = transmilenio;
      this.conductorService.findAll().subscribe(response => {
        for(let conductor of response){
          if(this.contains(conductor.transmilenios!, this.transmilenio)){
            this.conductoresAsignados.push(conductor);
          }else{
            this.conductoresNoAsignados.push(conductor);
          }
        }
      });
    });
  }

  public contains(transmilenios: Transmilenio[], transmilenio: Transmilenio): boolean{
    let comprobante = false;
    for(let trans of transmilenios){
      if(trans.id === transmilenio.id){
        comprobante = true;
      }
    }
    return comprobante;
  }

  public agregarConductorTransmilenio(conductor: Conductor){
    conductor.transmilenios?.push(this.transmilenio);
    this.conductoresAsignados.push(conductor);
    this.conductoresNoAsignados.splice(this.getIndex(this.conductoresNoAsignados, conductor), 1);
    this.conductorService.update(conductor).subscribe(response => {
    });
  }

  public eliminarConductorTransmilenio(conductor: Conductor){
    conductor.transmilenios?.splice(this.getIndex(conductor.transmilenios, this.transmilenio), 1);
    this.conductoresAsignados.splice(this.getIndex(this.conductoresAsignados, conductor), 1);
    this.conductoresNoAsignados.push(conductor);
    this.conductorService.update(conductor).subscribe(response => {
    });
  }

  public getIndex(conductores: any[], conductor: any): number{
    let id: number = -1;
    let contador: number = 0; 
    for(let cond of conductores){
      if(cond.id === conductor.id){
        id = contador;
      }
      contador++;
    }
    return id;
  }
}
