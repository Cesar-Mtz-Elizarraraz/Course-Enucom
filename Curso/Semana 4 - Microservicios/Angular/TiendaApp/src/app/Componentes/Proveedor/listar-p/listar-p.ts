import { Component, OnInit } from '@angular/core';
import { ServiceWS } from '../../../Service/service-ws';
import { Proveedor } from '../../../Entidades/Proveedor';
import { GuardarP } from '../guardar-p/guardar-p';
import { DataTableConfig } from '../../../Utils/DataTableConfig';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { EditarP } from '../editar-p/editar-p';
import Swal from 'sweetalert2';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faTrashCan, faPen, faUserTie, faPlus } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-listar-p',
  imports: [GuardarP, EditarP, FontAwesomeModule],
  templateUrl: './listar-p.html',
  styleUrl: './listar-p.css',
})
export class ListarP implements OnInit {
  constructor(private service: ServiceWS, private modalService: NgbModal){}

  private dataTableInitialized = false; // Bandera para la inicialización del DataTable
  dataTable: any; // PAra almacenar el DataTable
  dataTableConfig: DataTableConfig = new DataTableConfig(); // Instancia para la configuración del DataTable
  proveedor: Proveedor = new Proveedor() 
  proveedores !: Proveedor[]
  proveedorEditar: Proveedor = new Proveedor(); // ALmacenar la información del proveedor encontrado para editarlo

  faPlus = faPlus
  faTrasCan = faTrashCan
  faPen = faPen
  faUserTie = faUserTie

  ngOnInit(): void {
    this.listarProveedores()
  }

  initDataTable(){
    const columnDefs = [
      { targets: 1, type: 'string' },
      { targets: 2, type: 'string' },
      { targets: 3, type: 'string' },
      { targets: 4, type: 'string', orderable: false }
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

  openEditarModal(content: any, proveedor: Proveedor) {
    this.buscarProveedor(proveedor)
    this.modalService.open(content, { centered: true })
  }

  closeEditarModal() {
    this.modalService.dismissAll()
  }

  listarProveedores(){
    this.service.listarProveedorWS().subscribe(data => {
      this.proveedores = data;
    })
    setTimeout(() => {
      if(!this.dataTableInitialized){
        this.initDataTable();
        this.dataTableInitialized = true
      }
    }, 500);
  }

  buscarProveedor(proveedor: Proveedor) {
    this.service.buscarProveedorWS(proveedor).subscribe({
    next: (data: Proveedor) => { // Next es para recibir lo que el observable emite con éxito
      this.proveedorEditar = data
    },
    error: () => {
      Swal.fire({
        title: "BUSCAR",
        icon: "error",
        text: "Ocurrió un error al buscar el proveedor",
        confirmButtonText: "OK"
      });
      this.proveedorEditar = new Proveedor()
      this.closeEditarModal()
    }
  });
  }

  eliminarProveedor(proveedor: Proveedor) {
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
        this.service.eliminarProveedorWS(proveedor).subscribe(data => {
          Swal.fire({
            title: "¡Registro eliminado!",
            text: `El proveedor ${proveedor.nombre} fue eliminado correctamente`,
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
