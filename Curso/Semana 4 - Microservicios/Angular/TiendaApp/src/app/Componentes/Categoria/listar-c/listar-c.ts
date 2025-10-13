import { Component, OnInit } from '@angular/core';
import { GuardarC } from '../guardar-c/guardar-c';
import { ServiceWS } from '../../../Service/service-ws';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { DataTableConfig } from '../../../Utils/DataTableConfig';
import { Categoria } from '../../../Entidades/Categoria';
import Swal from 'sweetalert2';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faTrashCan, faPen, faTags, faPlus } from '@fortawesome/free-solid-svg-icons';
import { EditarC } from '../editar-c/editar-c';

@Component({
  selector: 'app-listar-c',
  imports: [GuardarC, EditarC, FontAwesomeModule],
  templateUrl: './listar-c.html',
  styleUrl: './listar-c.css'
})
export class ListarC implements OnInit {
  constructor(private service: ServiceWS, private modalService: NgbModal){}
  
  private dataTableInitialized = false;
  dataTable: any;
  dataTableConfig: DataTableConfig = new DataTableConfig();
  categoria: Categoria = new Categoria() 
  categorias !: Categoria[]
  categoriaEditar: Categoria = new Categoria();

  faPlus = faPlus
  faTrasCan = faTrashCan
  faPen = faPen
  faTags = faTags

  ngOnInit(): void {
    this.listarCategorias()
  }

  initDataTable(){
    const columnDefs = [
      { targets: 1, type: 'string' },
      { targets: 2, type: 'string' },
      { targets: 3, type: 'string', orderable: false }
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

  openEditarModal(content: any, categoria: Categoria) {
    this.buscarCategoria(categoria)
    this.modalService.open(content, { centered: true })
  }

  closeEditarModal() {
    this.modalService.dismissAll()
  }

  listarCategorias(){
    this.service.listarCategoriaWS().subscribe(data => {
      this.categorias = data;
      
    })
    setTimeout(() => {
      if(!this.dataTableInitialized){
        this.initDataTable();
        this.dataTableInitialized = true
      }
    }, 500);
  }

  buscarCategoria(categoria: Categoria) {
    this.service.buscarCategoriaWS(categoria).subscribe({
    next: (data: Categoria) => {
      this.categoriaEditar = data
    },
    error: () => {
      Swal.fire({
        title: "BUSCAR",
        icon: "error",
        text: "Ocurrió un error al buscar la categoría",
        confirmButtonText: "OK"
      });
      this.categoriaEditar = new Categoria()
      this.closeEditarModal()
    }
  });
  }

  eliminarCategoria(categoria: Categoria) {
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
        this.service.eliminarCategoriaWS(categoria).subscribe(data => {
          Swal.fire({
            title: "¡Registro eliminado!",
            text: `La categoría ${categoria.nombre} fue eliminada correctamente`,
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
