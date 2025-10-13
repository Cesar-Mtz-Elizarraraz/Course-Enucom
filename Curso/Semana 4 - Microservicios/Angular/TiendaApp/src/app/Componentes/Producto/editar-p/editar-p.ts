import { Component, Input } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ServiceWS } from '../../../Service/service-ws';
import { ProductoForm } from '../../../Entidades/Producto';
import Swal from 'sweetalert2';
import { Categoria } from '../../../Entidades/Categoria';
import { Proveedor } from '../../../Entidades/Proveedor';
import { z } from 'zod';

const schema = z.object({
  // codigoBarras: z.number().refine(val => val >= 10000000n && val <= 99999999999999n, { message: 'El código de barras debe tener entre 8 y 14 dígitos' }),
  nombre: z.string().min(1, 'El nombre es obligatorio').max(120, "Máximo 120 caracteres").regex(/^[A-Za-zÁÉÍÓÚáéíóúÑñ0-9_.,&%:)(\s-]+$/, 'No se pueden contener caracteres especiales excepto (,.:-_&%)'),
  precio: z.number().refine(val => val >= 0.01 && val <= 1000000, { message: 'El precio debe estar entre $0.01 y $1000000' }),
  stock: z.number().refine(val => val >= 0 && val <= 1000000, { message: 'El stock debe estar entre 0 y 1000000' }),
  descuento: z.number().refine(val => val >= 0 && val <= 100, { message: 'El descuento debe estar entre 0% y 100%' }),
  // idCat: z.number().refine(val => val >= 1, { message: 'La categoría es obligatoria' }),
  // idProv: z.number().refine(val => val >= 1, { message: 'El proveedor es obligatoria' }),
});

@Component({
  selector: 'app-editar-p',
  imports: [FormsModule],
  templateUrl: './editar-p.html',
  styleUrl: './editar-p.css'
})
export class EditarP {
  constructor(private service: ServiceWS){}

  @Input() producto!: ProductoForm;
  categorias!: Categoria[]
  proveedores!: Proveedor[]
  errores: any

  ngOnInit(): void {
    this.listarCategorias()
    this.listarProveedores()
  }

  listarCategorias(){
    this.service.listarCategoriaWS().subscribe(data => {
      this.categorias = data
    })
  }

  listarProveedores(){
    this.service.listarProveedorWS().subscribe(data => {
      this.proveedores = data
    })
  }
  
  editarProducto() {
    this.producto.precio = this.producto.precio || 0
    this.producto.stock = this.producto.stock || 0
    this.producto.descuento = this.producto.descuento || 0

    this.errores = {}
    const validacion = schema.safeParse(this.producto);

    if (!validacion.success) {
      this.errores = validacion.error.format();
      return
    }

    this.service.editarProductoWS(this.producto).subscribe(data => {
      Swal.fire({
        icon : "success",
        title: "EDITAR",
        text: `El producto ${this.producto.nombre} se edito correctamente`,
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
