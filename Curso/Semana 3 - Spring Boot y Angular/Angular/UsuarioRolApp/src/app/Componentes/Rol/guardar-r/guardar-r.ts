import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { ServiceWS } from '../../../Service/service-ws';
import { Rol } from '../../../Entidades/Rol';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-guardar-r',
  imports: [FormsModule],
  templateUrl: './guardar-r.html',
  styleUrl: './guardar-r.css'
})
export class GuardarR {
  constructor(private router: Router, private service: ServiceWS){}

  rol: Rol = new Rol()

  guardarRol() {

    if(!this.rol.idRol || !this.rol.privilegio){
      Swal.fire({
        icon: "warning",
        title: "Formulario incompleto",
        html: `Todos los campos marcados con <span style="color:red; font-weight:bold">*</span> son obligatorios`,
        confirmButtonText: "Aceptar"
      });
      return
    }

    this.service.guardarRWS(this.rol).subscribe(data => {
      Swal.fire({
        icon : "success",
        title: "GUARDAR",
        text: JSON.stringify(data),
        confirmButtonText: "OK"
      })
      this.router.navigate(['listarR'])
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
}
