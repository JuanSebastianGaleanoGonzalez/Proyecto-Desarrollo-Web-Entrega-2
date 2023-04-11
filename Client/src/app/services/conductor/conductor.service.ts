import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Conductor } from 'src/app/model/conductor/conductor';
@Injectable({
  providedIn: 'root'
})
export class ConductorService {

  private API_SERVER = "http://localhost:8080/conductor"
  constructor(private httpClient:HttpClient) { }

  findAll(): Observable<Conductor> {
    return this.httpClient.get(this.API_SERVER + "/read");
  }
  findById(id: number): Observable<Conductor> {
    return this.httpClient.get(`http://localhost:8080/conductor/read/${id}`); 
  }
}