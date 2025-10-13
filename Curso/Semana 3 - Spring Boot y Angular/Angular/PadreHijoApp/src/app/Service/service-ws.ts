import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Padre } from '../Entidades/Padre';
import { Observable } from 'rxjs';
import { Hijo } from '../Entidades/Hijo';

@Injectable({
  providedIn: 'root'
})
export class ServiceWS {
  constructor(private http : HttpClient){}

  url = "http://localhost:8001/api"

  listarPWS(){
    return this.http.get<Padre[]>(`${this.url}/Padre/listar`)
  }

  guardarPWS(padre: Padre){
    return this.http.post<String>(`${this.url}/Padre/guardar`, padre, 
      {responseType: "text" as "json"})
  }

  editarPWS(padre: Padre){
    return this.http.post<String>(`${this.url}/Padre/editar`, padre)
  }

  buscarPWS(padre: Padre){
    return this.http.post<Padre>(`${this.url}/Padre/buscar`, padre)
  }

  eliminarPWS(padre: Padre): Observable<void>{
    return this.http.delete<void>(`${this.url}/Padre/eliminar`, {body: padre})
  }

  listarHWS(){
    return this.http.get<Hijo[]>(`${this.url}/Hijo/listar`)
  }

  guardarHWS(hijo: Hijo){
    return this.http.post<String>(`${this.url}/Hijo/guardar`, hijo, 
      {responseType: "text" as "json"})
  }

  editarHWS(hijo: Hijo){
    return this.http.post<String>(`${this.url}/Hijo/editar`, hijo)
  }

  buscarHWS(hijo: Hijo){
    return this.http.post<Hijo>(`${this.url}/Hijo/buscar`, hijo)
  }

  eliminarHWS(hijo: Hijo): Observable<void>{
    return this.http.delete<void>(`${this.url}/Hijo/eliminar`, {body: hijo})
  }
}
