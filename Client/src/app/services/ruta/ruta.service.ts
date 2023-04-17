import { Injectable } from '@angular/core';
import {HttpClient,HttpHeaders} from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Ruta } from 'src/app/model/ruta/ruta';
import { Estacion } from 'src/app/model/estacion/estacion';
@Injectable({
  providedIn: 'root'
})
export class RutaService {
  private httpOptions = {
    headers: new HttpHeaders({
      "Content-Type": "application/json"
    })
  };

  private API_SERVER = "http://localhost:8080/ruta"

  constructor(private httpClient:HttpClient) { }

  findAll(): Observable<Ruta[]> {
    return this.httpClient.get<Ruta[]>(this.API_SERVER + `/read` ); //of convierte a Observable
  }
  findById(id: number): Observable<Ruta> {
    return this.httpClient.get(this.API_SERVER + `/read/${id}`);
  }
  public create(ruta: any): Observable<Ruta>{
    return this.httpClient.post<Ruta>(this.API_SERVER + `/create`, ruta, this.httpOptions);
  }

  public delete(id: number): Observable<Ruta>{
    return this.httpClient.delete<Ruta>(this.API_SERVER + `/delete/${id}`);
  }

  public update(ruta: any): Observable<Ruta>{
    return this.httpClient.put<Ruta>(this.API_SERVER + `/update`, ruta, this.httpOptions);
  }
}