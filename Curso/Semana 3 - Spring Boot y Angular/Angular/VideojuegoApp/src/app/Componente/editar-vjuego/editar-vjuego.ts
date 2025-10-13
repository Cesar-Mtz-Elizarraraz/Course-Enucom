import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ServiceWS } from '../../Service/service-ws';
import { Router } from '@angular/router';
import { Videojuego } from '../../Entidad/Videojuego';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-editar-vjuego',
  imports: [FormsModule],
  templateUrl: './editar-vjuego.html',
  styleUrl: './editar-vjuego.css'
})
export class EditarVJuego implements OnInit {
  constructor(private router: Router, private service : ServiceWS){}
  vjuego: Videojuego = new Videojuego()

  ngOnInit(): void {
    this.buscarVJuego()
  }

  buscarVJuego() {
    const vjuegoString = localStorage.getItem('vjuego')
    if(vjuegoString){
      const vjuego = JSON.parse(vjuegoString)
      console.log(vjuego)
      this.vjuego = vjuego
    }
    this.service.buscarCWS(this.vjuego).subscribe(data => {
      this.vjuego = data
      Swal.fire({
        title: "EDITAR",
        icon: "success",
        text: "Información cargada",
        showConfirmButton: false,
        timer: 2000
      })  
    }, error => {
      Swal.fire({
        title: "EDITAR",
        icon: "error",
        text: "Ocurrió un error",
        confirmButtonText: "OK"
      })  
    })
  }

  editarVJuego(){
    this.service.guardarCWS(this.vjuego).subscribe(data => {
      Swal.fire({
        icon : "success",
        title: "EDITAR",
        text: `El videojuego ${this.vjuego.nombre} fue editado correctamente`,
        confirmButtonText: "OK"
      })
      this.router.navigate(['listarVJ'])
      // console.log("DATA:" + this.compu)
    }, error => {
      Swal.fire({
        icon : "error",
        title: "EDITAR",
        text: "Ocurrió un error",
        confirmButtonText: "OK"
      })
      console.error(error)
    })
  }
}
