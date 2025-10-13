import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { ServiceWS } from '../../../Service/service-ws';
import { Padre } from '../../../Entidades/Padre';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-editar-p',
  imports: [FormsModule],
  templateUrl: './editar-p.html',
  styleUrl: './editar-p.css'
})
export class EditarP implements OnInit {
  constructor(private router: Router, private service: ServiceWS){}

  padre: Padre = new Padre()

  ngOnInit(): void {
    this.buscarP()
  }

  buscarP(){
    const padreString = localStorage.getItem('padre')
    if(padreString){
      const padre = JSON.parse(padreString)
      console.log(padre)
      this.padre = padre
    }
    this.service.buscarPWS(this.padre).subscribe(data => {
      this.padre = data
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

  editarP(){
    this.service.editarPWS(this.padre).subscribe(data => {
      Swal.fire({
        icon : "success",
        title: "EDITAR",
        text: `El padre ${this.padre.nombre} se edito correctamente`,
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
