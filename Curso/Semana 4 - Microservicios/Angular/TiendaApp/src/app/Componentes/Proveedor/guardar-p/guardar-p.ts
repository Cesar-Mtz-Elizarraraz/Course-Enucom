import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { ServiceWS } from '../../../Service/service-ws';
import { Proveedor } from '../../../Entidades/Proveedor';
import Swal from 'sweetalert2';
import { z } from 'zod';

const schema = z.object({
  nombre: z.string().min(1, 'El nombre es obligatorio').max(255, "Máximo 255 caracteres").regex(/^[A-Za-zÁÉÍÓÚáéíóúÑñ\s]+$/, 'Solo se pueden contener letras y espacios'),
  telefono: z.number().refine(val => val >= 1000000000n && val <= 9999999999n, { message: 'El teléfono debe tener exactamente 10 dígitos' }),
  email: z.string().min(1, 'El email es obligatorio').max(100, "Máximo 100 caracteres").email('El correo no es válido'),
});

@Component({
  selector: 'app-guardar-p',
  imports: [FormsModule],
  templateUrl: './guardar-p.html',
  styleUrl: './guardar-p.css'
})
export class GuardarP {

  constructor(private service: ServiceWS){}

  proveedor: Proveedor = new Proveedor()
  errores: any

  guardarProveedor() {
    this.proveedor.telefono = this.proveedor.telefono || 0 

    this.errores = {}
    const validacion = schema.safeParse(this.proveedor);

    if (!validacion.success) {
      this.errores = validacion.error.format();
      return
    }

    this.service.guardarProveedorWS(this.proveedor).subscribe(data => {

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
