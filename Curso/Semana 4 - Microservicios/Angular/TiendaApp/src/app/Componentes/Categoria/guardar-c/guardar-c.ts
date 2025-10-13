import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ServiceWS } from '../../../Service/service-ws';
import { Categoria } from '../../../Entidades/Categoria';
import Swal from 'sweetalert2';
import { z } from 'zod';

const schema = z.object({
  nombre: z.string().min(1, 'El nombre es obligatorio').max(100, "Máximo 100 caracteres").regex(/^[A-Za-zÁÉÍÓÚáéíóúÑñ\s]+$/, 'Solo se pueden contener letras y espacios'),
  descripcion: z.string().min(1, 'La descripción es obligatoria').max(255, "Máximo 255 caracteres").regex(/^[A-Za-zÁÉÍÓÚáéíóúÑñ0-9_.,&%:)(\s-]+$/, 'No se pueden contener caracteres especiales excepto (,.:-_&%)'),
});

@Component({
  selector: 'app-guardar-c',
  imports: [FormsModule],
  templateUrl: './guardar-c.html',
  styleUrl: './guardar-c.css'
})
export class GuardarC {
  constructor(private service: ServiceWS){}
  
  categoria: Categoria = new Categoria()
  errores: any

  guardarCategoria() {
    this.errores = {}
    const validacion = schema.safeParse(this.categoria);

    if (!validacion.success) {
      this.errores = validacion.error.format();
      return
    }

    this.service.guardarCategoriaWS(this.categoria).subscribe(data => {

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
