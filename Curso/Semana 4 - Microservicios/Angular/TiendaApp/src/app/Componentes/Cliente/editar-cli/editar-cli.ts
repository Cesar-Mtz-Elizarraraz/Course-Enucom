import { Component, Input } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ServiceWS } from '../../../Service/service-ws';
import { Cliente } from '../../../Entidades/Cliente';
import Swal from 'sweetalert2';
import { z } from 'zod';

const schema = z.object({
  nombre: z.string().min(1, 'El nombre es obligatorio').max(50, "Máximo 50 caracteres").regex(/^[A-Za-zÁÉÍÓÚáéíóúÑñ\s]+$/, 'Solo se pueden contener letras y espacios'),
  apm: z.string().min(1, 'El apellido materno es obligatorio').max(50, "Máximo 50 caracteres").regex(/^[A-Za-zÁÉÍÓÚáéíóúÑñ\s]+$/, 'Solo se pueden contener letras y espacios'),
  app: z.string().min(1, 'El apellido paterno es obligatorio').max(50, "Máximo 50 caracteres").regex(/^[A-Za-zÁÉÍÓÚáéíóúÑñ\s]+$/, 'Solo se pueden contener letras y espacios'),
  telefono: z.number().refine(val => val >= 1000000000n && val <= 9999999999n, { message: 'El teléfono debe tener exactamente 10 dígitos' }),
});

@Component({
  selector: 'app-editar-cli',
  imports: [FormsModule],
  templateUrl: './editar-cli.html',
  styleUrl: './editar-cli.css'
})
export class EditarCli {
  constructor(private service: ServiceWS){}

  @Input() cliente: Cliente = new Cliente()
  errores: any

  editarCliente() {
    this.cliente.telefono = this.cliente.telefono || 0 
    
    this.errores = {}
    const validacion = schema.safeParse(this.cliente);

    if (!validacion.success) {
      this.errores = validacion.error.format();
      return
    }
    this.service.editarClienteWS(this.cliente).subscribe(data => {
      Swal.fire({
        icon : "success",
        title: "EDITAR",
        text: `El cliente ${this.cliente.nombre} se edito correctamente`,
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
