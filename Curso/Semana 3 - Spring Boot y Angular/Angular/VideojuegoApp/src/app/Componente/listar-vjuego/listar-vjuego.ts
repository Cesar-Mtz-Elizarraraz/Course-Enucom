import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceWS } from '../../Service/service-ws';
import { Videojuego } from '../../Entidad/Videojuego';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-listar-vjuego',
  imports: [],
  templateUrl: './listar-vjuego.html',
  styleUrl: './listar-vjuego.css'
})
export class ListarVJuego {
  // Agregar un constructor de la clase para inyectar dependencias
  constructor(private router: Router, private service : ServiceWS){}

  // Instanciar el objeto
  vjuego: Videojuego = new Videojuego()
  vjuegos !: Videojuego[]

  ngOnInit(): void {
    this.listarVJuegos();
  }

  listarVJuegos(){
    // .suscribe: se conecta con el flujo de datos e inicia la llamada HTTP y se ejecuta en ese momento
    this.service.listarCWS().subscribe(data => {
      this.vjuegos = data
      console.log(`Listado exitoso ${JSON.stringify(data)}`)
    })
  }

  editarButton(vjuego: Videojuego){
    localStorage.setItem('vjuego', JSON.stringify(vjuego));
    console.log(localStorage)
    this.router.navigate(['editarVJ'])
  }

  eliminarButton(vjuego: Videojuego){
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
        this.service.eliminarCWS(vjuego).subscribe(data => {
          Swal.fire({
            title: "¡Registro eliminado!",
            text: `El videojuego ${vjuego.nombre} fue eliminado correctamente`,
            icon: "success"
          });
          this.listarVJuegos()
        })
      } else {
        Swal.fire("La eliminación fue cancelada", "", "info")
      }
    })
  }
}
