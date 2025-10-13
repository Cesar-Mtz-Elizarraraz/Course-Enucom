import { Component } from '@angular/core';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faCircleDollarToSlot } from '@fortawesome/free-solid-svg-icons';
import { ServiceWS } from '../../../Service/service-ws';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Producto, ProductoForm } from '../../../Entidades/Producto';
import { FormsModule } from '@angular/forms';
import { VentaForm } from '../../../Entidades/Venta';
import { Cliente } from '../../../Entidades/Cliente';
import { Empleado } from '../../../Entidades/Empleado';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';
import { z } from 'zod';

const schema = z.object({
  idCli: z.number().refine(val => val >= 1, { message: 'El cliente es obligatorio' }),
  idEmp: z.number().refine(val => val >= 1, { message: 'El empleado es obligatorio' }),
  metodoPago: z.enum(['Efectivo', 'Tarjeta', 'Transferencia'], {errorMap: () => ({ message: 'El método de pago es obligatorio' })}),
});

type tableProductos = {producto: Producto, cantidad: number, subtotal: number}

@Component({
  selector: 'app-guardar-v',
  imports: [FormsModule, FontAwesomeModule],
  templateUrl: './guardar-v.html',
  styleUrl: './guardar-v.css'
})
export class GuardarV {

  constructor(private service: ServiceWS, private modalService: NgbModal, private router: Router){}

  productos !: Producto[]
  clientes !: Cliente[]
  empleados !: Empleado[]
  codigoBarras = 0
  metodoPago = ""
  idCli = 0
  idEmp = 0
  cantidadProd = 1
  stockProd = 0
  tableProductos: tableProductos[] = []
  totalPagar = 0
  msgError = ""
  errores: any

  faCircleDollarToSlot = faCircleDollarToSlot

  ngOnInit(): void {
    this.listarProductos()
    this.listarClientes()
    this.listarEmpleados()
  }

  listarProductos(){
    this.service.listarProductoWS().subscribe(data => {
      this.productos = data;
    })
  }

  listarClientes(){
    this.service.listarClienteWS().subscribe(data => {
      this.clientes = data;
    })
  }

  listarEmpleados(){
    this.service.listarEmpleadoWS().subscribe(data => {
      this.empleados = data;
    })
  }

  onIdProdChange(codigoBarras: number) {
    const productoEncontrado = this.productos.find(
      producto => producto.codigoBarras == codigoBarras
    )
    this.stockProd = productoEncontrado ? productoEncontrado.stock : 0
    this.cantidadProd = this.stockProd > 0 ? 1 : 0
  }

  // Funciones para los modales
  openGuardarModal(content: any) {
    this.modalService.open(content, { centered: true })
  }

  closeGuardarModal() {
    this.modalService.dismissAll()
  }

  agregarProducto(){
    this.msgError = ""
    const productoEncontrado = this.productos.find(
      producto => producto.codigoBarras == this.codigoBarras
    )

    if(!productoEncontrado) {
      this.msgError = "El producto no pudo ser agregado"
      return
    }
    if(this.cantidadProd > this.stockProd){
      this.msgError = "El stock no es suficiente"
      return
    }

    productoEncontrado.stock -= this.cantidadProd
    this.stockProd = productoEncontrado.stock

    const productoEncontradoTable = this.tableProductos.find(
      producto => producto.producto.codigoBarras == this.codigoBarras
    )

    if (productoEncontradoTable) {
      productoEncontradoTable.cantidad += this.cantidadProd
      productoEncontradoTable.subtotal = productoEncontradoTable.cantidad * productoEncontrado.precio
      this.calcularTotal()
      return
    }

    const newProducto = {producto: productoEncontrado, cantidad: this.cantidadProd, subtotal: this.cantidadProd * productoEncontrado.precio}

    this.tableProductos = [...this.tableProductos, newProducto];
    this.productos = [...this.productos];

    this.calcularTotal()
  }

  calcularTotal(){
    this.totalPagar = this.tableProductos.reduce((suma, item) => {
      return suma + Number(item.subtotal);
    }, 0)
  }

  guardarVenta() {
    this.errores = {}
    const validacion = schema.safeParse({idCli: Number(this.idCli), idEmp: Number(this.idEmp), metodoPago: this.metodoPago});

    if (!validacion.success) {
      this.errores = validacion.error.format();
      return
    }
    const dataVenta: VentaForm[] = []
    this.tableProductos.forEach(item => {
      const productoV  = {
        cantidad: item.cantidad,
        total: Number(item.subtotal.toFixed(2)),
        metodoPago: this.metodoPago,
        clienteId: this.idCli,
        empleadoId: this.idEmp,
        codigoBarras: item.producto.codigoBarras
      }
      dataVenta.push(productoV)
    });
    const dataProdsEditar: ProductoForm[] = []

    this.productos.forEach(item => {
      const producto = {
        codigoBarras: item.codigoBarras,
        nombre: item.nombre,
        precio: item.precio,
        stock: item.stock,
        descuento: item.descuento,
        categoriaId: item.categoria?.idCategoria,
        proveedorId: item.proveedor?.idProveedor,
      }
      dataProdsEditar.push(producto)
    })

    this.service.editarMultipleProductoWS(dataProdsEditar).subscribe(data => {
      this.service.guardarVentaWS(dataVenta).subscribe(data => {
        Swal.fire({
          icon : "success",
          title: "GUARDAR",
          text: `La venta se registro correctamente`,
          confirmButtonText: "OK"
        }).then((result) => {
          if (result.isConfirmed) {
            this.closeGuardarModal()
            this.router.navigate(['venta']);
          }
        });
      }, error => {
        Swal.fire({
          icon : "error",
          title: "GUARDAR",
          text: "Ocurrió un error",
          confirmButtonText: "OK"
        })
        console.error(error)
      })
    }, error => {
      Swal.fire({
        icon : "error",
        title: "GUARDAR",
        text: "Ocurrió un error",
        confirmButtonText: "OK"
      })
      console.error(error)
    })
  }

  

}
