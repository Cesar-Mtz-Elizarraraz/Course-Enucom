import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { ServiceWS } from '../../Service/service-ws';
import { Videojuego } from '../../Entidad/Videojuego';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-guardar-vjuego',
  imports: [FormsModule],
  templateUrl: './guardar-vjuego.html',
  styleUrl: './guardar-vjuego.css'
})
export class GuardarVJuego {
  constructor(private router: Router, private service : ServiceWS){}

  vjuego: Videojuego = new Videojuego()

  // MÉTODO GUARDAR
  guardarVJ(){
    this.service.guardarCWS(this.vjuego).subscribe(data => {
      Swal.fire({
        icon : "success",
        title: "GUARDAR",
        text: "El registro se guardo con éxito",
        confirmButtonText: "OK"
      })
      this.router.navigate(['listarVJ'])
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
