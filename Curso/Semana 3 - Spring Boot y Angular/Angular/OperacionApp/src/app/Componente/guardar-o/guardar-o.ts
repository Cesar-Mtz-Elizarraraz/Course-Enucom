import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { ServiceWS } from '../../Service/service-ws';
import { Operacion } from '../../Entidades/Operacion';
import Swal from 'sweetalert2';
import * as CryptoJS from 'crypto-js';

@Component({
  selector: 'app-guardar-o',
  imports: [FormsModule],
  templateUrl: './guardar-o.html',
  styleUrl: './guardar-o.css'
})
export class GuardarO {
  constructor(private router: Router, private service: ServiceWS){}

  operacion: Operacion = new Operacion();

  guardarOperacion(){

    if(!this.operacion.operacion || !this.operacion.cliente || !this.operacion.importe){
      Swal.fire({
        icon: "warning",
        title: "Formulario incompleto",
        html: `Todos los campos marcados con <span style="color:red; font-weight:bold">*</span> son obligatorios`,
        confirmButtonText: "Aceptar"
      });
      return
    }
    const cadena = `${this.operacion.operacion}${this.operacion.importe.toFixed(2)}${this.operacion.cliente}`;
    this.operacion.sha = CryptoJS.SHA512(cadena).toString(CryptoJS.enc.Base64)
    this.service.guardarOWS(this.operacion).subscribe(data => {
      Swal.fire({
        icon: "success",
        title: "GUARDAR",
        text: "La operación fue registrada correctamente",
        showConfirmButton: false,
        timer: 2100
      })
      console.log(data)
      this.operacion = new Operacion()
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
