import { Component, OnInit } from '@angular/core';
import { Producto, ProductoForm } from '../../../Entidades/Producto';
import { ServiceWS } from '../../../Service/service-ws';
import Swal from 'sweetalert2';
import { FormsModule } from '@angular/forms';
import { Categoria } from '../../../Entidades/Categoria';
import { Proveedor } from '../../../Entidades/Proveedor';
import { z } from 'zod';

const schema = z.object({
  codigoBarras: z.number().refine(val => val >= 10000000n && val <= 99999999999999n, { message: 'El código de barras debe tener entre 8 y 14 dígitos' }),
  nombre: z.string().min(1, 'El nombre es obligatorio').max(120, "Máximo 120 caracteres").regex(/^[A-Za-zÁÉÍÓÚáéíóúÑñ0-9_.,&%:)(\s-]+$/, 'No se pueden contener caracteres especiales excepto (,.:-_&%)'),
  precio: z.number().refine(val => val >= 0.01 && val <= 1000000, { message: 'El precio debe estar entre $0.01 y $1000000' }),
  stock: z.number().refine(val => val >= 0 && val <= 1000000, { message: 'El stock debe estar entre 0 y 1000000' }),
  descuento: z.number().refine(val => val >= 0 && val <= 100, { message: 'El descuento debe estar entre 0% y 100%' }),
  // idCat: z.number().refine(val => val >= 1, { message: 'La categoría es obligatoria' }),
  // idProv: z.number().refine(val => val >= 1, { message: 'El proveedor es obligatoria' }),
});

@Component({
  selector: 'app-guardar-p',
  imports: [FormsModule],
  templateUrl: './guardar-p.html',
  styleUrl: './guardar-p.css'
})
export class GuardarP implements OnInit {
  constructor(private service: ServiceWS){}
  
  producto: Producto = new Producto()
  categorias!: Categoria[]
  proveedores!: Proveedor[]
  idCat?: number = 0
  idProv?: number = 0
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

  guardarProducto() {

    this.producto.precio = this.producto.precio || 0
    this.producto.stock = this.producto.stock || 0
    this.producto.descuento = this.producto.descuento || 0

    const data = {
      codigoBarras: this.producto.codigoBarras, 
      nombre: this.producto.nombre,
      precio: this.producto.precio,
      stock: this.producto.stock,
      descuento: this.producto.descuento,
      ...(this.idCat && {categoriaId: this.idCat}), 
      ...(this.idProv && {proveedorId: this.idProv})
    }

    this.errores = {}
    const validacion = schema.safeParse(data);

    if (!validacion.success) {
      this.errores = validacion.error.format();
      return
    }

    this.service.guardarProductoWS(data).subscribe(data => {
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
