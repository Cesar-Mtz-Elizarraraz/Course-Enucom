import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { ServiceWS } from '../../../Service/service-ws';
import { Hijo } from '../../../Entidades/Hijo';
import Swal from 'sweetalert2';
import { Padre } from '../../../Entidades/Padre';

@Component({
  selector: 'app-editar-h',
  imports: [FormsModule],
  templateUrl: './editar-h.html',
  styleUrl: './editar-h.css'
})
export class EditarH implements OnInit{
  constructor(private router: Router, private service: ServiceWS){}

  identificador: number | undefined;

  hijo: Hijo = new Hijo();

  ngOnInit(): void {
    this.buscarHijo()
  }

  buscarHijo(){
    const hijoString = localStorage.getItem('hijo')
    if(hijoString){
      const hijo = JSON.parse(hijoString)
      console.log(hijo)
      this.hijo = hijo
      this.identificador = this.hijo.padreId?.idPadre
    }
    this.service.buscarHWS(this.hijo).subscribe(data => {
      this.hijo = data
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

  editarHijo(){
    if(this.identificador){
      if(!this.hijo.padreId){
        this.hijo.padreId = new Padre()
      }
      this.hijo.padreId.idPadre = this.identificador;
    }
    this.service.editarHWS(this.hijo).subscribe(data => {
      Swal.fire({
        icon: "success",
        title: "EDITAR",
        text: `El hijo ${this.hijo.nombre} se edito correctamente`,
        showConfirmButton: false,
        timer: 2100
      })
      this.router.navigate(['listarH'])
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
