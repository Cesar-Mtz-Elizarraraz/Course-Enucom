import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Computadora } from '../Entidad/Computadora';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
// Es el que se encargara de consumir los controladores del Backend
export class ServiceWS {
  // Inyección de dependencias con un constructor
  constructor(private http : HttpClient){}

  // Configuración del url del WebService
  url = 'http://localhost:8081/api/Compu'

  // Declaración de los métodos para consumir los controladores del backend
  listarCWS(){
    return this.http.get<Computadora[]>(`${this.url}/listar`)
  }

  guardarCWS(computadora: Computadora){
    return this.http.post<String>(`${this.url}/guardar`, computadora)
  }

  editarCWS(computadora: Computadora){
    return this.http.post<String>(`${this.url}/editar`, computadora)
  }

  buscarCWS(computadora: Computadora){
    return this.http.post<Computadora>(`${this.url}/buscar`, computadora)
  }

  eliminarCWS(computadora: Computadora): Observable<void>{
    return this.http.delete<void>(`${this.url}/eliminar`, {body: computadora})
  }
}
