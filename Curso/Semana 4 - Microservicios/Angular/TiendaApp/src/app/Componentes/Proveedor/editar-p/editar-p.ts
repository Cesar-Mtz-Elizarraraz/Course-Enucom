import { Component, Input } from '@angular/core';
import { FormsModule } from '@angular/forms';
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
  selector: 'app-editar-p',
  imports: [FormsModule],
  templateUrl: './editar-p.html',
  styleUrl: './editar-p.css'
})
export class EditarP {

  constructor(private service: ServiceWS){}

  @Input() proveedor: Proveedor = new Proveedor()
  errores: any
  
  editarProveedor() {
    this.proveedor.telefono = this.proveedor.telefono || 0 

    this.errores = {}
    const validacion = schema.safeParse(this.proveedor);

    if (!validacion.success) {
      this.errores = validacion.error.format();
      return
    }
    
    this.service.editarProveedorWS(this.proveedor).subscribe(data => {
      Swal.fire({
        icon : "success",
        title: "EDITAR",
        text: `El proveedor ${this.proveedor.nombre} se edito correctamente`,
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
