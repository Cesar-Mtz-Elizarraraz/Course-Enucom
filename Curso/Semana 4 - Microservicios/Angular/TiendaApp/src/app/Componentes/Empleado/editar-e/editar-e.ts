import { Component, Input } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ServiceWS } from '../../../Service/service-ws';
import { Empleado } from '../../../Entidades/Empleado';
import Swal from 'sweetalert2';
import { z } from 'zod';

const schema = z.object({
  nombre: z.string().min(1, 'El nombre es obligatorio').max(100, "Máximo 100 caracteres").regex(/^[A-Za-zÁÉÍÓÚáéíóúÑñ\s]+$/, 'Solo se pueden contener letras y espacios'),
  apellido: z.string().min(1, 'El apellido es obligatorio').max(150, "Máximo 150 caracteres").regex(/^[A-Za-zÁÉÍÓÚáéíóúÑñ\s]+$/, 'Solo se pueden contener letras y espacios'),
  telefono: z.number().refine(val => val >= 1000000000n && val <= 9999999999n, { message: 'El teléfono debe tener exactamente 10 dígitos' }),
  puesto: z.string().min(1, 'El puesto es obligatorio').max(100, "Máximo 100 caracteres").regex(/^[A-Za-zÁÉÍÓÚáéíóúÑñ\s]+$/, 'Solo se pueden contener letras y espacios'),
});

@Component({
  selector: 'app-editar-e',
  imports: [FormsModule],
  templateUrl: './editar-e.html',
  styleUrl: './editar-e.css'
})
export class EditarE {
  constructor(private service: ServiceWS){}

  @Input() empleado: Empleado = new Empleado()
  errores: any

  editarEmpleado() {

    this.empleado.telefono = this.empleado.telefono || 0 

    this.errores = {}
    const validacion = schema.safeParse(this.empleado);

    if (!validacion.success) {
      this.errores = validacion.error.format();
      return
    }
    
    this.service.editarEmpleadoWS(this.empleado).subscribe(data => {
      Swal.fire({
        icon : "success",
        title: "EDITAR",
        text: `El empleado ${this.empleado.nombre} se edito correctamente`,
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
