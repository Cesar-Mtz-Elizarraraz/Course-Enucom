import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { ServiceWS } from '../../../Service/service-ws';
import { Hijo } from '../../../Entidades/Hijo';
import { Padre } from '../../../Entidades/Padre';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-guardar-h',
  imports: [FormsModule],
  templateUrl: './guardar-h.html',
  styleUrl: './guardar-h.css'
})
export class GuardarH {
  constructor(private router: Router, private service: ServiceWS){}

  identificador: number | undefined;

  hijo: Hijo = new Hijo();

  guardarHijo(){
    if(this.identificador !== undefined){
      if(!this.hijo.padreId){
        this.hijo.padreId = new Padre()
      }
      this.hijo.padreId.idPadre = this.identificador;
    }
    this.service.guardarHWS(this.hijo).subscribe(data => {
      Swal.fire({
        icon: "success",
        title: "GUARDAR",
        text: JSON.stringify(data),
        showConfirmButton: false,
        timer: 2100
      })
      this.router.navigate(['listarH'])
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
