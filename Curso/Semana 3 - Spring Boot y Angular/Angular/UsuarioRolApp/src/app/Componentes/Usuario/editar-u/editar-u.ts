import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { ServiceWS } from '../../../Service/service-ws';
import { Usuario } from '../../../Entidades/Usuario';
import Swal from 'sweetalert2';
import { Rol } from '../../../Entidades/Rol';

@Component({
  selector: 'app-editar-u',
  imports: [FormsModule],
  templateUrl: './editar-u.html',
  styleUrl: './editar-u.css'
})
export class EditarU implements OnInit{
  constructor(private router: Router, private service: ServiceWS){}

  identificador?: number;

  usuario: Usuario = new Usuario();

  ngOnInit(): void {
    this.buscarUsuario()
  }

  buscarUsuario(){
    const usuarioString = localStorage.getItem('usuario')
    if(usuarioString){
      const usuario = JSON.parse(usuarioString)
      console.log(usuario)
      this.usuario = usuario
      this.identificador = this.usuario.rolId?.idRol
    }
    this.service.buscarUWS(this.usuario).subscribe(data => {
      this.usuario = data
      
      Swal.fire({
        title: "BUSCAR",
        icon: "success",
        text: "Información cargada",
        showConfirmButton: false,
        timer: 2000
      })  
    }, error => {
      Swal.fire({
        title: "BUSCAR",
        icon: "error",
        text: "Ocurrió un error",
        confirmButtonText: "OK"
      })  
    })
  }

  editarUsuario(){

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

    if(this.identificador){
      if(!this.usuario.rolId){
        this.usuario.rolId = new Rol()
      }
      this.usuario.rolId.idRol = this.identificador;
    }
    this.service.editarUWS(this.usuario).subscribe(data => {
      Swal.fire({
        icon: "success",
        title: "EDITAR",
        text: JSON.stringify(data),
        showConfirmButton: false,
        timer: 2100
      })
      this.router.navigate(['listarU'])
    }, error => {
      Swal.fire({
        icon : error.status == 302 ? "warning" : "error",
        title: "EDITAR",
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
