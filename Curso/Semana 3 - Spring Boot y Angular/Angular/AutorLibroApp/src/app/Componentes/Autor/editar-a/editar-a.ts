import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceWS } from '../../../Service/service-ws';
import { Autor } from '../../../Entidades/Autor';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-editar-a',
  imports: [],
  templateUrl: './editar-a.html',
  styleUrl: './editar-a.css'
})
export class EditarA {
  constructor(private router: Router, private service: ServiceWS){}

  autor: Autor = new Autor()

  ngOnInit(): void {
    
  }

  buscarA(){
    const autorString = localStorage.getItem('autor')
    if(autorString){
      const autor = JSON.parse(autorString)
      console.log(autor)
      this.autor = autor
    }
    this.service.buscarAWS(this.autor).subscribe(data => {
      this.autor = data
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

  editarA(){
    this.service.editarAWS(this.autor).subscribe(data => {
      Swal.fire({
        icon : "success",
        title: "EDITAR",
        text: `El autor ${this.autor.nombre} se edito correctamente`,
        showConfirmButton: false,
        timer: 2100
      })
      this.router.navigate(['listarP'])
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
