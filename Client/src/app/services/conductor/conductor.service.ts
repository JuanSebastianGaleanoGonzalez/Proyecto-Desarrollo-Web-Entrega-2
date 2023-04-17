import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Conductor } from 'src/app/model/conductor/conductor';
@Injectable({
  providedIn: 'root'
})
export class ConductorService {


  private httpOptions = {
    headers: new HttpHeaders({
      "Content-Type": "application/json"
    })
  };
  
  private API_SERVER = "http://localhost:8080/conductor"
  constructor(private httpClient:HttpClient) { }

  public findAll(): Observable<Conductor[]> {
    return this.httpClient.get<Conductor[]>(this.API_SERVER + `/read`);
  }
  public findById(id: number): Observable<Conductor> {
    return this.httpClient.get(this.API_SERVER + `/read/${id}`); 
  }

  public create(conductor: any): Observable<Conductor>{
    return this.httpClient.post<Conductor>(this.API_SERVER + `/create`, conductor, this.httpOptions);
  }

  public delete(id: number): Observable<Conductor>{
    return this.httpClient.delete(this.API_SERVER + `/delete/${id}`);
  }

  public update(conductor: any): Observable<Conductor>{
    return this.httpClient.put<Conductor>(this.API_SERVER + `/update`, conductor, this.httpOptions);
  }
}