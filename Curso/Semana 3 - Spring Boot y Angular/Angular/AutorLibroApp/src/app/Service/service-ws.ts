import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Autor } from '../Entidades/Autor';
import { Observable } from 'rxjs';
import { Libro } from '../Entidades/Libro';

@Injectable({
  providedIn: 'root'
})
export class ServiceWS {
  constructor(private http : HttpClient){}

  url = "http://localhost:8001/api"

  listarAWS(){
    return this.http.get<Autor[]>(`${this.url}/Autor/listar`)
  }

  guardarAWS(autor: Autor){
    return this.http.post<String>(`${this.url}/Autor/guardar`, autor)
  }

  editarAWS(autor: Autor){
    return this.http.post<String>(`${this.url}/Autor/editar`, autor)
  }

  buscarAWS(autor: Autor){
    return this.http.post<Autor>(`${this.url}/Autor/buscar`, autor)
  }

  eliminarAWS(autor: Autor): Observable<void>{
    return this.http.delete<void>(`${this.url}/Autor/eliminar`, {body: autor})
  }

  listarLWS(){
    return this.http.get<Libro[]>(`${this.url}/Libro/listar`)
  }

  guardarLWS(libro: Libro){
    return this.http.post<String>(`${this.url}/Libro/guardar`, libro)
  }

  editarLWS(libro: Libro){
    return this.http.post<String>(`${this.url}/Libro/editar`, libro)
  }

  buscarLWS(libro: Libro){
    return this.http.post<Libro>(`${this.url}/Libro/buscar`, libro)
  }

  eliminarLWS(libro: Libro): Observable<void>{
    return this.http.delete<void>(`${this.url}/Libro/eliminar`, {body: libro})
  }
}
