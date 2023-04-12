import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Ruta } from 'src/app/model/ruta/ruta';
import { Estacion } from 'src/app/model/estacion/estacion';
@Injectable({
  providedIn: 'root'
})
export class RutaService {

  private API_SERVER = "http://localhost:8080/ruta"

  constructor(private httpClient:HttpClient) { }

  findAll(): Observable<Ruta> {
    return this.httpClient.get(this.API_SERVER + `/read` ); //of convierte a Observable
  }
  findById(id: number): Observable<Ruta> {
    return this.httpClient.get(this.API_SERVER + `/read/${id}`);
  }
}