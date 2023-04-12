import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Ruta } from 'src/app/model/ruta/ruta';
import { Estacion } from 'src/app/model/estacion/estacion';
@Injectable({
  providedIn: 'root'
})
export class RutaService {

  constructor(private http:HttpClient) { }
  private rutaDB: { [key: number]: Ruta } = { //mapa quemado de base de datos
    1: new Ruta(123, [new Estacion("Marly"), new Estacion("Calle 45")]),
    2: new Ruta(1234, [new Estacion("Museo Nacional"), new Estacion("Jimenez"), new Estacion("Calle 39")]),
  };
  findAll(): Observable<Ruta[]> {
    return of(Object.values(this.rutaDB)); //of convierte a Observable
  }
  findById(id: number): Observable<Ruta> {
    return of(this.rutaDB[2]); // to avoid error, use type  : { [key: number]: Person } 
  }
}