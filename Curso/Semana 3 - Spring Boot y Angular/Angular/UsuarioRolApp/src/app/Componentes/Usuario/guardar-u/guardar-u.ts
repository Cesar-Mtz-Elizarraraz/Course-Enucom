import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceWS } from '../../../Service/service-ws';
import { FormsModule } from '@angular/forms';
import { Usuario } from '../../../Entidades/Usuario';
import { Rol } from '../../../Entidades/Rol';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-guardar-u',
  imports: [FormsModule],
  templateUrl: './guardar-u.html',
  styleUrl: './guardar-u.css'
})
export class GuardarU implements OnInit{
  constructor(private router: Router, private service: ServiceWS){}

  identificador?: number;

  usuario: Usuario = new Usuario();

  ngOnInit(): void {
    this.generarCorreo()
  }

  guardarUsuario(){

    if(!this.usuario.idUsuario || !this.usuario.nombre || !this.usuario.app || !this.usuario.apm ||
      !this.usuario.correo || !this.usuario.sexo || !this.usuario.fechaNacimiento){
      Swal.fire({
        icon: "warning",
        title: "Formulario incompleto",
        html: `Todos los campos marcados con <span style="color:red; font-weight:bold">*</span> son obligatorios`,
        confirmButtonText: "Aceptar"
      });
      return
    }

    if(this.identificador !== undefined){
      if(!this.usuario.rolId){
        this.usuario.rolId = new Rol()
      }
      this.usuario.rolId.idRol = this.identificador;
    }

    this.service.guardarUWS(this.usuario).subscribe(data => {
      Swal.fire({
        icon: "success",
        title: "GUARDAR",
        text: JSON.stringify(data),
        showConfirmButton: false,
        timer: 2100
      })
      this.router.navigate(['listarU'])
    }, error => {
      Swal.fire({
        icon : error.status == 302 ? "warning" : "error",
        title: "GUARDAR",
        text: error.error,
        confirmButtonText: "OK"
      })
      console.error(error)
    })
  }

  generarCorreo() {
    this.usuario.correo = `${this.#purgarCaracteres(this.usuario.nombre) || ''}.${this.#purgarCaracteres(this.usuario.app) || ''}@enucom.com.mx`.toLocaleLowerCase()
  }

  #purgarCaracteres(cadena: String){
    if(!cadena) return ""
    cadena = cadena.replace(/[^A-Za-zÁÉÍÓÚáéíóúÑñ]/g, "");
    return cadena
  }
}
