import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Transmilenio } from 'src/app/model/transmilenio/transmilenio';

@Injectable({
  providedIn: 'root'
})
export class TransmilenioService {
  private httpOptions = {
    headers: new HttpHeaders({
      "Content-Type": "application/json"
    })
  };
  private API_SERVER = "http://localhost:8080/transmilenio"
  constructor(private httpClient: HttpClient) { }

  findAll(): Observable<Transmilenio[]> {
    return this.httpClient.get<Transmilenio[]>(this.API_SERVER + `/read` ); //of convierte a Observable
  }
  findById(id: number): Observable<Transmilenio> {
    return this.httpClient.get(this.API_SERVER + `/read/${id}`);
  }
  public create(transmilenio: any): Observable<Transmilenio>{
    return this.httpClient.post<Transmilenio>(this.API_SERVER + `/create`, transmilenio, this.httpOptions);
  }

  public delete(id: number): Observable<Transmilenio>{
    return this.httpClient.delete(this.API_SERVER + `/delete/${id}`);
  }

  public update(transmilenio: any): Observable<Transmilenio>{
    return this.httpClient.put<Transmilenio>(this.API_SERVER + `/update`, transmilenio, this.httpOptions);
  }
}
