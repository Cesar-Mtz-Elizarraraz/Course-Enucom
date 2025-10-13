import { Component, ViewChild } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { InformationTable } from '../../Compartidos/information-table/information-table';
import { NgbModal, NgbModalModule } from '@ng-bootstrap/ng-bootstrap';
import { ServiceWS } from '../../../Service/service-ws';
import { Responsable, ResponsableVeterinaria } from '../../../Entidades/Responsable';
import Swal from 'sweetalert2';
import { InformationTableConfig } from '../../../Interfaces/InformationTableConfig';
import { GuardarR } from '../guardar-r/guardar-r';
import { EditarR } from '../editar-r/editar-r';

@Component({
  selector: 'app-listar-r',
  imports: [FontAwesomeModule, FormsModule, InformationTable, NgbModalModule, GuardarR, EditarR],
  templateUrl: './listar-r.html',
  styleUrl: './listar-r.css'
})
export class ListarR {
  constructor(private service: ServiceWS, private modalService: NgbModal){}

  @ViewChild('contentE') contentE: any;
  
  responsables: ResponsableVeterinaria[] = []
  responsable: Responsable = new Responsable() 
  responsableEditar!: Responsable;
  tableConfig: InformationTableConfig = {
    mainProp: "idResponsable",
    columns: [
      {name: "#", prop: "idResponsable", width: 10},
      {name: "Nombre", prop: "nombre"},
      {name: "Contacto", prop: "contacto"},
      {name: "Veterinaria", prop: "veterinaria.nombre"}
    ]
  }

  ngOnInit(): void {
    this.listarResponsables()
  }

  listarResponsables() {
    this.service.listarResponsableWS().subscribe({
      next: data => {
        this.responsables = data;
      },
      error: err => {
        console.error('Error al listar responsables:', err);
      }
    });
  }

  buscarResponsable(idResponsable: number) {
    this.service.buscarResponsableWS(idResponsable).subscribe({
      next: (data: Responsable) => {
        this.responsableEditar = data
      },
      error: () => {
        Swal.fire({
          title: "BUSCAR",
          icon: "error",
          text: "Ocurrió un error al buscar el responsable",
          confirmButtonText: "OK"
        });
        this.responsableEditar = new Responsable()
        this.closeModal()
      }
    });
  }

  onEditar(id: number) {
    this.openEditarModal()
    this.buscarResponsable(id)
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
      if (result.isConfirmed) this.eliminarResponsable(id)
    })
  }

  eliminarResponsable(idResponsable: number){
    this.service.eliminarResponsableWS(idResponsable).subscribe({
      next: data => {
        this.listarResponsables()
        Swal.fire({
          title: "¡Registro eliminado!",
          text: `El responsable ${data.nombre} fue eliminado correctamente`,
          icon: "success",
          timer: 2500
        })
      },
      error: err => {
        console.error('Error al eliminar el responsable:', err);
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
