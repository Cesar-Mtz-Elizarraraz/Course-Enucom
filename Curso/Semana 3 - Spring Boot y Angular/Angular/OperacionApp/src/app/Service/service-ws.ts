import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Operacion } from '../Entidades/Operacion';

@Injectable({
  providedIn: 'root'
})
export class ServiceWS {
  constructor(private http : HttpClient){}

  url = "http://localhost:8081/api/operacion"

  guardarOWS(operacion: Operacion){
    return this.http.post<String>(this.url, operacion, 
      {responseType: "text" as "json"})
  }
}
