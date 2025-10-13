import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceWS } from '../../../Service/service-ws';
import { Usuario } from '../../../Entidades/Usuario';
import Swal from 'sweetalert2';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faTrashCan, faPen } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-listar-u',
  imports: [FontAwesomeModule],
  templateUrl: './listar-u.html',
  styleUrl: './listar-u.css'
})
export class ListarU implements OnInit{
  constructor(private router: Router, private service: ServiceWS){}

  usuario: Usuario = new Usuario();
  usuarios !: Usuario[]

  faTrashCan = faTrashCan;
  faPen = faPen;

  ngOnInit(): void {
    this.listarUsuarios()
  }

  listarUsuarios(){
    this.service.listarUWS().subscribe(data => {
      this.usuarios = data;
    })
  }

  editarButton(usuario: Usuario) {
    localStorage.setItem('usuario', JSON.stringify(usuario));
    console.log(localStorage)
    this.router.navigate(['editarU'])
  }
  eliminarButton(usuario: Usuario) {
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
        this.service.eliminarUWS(usuario).subscribe(data => {
          Swal.fire({
            title: "¡Registro eliminado!",
            text: `El usuario ${usuario.nombre} fue eliminado correctamente`,
            icon: "success"
          });
          this.listarUsuarios()
        })
      } else {
        Swal.fire("La eliminación fue cancelada", "", "info")
      }
    })
  }
}
