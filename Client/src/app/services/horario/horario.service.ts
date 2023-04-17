import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Horario } from 'src/app/model/horario/horario';

@Injectable({
  providedIn: 'root'
})
export class HorarioService {

  private httpOptions = {
    headers: new HttpHeaders({
      "Content-Type": "application/json"
    })
  };
  
  private API_SERVER = "http://localhost:8080/horario"
  constructor(private http:HttpClient) { }

  public findAll(): Observable<Horario[]> {
    return this.http.get<Horario[]>(this.API_SERVER + `/read`);
  }
}
