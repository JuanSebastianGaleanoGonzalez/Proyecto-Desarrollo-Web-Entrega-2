import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Transmilenio } from 'src/app/model/transmilenio/transmilenio';
import { Ruta } from 'src/app/model/ruta/ruta';

@Injectable({
  providedIn: 'root'
})
export class TransmilenioService {

  private API_SERVER = "http://localhost:8080/transmilenio"
  constructor(private httpClient: HttpClient) { }

  findAll(): Observable<Transmilenio> {
    return this.httpClient.get(this.API_SERVER + `/read` ); //of convierte a Observable
  }
  findById(id: number): Observable<Transmilenio> {
    return this.httpClient.get(this.API_SERVER + `/read/${id}`);
  }
}
