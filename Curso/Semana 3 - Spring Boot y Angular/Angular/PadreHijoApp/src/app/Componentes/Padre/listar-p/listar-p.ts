import { Component, OnInit } from '@angular/core';
import { Padre } from '../../../Entidades/Padre';
import { ServiceWS } from '../../../Service/service-ws';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-listar-p',
  imports: [],
  templateUrl: './listar-p.html',
  styleUrl: './listar-p.css'
})
export class ListarP implements OnInit{
  constructor(private router: Router, private service: ServiceWS){}

  padre: Padre = new Padre()
  padres !: Padre[]
  
  ngOnInit(): void {
    this.listarPadre()
  }

  listarPadre(){
    this.service.listarPWS().subscribe(data => {
      this.padres = data;
    })
  }

  editarButton(padre: Padre) {
    localStorage.setItem('padre', JSON.stringify(padre));
    console.log(localStorage)
    this.router.navigate(['editarP'])
  }
  eliminarButton(padre: Padre) {
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
        this.service.eliminarPWS(padre).subscribe(data => {
          Swal.fire({
            title: "¡Registro eliminado!",
            text: `El padre ${padre.nombre} fue eliminado correctamente`,
            icon: "success"
          });
          this.listarPadre()
        })
      } else {
        Swal.fire("La eliminación fue cancelada", "", "info")
      }
    })
  }

}
