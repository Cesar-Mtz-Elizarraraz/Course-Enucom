import { Component, Input } from '@angular/core';
import { ServiceWS } from '../../../Service/service-ws';
import { FormsModule } from '@angular/forms';
import { VentaForm } from '../../../Entidades/Venta';
import Swal from 'sweetalert2';
import { Producto } from '../../../Entidades/Producto';
import { Cliente } from '../../../Entidades/Cliente';
import { Empleado } from '../../../Entidades/Empleado';
import { z } from 'zod';

const schema = z.object({
  clienteId: z.number().refine(val => val >= 1, { message: 'El cliente es obligatorio' }),
  empleadoId: z.number().refine(val => val >= 1, { message: 'El empleado es obligatorio' }),
  fecha: z.string().min(10, 'La fecha es obligatoria').regex(/^\d{4}-\d{2}-\d{2}$/, 'La fecha no cumple con el formato solicitado'),
  metodoPago: z.enum(['Efectivo', 'Tarjeta', 'Transferencia'], {errorMap: () => ({ message: 'El método de pago es obligatorio' })}),
});

@Component({
  selector: 'app-editar-v',
  imports: [FormsModule],
  templateUrl: './editar-v.html',
  styleUrl: './editar-v.css'
})
export class EditarV {
  constructor(private service: ServiceWS){}

  @Input() venta!: VentaForm;
  productos !: Producto[]
  clientes !: Cliente[]
  empleados !: Empleado[]
  errores : any

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
  
  editarVenta() {

    this.errores = {}
    const validacion = schema.safeParse(this.venta);

    if (!validacion.success) {
      this.errores = validacion.error.format();
      return
    }

    this.service.editarVentaWS(this.venta).subscribe(data => {
      Swal.fire({
        icon : "success",
        title: "EDITAR",
        text: `El venta con ID ${this.venta.idVenta} se edito correctamente`,
        confirmButtonText: "OK"
      }).then((result) => {
        if (result.isConfirmed) {
          window.location.reload();
        }
      });
    }, error => {
      Swal.fire({
        icon : "error",
        title: "EDITAR",
        text: "Ocurrió un error",
        confirmButtonText: "OK"
      })
      console.error(error)
    })
  }
}
