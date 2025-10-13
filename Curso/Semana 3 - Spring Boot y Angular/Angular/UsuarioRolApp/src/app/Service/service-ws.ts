import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Rol } from '../Entidades/Rol';
import { Observable } from 'rxjs';
import { Usuario } from '../Entidades/Usuario';

@Injectable({
  providedIn: 'root'
})
export class ServiceWS {
  constructor(private http : HttpClient){}

  url = "http://localhost:8002/api"

  listarRWS(){
    return this.http.get<Rol[]>(`${this.url}/Rol/listar`)
  }

  guardarRWS(rol: Rol){
    return this.http.post<String>(`${this.url}/Rol/guardar`, rol, 
      {responseType: "text" as "json"})
  }

  editarRWS(rol: Rol){
    return this.http.post<String>(`${this.url}/Rol/editar`, rol,
      {responseType: "text" as "json"}
    )
  }

  buscarRWS(rol: Rol){
    return this.http.post<Rol>(`${this.url}/Rol/buscar`, rol)
  }

  eliminarRWS(rol: Rol): Observable<void>{
    return this.http.delete<void>(`${this.url}/Rol/eliminar`, {body: rol})
  }

  listarUWS(){
    return this.http.get<Usuario[]>(`${this.url}/Usuario/listar`)
  }

  guardarUWS(usuario: Usuario){
    return this.http.post<String>(`${this.url}/Usuario/guardar`, usuario, 
      {responseType: "text" as "json"})
  }

  editarUWS(usuario: Usuario){
    return this.http.post<String>(`${this.url}/Usuario/editar`, usuario,
      {responseType: "text" as "json"}
    )
  }

  buscarUWS(usuario: Usuario){
    return this.http.post<Usuario>(`${this.url}/Usuario/buscar`, usuario)
  }

  eliminarUWS(usuario: Usuario): Observable<void>{
    return this.http.delete<void>(`${this.url}/Usuario/eliminar`, {body: usuario})
  }
}
