import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceWS } from '../../Service/service-ws';
import { Computadora } from '../../Entidad/Computadora';
import { FormsModule } from '@angular/forms';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-editar-compu',
  imports: [FormsModule], // FormsModule: AYudara a usar la directiva ngModule
  templateUrl: './editar-compu.html',
  styleUrl: './editar-compu.css'
})
export class EditarCompu implements OnInit {
  constructor(private router: Router, private service : ServiceWS){}
  compu: Computadora = new Computadora()

  ngOnInit(): void {
    this.buscarCompu()
  }

  buscarCompu(){
    const compuString = localStorage.getItem('compu')
    if(compuString){
      const compu = JSON.parse(compuString)
      console.log(compu)
      this.compu = compu
    }
    this.service.buscarCWS(this.compu).subscribe(data => {
      this.compu = data
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

  editarCompu(){
    this.service.editarCWS(this.compu).subscribe(data => {
        Swal.fire({
          icon : "success",
          title: "EDITAR",
          text: `La computadora ${this.compu.marca} se edito correctamente`,
          showConfirmButton: false,
          timer: 2100
        })
        this.router.navigate(['listarC'])
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
