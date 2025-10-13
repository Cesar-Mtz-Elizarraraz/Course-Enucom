import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceWS } from '../../../Service/service-ws';
import { Libro } from '../../../Entidades/Libro';
import Swal from 'sweetalert2';
import { Autor } from '../../../Entidades/Autor';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-editar-l',
  imports: [FormsModule],
  templateUrl: './editar-l.html',
  styleUrl: './editar-l.css'
})
export class EditarL implements OnInit{
  constructor(private router: Router, private service: ServiceWS){}

  identificador: number | undefined;

  libro: Libro = new Libro();

  ngOnInit(): void {
    this.buscarLibro()
  }

  buscarLibro(){
    const libroString = localStorage.getItem('libro')
    if(libroString){
      const libro = JSON.parse(libroString)
      console.log(libro)
      this.libro = libro
      this.identificador = this.libro.autorId?.idAutor
    }
    this.service.buscarLWS(this.libro).subscribe(data => {
      this.libro = data
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

  editarLibro(){
    if(this.identificador){
      if(!this.libro.autorId){
        this.libro.autorId = new Autor()
      }
      this.libro.autorId.idAutor = this.identificador;
    }
    this.service.editarLWS(this.libro).subscribe(data => {
      Swal.fire({
        icon: "success",
        title: "EDITAR",
        text: `El libro ${this.libro.titulo} se edito correctamente`,
        showConfirmButton: false,
        timer: 2100
      })
      this.router.navigate(['listarL'])
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
