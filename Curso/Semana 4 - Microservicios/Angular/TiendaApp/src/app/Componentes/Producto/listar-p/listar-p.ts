import { Component, OnInit } from '@angular/core';
import { ServiceWS } from '../../../Service/service-ws';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { DataTableConfig } from '../../../Utils/DataTableConfig';
import { Producto, ProductoForm } from '../../../Entidades/Producto';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faTrashCan, faPen, faBagShopping, faPlus } from '@fortawesome/free-solid-svg-icons';
import Swal from 'sweetalert2';
import { GuardarP } from '../guardar-p/guardar-p';
import { EditarP } from '../editar-p/editar-p';

@Component({
  selector: 'app-listar-p',
  imports: [GuardarP, EditarP, FontAwesomeModule],
  templateUrl: './listar-p.html',
  styleUrl: './listar-p.css'
})
export class ListarP implements OnInit{
  constructor(private service: ServiceWS, private modalService: NgbModal){}

  private dataTableInitialized = false;
  dataTable: any;
  dataTableConfig: DataTableConfig = new DataTableConfig();
  producto: Producto = new Producto() 
  productos !: Producto[]
  productoEditar !: ProductoForm;

  faPlus = faPlus
  faTrasCan = faTrashCan
  faPen = faPen
  faBagShopping = faBagShopping

  ngOnInit(): void {
    this.listarProductos()
  }

  initDataTable(){
    const columnDefs = [
      { targets: 0, type: 'string' },
      { targets: 7, type: 'string', orderable: false }
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

  openEditarModal(content: any, producto: Producto) {
    this.buscarProducto(producto)
    this.modalService.open(content, { centered: true })
  }

  closeEditarModal() {
    this.modalService.dismissAll()
  }

  listarProductos(){
    this.service.listarProductoWS().subscribe(data => {
      this.productos = data;
    })
    setTimeout(() => {
      if(!this.dataTableInitialized){
        this.initDataTable();
        this.dataTableInitialized = true
      }
    }, 500);
  }

  buscarProducto(producto: Producto) {
    this.service.buscarProductoWS(producto).subscribe({
    next: (data: ProductoForm) => { // Next es para recibir lo que el observable emite con éxito
      this.productoEditar = data
    },
    error: () => {
      Swal.fire({
        title: "BUSCAR",
        icon: "error",
        text: "Ocurrió un error al buscar el producto",
        confirmButtonText: "OK"
      });
      this.productoEditar = new Producto()
      this.closeEditarModal()
    }
  });
  }

  eliminarProducto(producto: Producto) {
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
        this.service.eliminarProductoWS(producto).subscribe(data => {
          Swal.fire({
            title: "¡Registro eliminado!",
            text: `El producto ${producto.nombre} fue eliminado correctamente`,
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
