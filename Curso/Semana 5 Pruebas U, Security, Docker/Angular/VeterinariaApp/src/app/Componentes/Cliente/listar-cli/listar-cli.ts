import { Component, ViewChild } from '@angular/core';
import { ServiceWS } from '../../../Service/service-ws';
import { Cliente } from '../../../Entidades/Cliente';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { FormsModule } from '@angular/forms';
import { NgbModal, NgbModalModule } from '@ng-bootstrap/ng-bootstrap';
import Swal from 'sweetalert2';
import { GuardarCli } from '../guardar-cli/guardar-cli';
import { EditarCli } from '../editar-cli/editar-cli';
import { InformationTable } from '../../Compartidos/information-table/information-table';
import { InformationTableConfig } from '../../../Interfaces/InformationTableConfig';

@Component({
  selector: 'app-listar-cli',
  imports: [FontAwesomeModule, FormsModule, InformationTable, NgbModalModule, GuardarCli, EditarCli],
  templateUrl: './listar-cli.html',
  styleUrl: './listar-cli.css'
})
export class ListarCli {
  constructor(private service: ServiceWS, private modalService: NgbModal){}

  @ViewChild('contentE') contentE: any;

  clientes: Cliente[] = []
  cliente: Cliente = new Cliente() 
  clienteEditar: Cliente = new Cliente();
  tableConfig: InformationTableConfig = {
    mainProp: "idCliente",
    columns: [
      {name: "#", prop: "idCliente", width: 10},
      {name: "Nombre", prop: "nombre"},
      {name: "Dirección", prop: "direccion"},
      {name: "Contacto", prop: "contacto"}
    ]
  }

  ngOnInit(): void {
    this.listarClientes()
  }

  listarClientes() {
    this.service.listarClienteWS().subscribe({
      next: data => {
        this.clientes = data;
      },
      error: err => {
        console.error('Error al listar clientes:', err);
      }
    });
  }

  buscarCliente(idCliente: number) {
    this.service.buscarClienteWS(idCliente).subscribe({
      next: (data: Cliente) => {
        console.log(data)
        this.clienteEditar = data
      },
      error: () => {
        Swal.fire({
          title: "BUSCAR",
          icon: "error",
          text: "Ocurrió un error al buscar el cliente",
          confirmButtonText: "OK"
        });
        this.clienteEditar = new Cliente()
        this.closeModal()
      }
    });
  }

  onEditar(id: number) {
    this.openEditarModal()
    this.buscarCliente(id)
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
      if (result.isConfirmed) this.eliminarCliente(id)
    })
  }

  eliminarCliente(idCliente: number){
    this.service.eliminarClienteWS(idCliente).subscribe({
      next: data => {
        this.listarClientes()
        Swal.fire({
          title: "¡Registro eliminado!",
          text: `El cliente ${data.nombre} fue eliminado correctamente`,
          icon: "success",
          timer: 2500
        })
      },
      error: err => {
        console.error('Error al eliminar el cliente:', err);
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
