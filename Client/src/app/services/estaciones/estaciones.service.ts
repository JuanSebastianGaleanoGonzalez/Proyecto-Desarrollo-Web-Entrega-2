import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Estacion } from 'src/app/model/estacion/estacion';

@Injectable({
  providedIn: 'root'
})
export class EstacionesService {

  private httpOptions = {
    headers: new HttpHeaders({
      "Content-Type": "application/json"
    })
  };
  
  private API_SERVER = "http://localhost:8080/estacion"
  constructor(private http:HttpClient) { }

  public findAll(): Observable<Estacion[]> {
    return this.http.get<Estacion[]>(this.API_SERVER + `/read`);
  }
}