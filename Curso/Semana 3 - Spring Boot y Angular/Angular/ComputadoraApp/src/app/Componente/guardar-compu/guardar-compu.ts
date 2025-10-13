import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { ServiceWS } from '../../Service/service-ws';
import { Computadora } from '../../Entidad/Computadora';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-guardar-compu',
  imports: [FormsModule], // FormsModule: AYudara a usar la directiva ngModule
  templateUrl: './guardar-compu.html',
  styleUrl: './guardar-compu.css'
})
export class GuardarCompu {
  constructor(private router: Router, private service : ServiceWS){}

  compu: Computadora = new Computadora()

  // Crear un método para la función de enviar al guardar el objeto en la BD
  guardarC(){
    this.service.guardarCWS(this.compu).subscribe(data => {
      Swal.fire({
        icon : "success",
        title: "GUARDAR",
        text: "El registro se guardo con éxito",
        confirmButtonText: "OK"
      })
      this.router.navigate(['listarC'])
      // console.log("DATA:" + this.compu)
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
