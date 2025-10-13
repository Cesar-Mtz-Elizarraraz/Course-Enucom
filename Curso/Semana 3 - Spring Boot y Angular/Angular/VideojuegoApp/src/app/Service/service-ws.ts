import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Videojuego } from '../Entidad/Videojuego';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServiceWS {
  // Inyección de dependencias con un constructor
  constructor(private http : HttpClient){}

  url = 'http://localhost:8081/api/VJuego'

  // Declaración de los métodos para consumir los controladores del backend
  listarCWS(){
    return this.http.get<Videojuego[]>(`${this.url}/listar`)
  }

  guardarCWS(videojuego: Videojuego){
    return this.http.post<String>(`${this.url}/guardar`, videojuego)
  }

  editarCWS(videojuego: Videojuego){
    return this.http.put<String>(`${this.url}/editar`, videojuego)
  }

  buscarCWS(videojuego: Videojuego){
    return this.http.post<Videojuego>(`${this.url}/buscar`, videojuego)
  }

  eliminarCWS(videojuego: Videojuego): Observable<void>{
    return this.http.delete<void>(`${this.url}/eliminar`, {body: videojuego})
  }

}
