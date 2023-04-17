import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Estacion } from 'src/app/model/estacion/estacion';

@Injectable({
  providedIn: 'root'
})
export class EstacionesService {

  constructor(private http:HttpClient) { }
  private estacionDB: { [key: number]: Estacion } = { //mapa quemado de base de datos
    1: new Estacion("Marly"),
    2: new Estacion("Calle 45"),
  };
  findAll(): Observable<Estacion[]> {
    return of(Object.values(this.estacionDB)); //of convierte a Observable
  }
}