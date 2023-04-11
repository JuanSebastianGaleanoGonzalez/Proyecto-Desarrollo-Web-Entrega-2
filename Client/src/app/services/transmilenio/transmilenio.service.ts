import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Transmilenio } from 'src/app/model/transmilenio/transmilenio';

@Injectable({
  providedIn: 'root'
})
export class TransmilenioService {

  constructor(private http:HttpClient) { }
  private conductorDB: { [key: number]: Transmilenio } = { //mapa quemado de base de datos
    1: new Transmilenio(123,2020),
    2: new Transmilenio(123,2022),
  };
  findAll(): Observable<Transmilenio[]> {
    return of(Object.values(this.conductorDB)); //of convierte a Observable
  }
  findById(cedula: number): Observable<Transmilenio> {
    return of(this.conductorDB[1]); // to avoid error, use type  : { [key: number]: Person } 
  }
}