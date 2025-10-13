import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { ServiceWS } from '../../../Service/service-ws';
import { Rol } from '../../../Entidades/Rol';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-editar-r',
  imports: [FormsModule],
  templateUrl: './editar-r.html',
  styleUrl: './editar-r.css'
})
export class EditarR implements OnInit {
  constructor(private router: Router, private service: ServiceWS){}

  rol: Rol = new Rol()

  ngOnInit(): void {
    this.buscarP()
  }

  buscarP(){
    const rolString = localStorage.getItem('rol')
    if(rolString){
      const rol = JSON.parse(rolString)
      console.log(rol)
      this.rol = rol
    }
    this.service.buscarRWS(this.rol).subscribe(data => {
      this.rol = data
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

  editarRol(){

    if(!this.rol.idRol || !this.rol.privilegio){
      Swal.fire({
        icon: "warning",
        title: "Formulario incompleto",
        html: `Todos los campos marcados con <span style="color:red; font-weight:bold">*</span> son obligatorios`,
        confirmButtonText: "Aceptar"
      });
      return
    }

    this.service.editarRWS(this.rol).subscribe(data => {
      Swal.fire({
        icon : "success",
        title: "EDITAR",
        text: JSON.stringify(data),
        showConfirmButton: false,
        timer: 2100
      })
      this.router.navigate(['listarR'])
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
}
