import { Component, ViewChild } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { InformationTable } from '../../Compartidos/information-table/information-table';
import { NgbModal, NgbModalModule } from '@ng-bootstrap/ng-bootstrap';
import { GuardarV } from '../guardar-v/guardar-v';
import { EditarV } from '../editar-v/editar-v';
import { ServiceWS } from '../../../Service/service-ws';
import { Veterinaria } from '../../../Entidades/Veterinaria';
import Swal from 'sweetalert2';
import { InformationTableConfig } from '../../../Interfaces/InformationTableConfig';

@Component({
  selector: 'app-listar-v',
  imports: [FontAwesomeModule, FormsModule, InformationTable, NgbModalModule, GuardarV, EditarV],
  templateUrl: './listar-v.html',
  styleUrl: './listar-v.css'
})
export class ListarV {
  constructor(private service: ServiceWS, private modalService: NgbModal){}

  @ViewChild('contentE') contentE: any;

  veterinarias: Veterinaria[] = []
  veterinaria: Veterinaria = new Veterinaria() 
  veterinariaEditar: Veterinaria = new Veterinaria();
  tableConfig: InformationTableConfig = {
    mainProp: "idVeterinaria",
    columns: [
      {name: "#", prop: "idVeterinaria", width: 10},
      {name: "Nombre", prop: "nombre"},
      {name: "Dirección", prop: "direccion"},
      {name: "Teléfono", prop: "telefono"}
    ]
  }

  ngOnInit(): void {
    this.listarVeterinarias()
  }

  listarVeterinarias() {
    this.service.listarVeterinariaWS().subscribe({
      next: data => {
        this.veterinarias = data;
      },
      error: err => {
        console.error('Error al listar veterinarias:', err);
      }
    });
  }

  buscarVeterinaria(idVeterinaria: number) {
    this.service.buscarVeterinariaWS(idVeterinaria).subscribe({
      next: (data: Veterinaria) => {
        console.log(data)
        this.veterinariaEditar = data
      },
      error: () => {
        Swal.fire({
          title: "BUSCAR",
          icon: "error",
          text: "Ocurrió un error al buscar la veterinaria",
          confirmButtonText: "OK"
        });
        this.veterinariaEditar = new Veterinaria()
        this.closeModal()
      }
    });
  }

  onEditar(id: number) {
    this.openEditarModal()
    this.buscarVeterinaria(id)
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
      if (result.isConfirmed) this.eliminarVeterinaria(id)
    })
  }

  eliminarVeterinaria(idVeterinaria: number){
    this.service.eliminarVeterinariaWS(idVeterinaria).subscribe({
      next: data => {
        this.listarVeterinarias()
        Swal.fire({
          title: "¡Registro eliminado!",
          text: `La veterinaria ${data.nombre} fue eliminada correctamente`,
          icon: "success",
          timer: 2500
        })
      },
      error: err => {
        console.error('Error al eliminar la veterinaria:', err);
      }
    })
  }

  openGuardarModal(content: any) {
    this.modalService.open(content, { centered: true })
  }

  openEditarModal() {
    this.modalService.open(this.contentE, { centered: true })
  }

  closeModal() {
    this.modalService.dismissAll()
  }
}
