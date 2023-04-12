import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Transmilenio } from 'src/app/model/transmilenio/transmilenio';
import { Ruta } from 'src/app/model/ruta/ruta';
import { Estacion } from 'src/app/model/estacion/estacion';

@Injectable({
  providedIn: 'root'
})
export class TransmilenioService {

  constructor(private http:HttpClient) { }
  private conductorDB: { [key: number]: Transmilenio } = { //mapa quemado de base de datos
    1: new Transmilenio(123,2020, [new Ruta(123, [new Estacion("Marly"), new Estacion("Calle 45")])]),
    2: new Transmilenio(123,2022, [new Ruta(123, [new Estacion("Marly"), new Estacion("Calle 45")]), new Ruta(1234, [new Estacion("Museo Nacional"), new Estacion("Jimenez"), new Estacion("Calle 39")])]),
  };
  findAll(): Observable<Transmilenio[]> {
    return of(Object.values(this.conductorDB)); //of convierte a Observable
  }
  findById(cedula: number): Observable<Transmilenio> {
    return of(this.conductorDB[2]); // to avoid error, use type  : { [key: number]: Person } 
  }
}