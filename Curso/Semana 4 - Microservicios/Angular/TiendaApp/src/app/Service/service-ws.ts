import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Proveedor } from '../Entidades/Proveedor';
import { Observable } from 'rxjs';
import { Categoria } from '../Entidades/Categoria';
import { Empleado } from '../Entidades/Empleado';
import { Cliente } from '../Entidades/Cliente';
import { Producto, ProductoForm } from '../Entidades/Producto';
import { Venta, VentaForm } from '../Entidades/Venta';

@Injectable({
  providedIn: 'root'
})
export class ServiceWS {
  constructor(private http : HttpClient){}

  url = "http://localhost:9000"

  listarProveedorWS(){
    return this.http.get<Proveedor[]>(`${this.url}/Prov`)
  }

  guardarProveedorWS(proveedor: Proveedor){
    return this.http.post<String>(`${this.url}/Prov`, proveedor, {responseType: "text" as "json"})
  }

  editarProveedorWS(proveedor: Proveedor){
    return this.http.put<String>(`${this.url}/Prov`, proveedor, {responseType: "text" as "json"})
  }

  buscarProveedorWS(proveedor: Proveedor){
    return this.http.get<Proveedor>(`${this.url}/Prov/${proveedor.idProveedor}`)
  }

  eliminarProveedorWS(proveedor: Proveedor): Observable<void>{
    return this.http.delete<void>(`${this.url}/Prov/${proveedor.idProveedor}`)
  }


  listarCategoriaWS(){
    return this.http.get<Categoria[]>(`${this.url}/C`)
  }

  guardarCategoriaWS(categoria: Categoria){
    return this.http.post<String>(`${this.url}/C`, categoria, {responseType: "text" as "json"})
  }

  editarCategoriaWS(categoria: Categoria){
    return this.http.put<String>(`${this.url}/C`, categoria, {responseType: "text" as "json"})
  }

  buscarCategoriaWS(categoria: Categoria){
    return this.http.get<Categoria>(`${this.url}/C/${categoria.idCategoria}`)
  }

  eliminarCategoriaWS(categoria: Categoria): Observable<void>{
    return this.http.delete<void>(`${this.url}/C/${categoria.idCategoria}`)
  }


  listarEmpleadoWS(){
    return this.http.get<Empleado[]>(`${this.url}/E`)
  }

  guardarEmpleadoWS(empleado: Empleado){
    return this.http.post<String>(`${this.url}/E`, empleado, {responseType: "text" as "json"})
  }

  editarEmpleadoWS(empleado: Empleado){
    return this.http.put<String>(`${this.url}/E`, empleado, {responseType: "text" as "json"})
  }

  buscarEmpleadoWS(empleado: Empleado){
    return this.http.get<Empleado>(`${this.url}/E/${empleado.idEmpleado}`)
  }

  eliminarEmpleadoWS(empleado: Empleado): Observable<void>{
    return this.http.delete<void>(`${this.url}/E/${empleado.idEmpleado}`)
  }


  listarClienteWS(){
    return this.http.get<Cliente[]>(`${this.url}/Cli`)
  }

  guardarClienteWS(cliente: Cliente){
    return this.http.post<String>(`${this.url}/Cli`, cliente, {responseType: "text" as "json"})
  }

  editarClienteWS(cliente: Cliente){
    return this.http.put<String>(`${this.url}/Cli`, cliente, {responseType: "text" as "json"})
  }

  buscarClienteWS(cliente: Cliente){
    return this.http.get<Cliente>(`${this.url}/Cli/${cliente.idCliente}`)
  }

  eliminarClienteWS(cliente: Cliente): Observable<void>{
    return this.http.delete<void>(`${this.url}/Cli/${cliente.idCliente}`)
  }


  listarProductoWS(){
    return this.http.get<Producto[]>(`${this.url}/P/listarFull`)
  }

  guardarProductoWS(producto: ProductoForm){
    return this.http.post<String>(`${this.url}/P`, producto, {responseType: "text" as "json"})
  }

  editarProductoWS(producto: ProductoForm){
    return this.http.put<String>(`${this.url}/P`, producto, {responseType: "text" as "json"})
  }

  editarMultipleProductoWS(productos: ProductoForm[]){
    return this.http.put<String>(`${this.url}/P/editarMultiple`, productos, {responseType: "text" as "json"})
  }

  buscarProductoWS(producto: Producto){
    return this.http.get<ProductoForm>(`${this.url}/P/${producto.codigoBarras}`)
  }

  eliminarProductoWS(producto: Producto): Observable<void>{
    return this.http.delete<void>(`${this.url}/P/${producto.codigoBarras}`)
  }


  listarVentaWS(){
    return this.http.get<Venta[]>(`${this.url}/V/listarFull`)
  }

  guardarVentaWS(venta: VentaForm[]){
    return this.http.post<String>(`${this.url}/V/guardarMultiple`, venta, {responseType: "text" as "json"})
  }

  editarVentaWS(venta: VentaForm){
    return this.http.put<String>(`${this.url}/V`, venta, {responseType: "text" as "json"})
  }

  buscarVentaWS(venta: Venta){
    return this.http.get<VentaForm>(`${this.url}/V/${venta.idVenta}`)
  }

  eliminarVentaWS(venta: Venta): Observable<void>{
    return this.http.delete<void>(`${this.url}/V/${venta.idVenta}`)
  }
}
