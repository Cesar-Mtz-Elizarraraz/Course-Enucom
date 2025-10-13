import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceWS } from '../../Service/service-ws';
import { Computadora } from '../../Entidad/Computadora';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-listar-compu',
  imports: [],
  templateUrl: './listar-compu.html',
  styleUrl: './listar-compu.css'
})
// ngOnInit: Es una de los lifecycle hooks(ganchos del ciclo de vida) de los más importantes en Angular
// es un método que se ejecuta inmediatamente después de que el componente se inicializa y sus propiedades 
// vinculadas se revisan por primera vez
export class ListarCompu implements OnInit{
  // Agregar un constructor de la clase para inyectar dependencias
  constructor(private router: Router, private service : ServiceWS){}
  // Instanciar el objeto
  compu: Computadora = new Computadora()
  compus !: Computadora[]

  ngOnInit(): void {
    this.listarCompu();
  }

  listarCompu(){
    // .suscribe: se conecta con el flujo de datos e inicia la llamada HTTP y se ejecuta en ese momento
    this.service.listarCWS().subscribe(data => {
      this.compus = data
      console.log(`Listado exitoso ${JSON.stringify(data)}`)
    })
  }

  editarButton(compu: Computadora){
    localStorage.setItem('compu', JSON.stringify(compu));
    console.log(localStorage)
    this.router.navigate(['editarC'])
  }

  eliminarButton(compu: Computadora){
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
        this.service.eliminarCWS(compu).subscribe(data => {
          Swal.fire({
            title: "¡Registro eliminado!",
            text: `La computadora ${compu.marca} fue eliminada correctamente`,
            icon: "success"
          });
          this.listarCompu()
        })
      } else {
        Swal.fire("La eliminación fue cancelada", "", "info")
      }
    })
  }
}
