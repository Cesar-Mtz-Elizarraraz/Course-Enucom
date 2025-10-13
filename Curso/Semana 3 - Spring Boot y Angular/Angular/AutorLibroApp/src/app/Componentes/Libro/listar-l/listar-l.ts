import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceWS } from '../../../Service/service-ws';
import { Libro } from '../../../Entidades/Libro';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-listar-l',
  imports: [],
  templateUrl: './listar-l.html',
  styleUrl: './listar-l.css'
})
export class ListarL {
  constructor(private router: Router, private service: ServiceWS){}

  libro: Libro = new Libro();
  libros !: Libro[]

  ngOnInit(): void {
    this.listarLibros()
  }

  listarLibros(){
    this.service.listarLWS().subscribe(data => {
      this.libros = data;
    })
  }

  editarButton(libro: Libro) {
    localStorage.setItem('libro', JSON.stringify(libro));
    console.log(localStorage)
    this.router.navigate(['editarL'])
  }
  eliminarButton(libro: Libro) {
    Swal.fire({
      title: "¿Está seguro de querer eliminar el registro?",
      text: "¡Este movimiento no se podrá revertir!",
      icon: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: "Si, ¡Eliminar!",
      cancelButtonText: "Cancelar"
    }).then((result) => {
      if (result.isConfirmed) {
        this.service.eliminarLWS(libro).subscribe(data => {
          Swal.fire({
            title: "¡Registro eliminado!",
            text: `El libro ${libro.titulo} fue eliminado correctamente`,
            icon: "success"
          });
          this.listarLibros()
        })
      } else {
        Swal.fire("La eliminación fue cancelada", "", "info")
      }
    })
  }
}
