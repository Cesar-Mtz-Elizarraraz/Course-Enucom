import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { ServiceWS } from '../../../Service/service-ws';
import { Libro } from '../../../Entidades/Libro';
import { Autor } from '../../../Entidades/Autor';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-guardar-l',
  imports: [FormsModule],
  templateUrl: './guardar-l.html',
  styleUrl: './guardar-l.css'
})
export class GuardarL {
  constructor(private router: Router, private service: ServiceWS){}

  identificador?: number;

  libro: Libro = new Libro();

  guardarLibro(){
    if(this.identificador){
      if(this.libro.autorId){
        this.libro.autorId = new Autor()
      }
      this.libro.autorId.idAutor = this.identificador;
    }
    this.service.guardarLWS(this.libro).subscribe(data => {
      Swal.fire({
        icon: "success",
        title: "GUARDAR",
        text: JSON.stringify(data),
        showConfirmButton: false,
        timer: 2100
      })
      this.router.navigate(['listarL'])
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
