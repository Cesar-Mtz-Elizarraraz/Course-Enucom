import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceWS } from '../../../Service/service-ws';
import { FormsModule } from '@angular/forms';
import { Autor } from '../../../Entidades/Autor';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-guardar-a',
  imports: [FormsModule],
  templateUrl: './guardar-a.html',
  styleUrl: './guardar-a.css'
})
export class GuardarA {
  constructor(private router: Router, private service: ServiceWS){}

  autor: Autor = new Autor()

  guardarA() {
    this.service.guardarAWS(this.autor).subscribe(data => {
      Swal.fire({
        icon : "success",
        title: "GUARDAR",
        text: "El registro se guardo con éxito",
        confirmButtonText: "OK"
      })
      this.router.navigate(['listarA'])
    }, error => {
      Swal.fire({
        icon : "error",
        title: "GUARDAR",
        text: "Ocurrió un error",
        confirmButtonText: "OK"
      })
      console.error(error)
    })
  }
}
