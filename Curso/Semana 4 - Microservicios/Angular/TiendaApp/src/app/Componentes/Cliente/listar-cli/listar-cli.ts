import { Component } from '@angular/core';
import { GuardarCli } from '../guardar-cli/guardar-cli';
import { EditarCli } from '../editar-cli/editar-cli';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { ServiceWS } from '../../../Service/service-ws';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Cliente } from '../../../Entidades/Cliente';
import { faTrashCan, faPen, faUsers, faPlus } from '@fortawesome/free-solid-svg-icons';
import { DataTableConfig } from '../../../Utils/DataTableConfig';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-listar-cli',
  imports: [GuardarCli, EditarCli, FontAwesomeModule],
  templateUrl: './listar-cli.html',
  styleUrl: './listar-cli.css'
})
export class ListarCli {
  constructor(private service: ServiceWS, private modalService: NgbModal){}

  private dataTableInitialized = false;
  dataTable: any;
  dataTableConfig: DataTableConfig = new DataTableConfig();
  cliente: Cliente = new Cliente() 
  clientes !: Cliente[]
  clienteEditar: Cliente = new Cliente();

  faPlus = faPlus
  faTrasCan = faTrashCan
  faPen = faPen
  faUsers = faUsers

  ngOnInit(): void {
    this.listarClientes()
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

  openEditarModal(content: any, cliente: Cliente) {
    this.buscarCliente(cliente)
    this.modalService.open(content, { centered: true })
  }

  closeEditarModal() {
    this.modalService.dismissAll()
  }

  listarClientes(){
    this.service.listarClienteWS().subscribe(data => {
      this.clientes = data;
      
    })
    setTimeout(() => {
      if(!this.dataTableInitialized){
        this.initDataTable();
        this.dataTableInitialized = true
      }
    }, 500);
  }

  buscarCliente(cliente: Cliente) {
    this.service.buscarClienteWS(cliente).subscribe({
    next: (data: Cliente) => {
      this.clienteEditar = data
    },
    error: () => {
      Swal.fire({
        title: "BUSCAR",
        icon: "error",
        text: "Ocurrió un error al buscar la categoría",
        confirmButtonText: "OK"
      });
      this.clienteEditar = new Cliente()
      this.closeEditarModal()
    }
  });
  }

  eliminarCliente(cliente: Cliente) {
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
        this.service.eliminarClienteWS(cliente).subscribe(data => {
          Swal.fire({
            title: "¡Registro eliminado!",
            text: `El cliente ${cliente.nombre} fue eliminado correctamente`,
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
