import { Component } from '@angular/core';
import { GuardarV } from '../guardar-v/guardar-v';
import { EditarV } from '../editar-v/editar-v';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { ServiceWS } from '../../../Service/service-ws';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { DataTableConfig } from '../../../Utils/DataTableConfig';
import { Venta, VentaForm } from '../../../Entidades/Venta';
import { faTrashCan, faPen, faCircleDollarToSlot, faPlus } from '@fortawesome/free-solid-svg-icons';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-listar-v',
  imports: [EditarV, FontAwesomeModule],
  templateUrl: './listar-v.html',
  styleUrl: './listar-v.css'
})
export class ListarV {
  constructor(private service: ServiceWS, private modalService: NgbModal){}

  private dataTableInitialized = false;
  dataTable: any;
  dataTableConfig: DataTableConfig = new DataTableConfig();
  venta: Venta = new Venta() 
  ventas !: Venta[]
  ventaEditar !: VentaForm;

  faPlus = faPlus
  faTrasCan = faTrashCan
  faPen = faPen
  faCircleDollarToSlot = faCircleDollarToSlot

  ngOnInit(): void {
    this.listarVentas()
  }

  initDataTable(){
    const columnDefs = [
      { targets: 9, type: 'string', orderable: false }
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

  openEditarModal(content: any, venta: Venta) {
    this.buscarVenta(venta)
    this.modalService.open(content, { centered: true, scrollable: true })
  }

  closeEditarModal() {
    this.modalService.dismissAll()
  }

  listarVentas(){
    this.service.listarVentaWS().subscribe(data => {
      this.ventas = data;
    })
    setTimeout(() => {
      if(!this.dataTableInitialized){
        this.initDataTable();
        this.dataTableInitialized = true
      }
    }, 500);
  }

  buscarVenta(venta: Venta) {
    this.service.buscarVentaWS(venta).subscribe({
    next: (data: VentaForm) => { // Next es para recibir lo que el observable emite con éxito
      this.ventaEditar = data
    },
    error: () => {
      Swal.fire({
        title: "BUSCAR",
        icon: "error",
        text: "Ocurrió un error al buscar la venta",
        confirmButtonText: "OK"
      });
      this.ventaEditar = new Venta()
      this.closeEditarModal()
    }
  });
  }

  eliminarVenta(venta: Venta) {
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
        this.service.eliminarVentaWS(venta).subscribe(data => {
          Swal.fire({
            title: "¡Registro eliminado!",
            text: `La venta con ID ${venta.idVenta} fue eliminada correctamente`,
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
