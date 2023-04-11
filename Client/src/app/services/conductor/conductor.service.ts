import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Conductor } from 'src/app/model/conductor/conductor';
@Injectable({
  providedIn: 'root'
})
export class ConductorService {

  constructor(private http:HttpClient) { }

  private conductorDB: { [key: number]: Conductor } = { //mapa quemado de base de datos
    1: new Conductor('Anderson', 123,123,'universidad'),
    2: new Conductor('Sebastian Galeano', 123,123,'calle'),
  };
  findAll(): Observable<Conductor[]> {
    return of(Object.values(this.conductorDB)); //of convierte a Observable
  }
  findById(cedula: number): Observable<Conductor> {
    return of(this.conductorDB[1]); // to avoid error, use type  : { [key: number]: Person } 
  }
}