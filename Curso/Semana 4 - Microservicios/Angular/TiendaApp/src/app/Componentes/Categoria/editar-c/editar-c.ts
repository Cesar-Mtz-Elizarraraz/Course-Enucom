import { Component, Input } from '@angular/core';
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
  selector: 'app-editar-c',
  imports: [FormsModule],
  templateUrl: './editar-c.html',
  styleUrl: './editar-c.css'
})
export class EditarC {
  constructor(private service: ServiceWS){}

  @Input() categoria: Categoria = new Categoria()
  errores: any

  editarCategoria() {

    this.errores = {}
    const validacion = schema.safeParse(this.categoria);

    if (!validacion.success) {
      this.errores = validacion.error.format();
      return
    }

    this.service.editarCategoriaWS(this.categoria).subscribe(data => {
      Swal.fire({
        icon : "success",
        title: "EDITAR",
        text: `La categoría ${this.categoria.nombre} se edito correctamente`,
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
        text: error?.error || "Ocurrió un error",
        confirmButtonText: "OK"
      })
      console.error(error)
    })
  }
}
