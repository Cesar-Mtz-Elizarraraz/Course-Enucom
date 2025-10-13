import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cliente } from '../Entidades/Cliente';
import { Observable } from 'rxjs';
import { Veterinaria } from '../Entidades/Veterinaria';
import { Responsable, ResponsableVeterinaria } from '../Entidades/Responsable';
import { Mascota, MascotaCliResVet } from '../Entidades/Mascota';

@Injectable({
  providedIn: 'root'
})
export class ServiceWS {
  constructor(private http : HttpClient){}

  url = "http://localhost:9000"

  listarClienteWS(){
    return this.http.get<Cliente[]>(`${this.url}/cliente`)
  }

  guardarClienteWS(cliente: Cliente){
    return this.http.post(`${this.url}/cliente`, cliente, { responseType: "text" })
  }

  editarClienteWS(cliente: Cliente){
    return this.http.put(`${this.url}/cliente/${cliente.idCliente}`, cliente, { responseType: "text" })
  }

  buscarClienteWS(idCliente: number){
    return this.http.get<Cliente>(`${this.url}/cliente/${idCliente}`)
  }

  eliminarClienteWS(idCliente: number): Observable<Cliente>{
    return this.http.delete<Cliente>(`${this.url}/cliente/${idCliente}`)
  }


  listarVeterinariaWS(){
    return this.http.get<Veterinaria[]>(`${this.url}/veterinaria`)
  }

  guardarVeterinariaWS(veterinaria: Veterinaria){
    return this.http.post(`${this.url}/veterinaria`, veterinaria, { responseType: "text" })
  }

  editarVeterinariaWS(veterinaria: Veterinaria){
    return this.http.put(`${this.url}/veterinaria/${veterinaria.idVeterinaria}`, veterinaria, { responseType: "text" })
  }

  buscarVeterinariaWS(idVeterinaria: number){
    return this.http.get<Veterinaria>(`${this.url}/veterinaria/${idVeterinaria}`)
  }

  eliminarVeterinariaWS(idVeterinaria: number): Observable<Veterinaria>{
    return this.http.delete<Veterinaria>(`${this.url}/veterinaria/${idVeterinaria}`)
  }


  listarResponsableWS(){
    return this.http.get<ResponsableVeterinaria[]>(`${this.url}/responsable/listar`)
  }

  guardarResponsableWS(responsable: Responsable){
    return this.http.post(`${this.url}/responsable`, responsable, { responseType: "text" })
  }

  editarResponsableWS(responsable: Responsable){
    return this.http.put(`${this.url}/responsable/${responsable.idResponsable}`, responsable, { responseType: "text" })
  }

  buscarResponsableWS(idResponsable: number){
    return this.http.get<Responsable>(`${this.url}/responsable/${idResponsable}`)
  }

  eliminarResponsableWS(idResponsable: number): Observable<Responsable>{
    return this.http.delete<Responsable>(`${this.url}/responsable/${idResponsable}`)
  }


  listarMascotaWS(){
    return this.http.get<MascotaCliResVet[]>(`${this.url}/mascota/listar`)
  }

  guardarMascotaWS(mascota: Mascota){
    return this.http.post(`${this.url}/mascota`, mascota, { responseType: "text" })
  }

  editarMascotaWS(mascota: Mascota){
    return this.http.put(`${this.url}/mascota/${mascota.idMascota}`, mascota, { responseType: "text" })
  }

  buscarMascotaWS(idMascota: number){
    return this.http.get<Mascota>(`${this.url}/mascota/${idMascota}`)
  }

  eliminarMascotaWS(idMascota: number): Observable<Mascota>{
    return this.http.delete<Mascota>(`${this.url}/mascota/${idMascota}`)
  }
}
