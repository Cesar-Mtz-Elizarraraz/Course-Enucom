import { Component, OnInit } from '@angular/core';
import { ServiceWS } from '../../../Service/service-ws';
import { Router } from '@angular/router';
import { Hijo } from '../../../Entidades/Hijo';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-listar-h',
  imports: [],
  templateUrl: './listar-h.html',
  styleUrl: './listar-h.css'
})
export class ListarH implements OnInit{
  constructor(private router: Router, private service: ServiceWS){}

  hijo: Hijo = new Hijo();
  hijos !: Hijo[]

  ngOnInit(): void {
    this.listarHijos()
  }

  listarHijos(){
    this.service.listarHWS().subscribe(data => {
      this.hijos = data;
    })
  }

  editarButton(hijo: Hijo) {
    localStorage.setItem('hijo', JSON.stringify(hijo));
    console.log(localStorage)
    this.router.navigate(['editarH'])
  }
  eliminarButton(hijo: Hijo) {
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
        this.service.eliminarHWS(hijo).subscribe(data => {
          Swal.fire({
            title: "¡Registro eliminado!",
            text: `El hijo ${hijo.nombre} fue eliminado correctamente`,
            icon: "success"
          });
          this.listarHijos()
        })
      } else {
        Swal.fire("La eliminación fue cancelada", "", "info")
      }
    })
  }
}
