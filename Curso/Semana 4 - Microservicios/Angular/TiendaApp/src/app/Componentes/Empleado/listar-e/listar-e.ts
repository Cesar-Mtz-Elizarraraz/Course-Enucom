import { Component, OnInit } from '@angular/core';
import { GuardarE } from '../guardar-e/guardar-e';
import { EditarE } from '../editar-e/editar-e';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { ServiceWS } from '../../../Service/service-ws';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { faTrashCan, faPen, faUser, faPlus } from '@fortawesome/free-solid-svg-icons';
import { DataTableConfig } from '../../../Utils/DataTableConfig';
import { Empleado } from '../../../Entidades/Empleado';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-listar-e',
  imports: [GuardarE, EditarE, FontAwesomeModule],
  templateUrl: './listar-e.html',
  styleUrl: './listar-e.css'
})
export class ListarE implements OnInit {
  constructor(private service: ServiceWS, private modalService: NgbModal){}

  private dataTableInitialized = false;
  dataTable: any;
  dataTableConfig: DataTableConfig = new DataTableConfig();
  empleado: Empleado = new Empleado() 
  empleados !: Empleado[]
  empleadoEditar: Empleado = new Empleado();

  faPlus = faPlus
  faTrasCan = faTrashCan
  faPen = faPen
  faUser = faUser

  ngOnInit(): void {
    this.listarEmpleados()
  }

  initDataTable(){
    const columnDefs = [
      { targets: 1, type: 'string' },
      { targets: 2, type: 'string' },
      { targets: 3, type: 'string' },
      { targets: 4, type: 'string' },
      { targets: 5, type: 'string', orderable: false }
    ]
    this.dataTable = this.dataTableConfig.initDataTable(this.dataTable, "miTabla", columnDefs)
  }

  // Funciones para los modales
  openGuardarModal(content: any) {
    this.modalService.open(content, { centered: true })
  }

  closeGuardarModal() {
    this.modalService.dismissAll()
  }

  openEditarModal(content: any, empleado: Empleado) {
    this.buscarEmpleado(empleado)
    this.modalService.open(content, { centered: true })
  }

  closeEditarModal() {
    this.modalService.dismissAll()
  }

  listarEmpleados(){
    this.service.listarEmpleadoWS().subscribe(data => {
      this.empleados = data;
      
    })
    setTimeout(() => {
      if(!this.dataTableInitialized){
        this.initDataTable();
        this.dataTableInitialized = true
      }
    }, 500);
  }

  buscarEmpleado(empleado: Empleado) {
    this.service.buscarEmpleadoWS(empleado).subscribe({
    next: (data: Empleado) => {
      this.empleadoEditar = data
    },
    error: () => {
      Swal.fire({
        title: "BUSCAR",
        icon: "error",
        text: "Ocurrió un error al buscar la categoría",
        confirmButtonText: "OK"
      });
      this.empleadoEditar = new Empleado()
      this.closeEditarModal()
    }
  });
  }

  eliminarEmpleado(empleado: Empleado) {
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
        this.service.eliminarEmpleadoWS(empleado).subscribe(data => {
          Swal.fire({
            title: "¡Registro eliminado!",
            text: `El empleado ${empleado.nombre} fue eliminado correctamente`,
            icon: "success"
          }).then((result) => {
            if (result.isConfirmed) {
              window.location.reload();
            }
          })
        })
      }
    })
  }
}
