import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { ServiceWS } from '../../../Service/service-ws';
import { Padre } from '../../../Entidades/Padre';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-guardar-p',
  imports: [FormsModule],
  templateUrl: './guardar-p.html',
  styleUrl: './guardar-p.css'
})
export class GuardarP {
  constructor(private router: Router, private service: ServiceWS){}

  padre: Padre = new Padre()

  guardarP() {
    this.service.guardarPWS(this.padre).subscribe(data => {
      Swal.fire({
        icon : "success",
        title: "GUARDAR",
        text: JSON.stringify(data),
        confirmButtonText: "OK"
      })
      this.router.navigate(['listarP'])
    }, error => {
      Swal.fire({
        icon : "error",
        title: "GUARDAR",
        text: error.error,
        confirmButtonText: "OK"
      })
      console.error(error)
    })
  }
}
