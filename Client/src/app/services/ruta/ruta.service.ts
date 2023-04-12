import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Ruta } from 'src/app/model/ruta/ruta';
@Injectable({
  providedIn: 'root'
})
export class RutaService {

  constructor(private http:HttpClient) { }
  private rutaDB: { [key: number]: Ruta } = { //mapa quemado de base de datos
    1: new Ruta(123),
    2: new Ruta(1234),
  };
  findAll(): Observable<Ruta[]> {
    return of(Object.values(this.rutaDB)); //of convierte a Observable
  }
  findById(id: number): Observable<Ruta> {
    return of(this.rutaDB[1]); // to avoid error, use type  : { [key: number]: Person } 
  }
}
