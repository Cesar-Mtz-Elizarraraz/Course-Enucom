import { Component } from '@angular/core';
import { ServiceWS } from '../../../Service/service-ws';
import { Empleado } from '../../../Entidades/Empleado';
import Swal from 'sweetalert2';
import { FormsModule } from '@angular/forms';
import { z } from 'zod';

const schema = z.object({
  nombre: z.string().min(1, 'El nombre es obligatorio').max(100, "Máximo 100 caracteres").regex(/^[A-Za-zÁÉÍÓÚáéíóúÑñ\s]+$/, 'Solo se pueden contener letras y espacios'),
  apellido: z.string().min(1, 'El apellido es obligatorio').max(150, "Máximo 150 caracteres").regex(/^[A-Za-zÁÉÍÓÚáéíóúÑñ\s]+$/, 'Solo se pueden contener letras y espacios'),
  telefono: z.number().refine(val => val >= 1000000000n && val <= 9999999999n, { message: 'El teléfono debe tener exactamente 10 dígitos' }),
  puesto: z.string().min(1, 'El puesto es obligatorio').max(100, "Máximo 100 caracteres").regex(/^[A-Za-zÁÉÍÓÚáéíóúÑñ\s]+$/, 'Solo se pueden contener letras y espacios'),
});

@Component({
  selector: 'app-guardar-e',
  imports: [FormsModule],
  templateUrl: './guardar-e.html',
  styleUrl: './guardar-e.css'
})
export class GuardarE {
  constructor(private service: ServiceWS){}
  
  empleado: Empleado = new Empleado()
  errores: any

  guardarEmpleado() {
    this.empleado.telefono = this.empleado.telefono || 0 

    this.errores = {}
    const validacion = schema.safeParse(this.empleado);

    if (!validacion.success) {
      this.errores = validacion.error.format();
      return
    }

    this.service.guardarEmpleadoWS(this.empleado).subscribe(data => {

      Swal.fire({
        icon : "success",
        title: "GUARDAR",
        text: JSON.stringify(data),
        confirmButtonText: "OK"
      }).then((result) => {
        if (result.isConfirmed) {
          window.location.reload();
        }
      })
    }, error => {
      Swal.fire({
        icon : "error",
        title: "GUARDAR",
        text: error.error,
        confirmButtonText: "OK"
      })
      console.error(error)
    })
  }
}
