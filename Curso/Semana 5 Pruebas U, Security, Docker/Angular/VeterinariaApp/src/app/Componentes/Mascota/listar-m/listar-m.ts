import { Component, ViewChild } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { InformationTable } from '../../Compartidos/information-table/information-table';
import { NgbModal, NgbModalModule } from '@ng-bootstrap/ng-bootstrap';
import { GuardarM } from '../guardar-m/guardar-m';
import { EditarM } from '../editar-m/editar-m';
import { ServiceWS } from '../../../Service/service-ws';
import { Mascota, MascotaCliResVet } from '../../../Entidades/Mascota';
import { InformationTableConfig } from '../../../Interfaces/InformationTableConfig';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-listar-m',
  imports: [FontAwesomeModule, FormsModule, InformationTable, NgbModalModule, GuardarM, EditarM],
  templateUrl: './listar-m.html',
  styleUrl: './listar-m.css'
})
export class ListarM {
  constructor(private service: ServiceWS, private modalService: NgbModal){}

  @ViewChild('contentE') contentE: any;
  
  mascotas: MascotaCliResVet[] = []
  mascota: Mascota = new Mascota() 
  mascotaEditar!: Mascota;
  tableConfig: InformationTableConfig = {
    mainProp: "idMascota",
    columns: [
      {name: "#", prop: "idMascota", width: 10},
      {name: "Nombre", prop: "nombre", width: 100},
      {name: "Raza", prop: "raza", width: 70},
      {name: "Edad", prop: "edad", width: 20},
      {name: "Razón de la cita", prop: "razonCita", width: 120},
      {name: "Cliente", prop: "cliente.nombre", width: 120},
      {name: "Responsable", prop: "responsable.nombre", width: 120},
      {name: "Veterinaria", prop: "veterinaria.nombre", width: 120},
    ]
  }

  ngOnInit(): void {
    this.listarMascotas()
  }

  listarMascotas() {
    this.service.listarMascotaWS().subscribe({
      next: data => {
        this.mascotas = data;
      },
      error: err => {
        console.error('Error al listar mascotas:', err);
      }
    });
  }

  buscarMascota(idMascota: number) {
    this.service.buscarMascotaWS(idMascota).subscribe({
      next: (data: Mascota) => {
        this.mascotaEditar = data
      },
      error: () => {
        Swal.fire({
          title: "BUSCAR",
          icon: "error",
          text: "Ocurrió un error al buscar la mascota",
          confirmButtonText: "OK"
        });
        this.mascotaEditar = new Mascota()
        this.closeModal()
      }
    });
  }

  onEditar(id: number) {
    this.openEditarModal()
    this.buscarMascota(id)
  }

  onEliminar(id: number) {
    Swal.fire({
      title: "¿Está seguro de querer eliminar el registro?",
      text: "¡Este movimiento no se podrá revertir!",
      icon: "warning",
      showCancelButton: true,
      confirmButtonColor: "#2c4c97",
      cancelButtonColor: "#dc3545",
      confirmButtonText: "Si, ¡Eliminar!",
      cancelButtonText: "Cancelar"
    }).then((result) => {
      if (result.isConfirmed) this.eliminarMascota(id)
    })
  }

  eliminarMascota(idMascota: number){
    this.service.eliminarMascotaWS(idMascota).subscribe({
      next: data => {
        this.listarMascotas()
        Swal.fire({
          title: "¡Registro eliminado!",
          text: `La mascota ${data.nombre} fue eliminada correctamente`,
          icon: "success",
          timer: 2500
        })
      },
      error: err => {
        console.error('Error al eliminar la mascota:', err);
      }
    })
  }

  openGuardarModal(content: any) {
    this.modalService.open(content, { centered: true, scrollable: true })
  }

  openEditarModal() {
    this.modalService.open(this.contentE, { centered: true, scrollable: true })
  }

  closeModal() {
    this.modalService.dismissAll()
  }
}
