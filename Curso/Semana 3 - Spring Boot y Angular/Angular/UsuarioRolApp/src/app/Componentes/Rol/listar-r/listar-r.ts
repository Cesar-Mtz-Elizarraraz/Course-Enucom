import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceWS } from '../../../Service/service-ws';
import { Rol } from '../../../Entidades/Rol';
import Swal from 'sweetalert2';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faTrashCan, faPen } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-listar-r',
  imports: [FontAwesomeModule],
  templateUrl: './listar-r.html',
  styleUrl: './listar-r.css'
})
export class ListarR implements OnInit{
  constructor(private router: Router, private service: ServiceWS){}

  rol: Rol = new Rol();
  roles !: Rol[]

  faTrashCan = faTrashCan;
  faPen = faPen;

  ngOnInit(): void {
    this.listarRoles()
  }

  listarRoles(){
    this.service.listarRWS().subscribe(data => {
      this.roles = data;
    })
  }

  editarButton(rol: Rol) {
    localStorage.setItem('rol', JSON.stringify(rol));
    console.log(localStorage)
    this.router.navigate(['editarR'])
  }
  eliminarButton(rol: Rol) {
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
        this.service.eliminarRWS(rol).subscribe(data => {
          Swal.fire({
            title: "¡Registro eliminado!",
            text: `El rol ${rol.privilegio} fue eliminado correctamente`,
            icon: "success"
          });
          this.listarRoles()
        })
      } else {
        Swal.fire("La eliminación fue cancelada", "", "info")
      }
    })
  }
}
