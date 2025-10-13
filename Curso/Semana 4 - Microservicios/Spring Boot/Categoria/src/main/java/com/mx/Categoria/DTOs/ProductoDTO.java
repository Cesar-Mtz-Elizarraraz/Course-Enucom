package com.mx.Categoria.DTOs;

import lombok.Data;
//DTO: Data Transfer Object (Objeto de Transferencia de Datos)
/*
 * Es una clase que solo contiene datos, sin una lógica de negocios
 * su proposito principal es transportar la informacióm entre capas de una aplicación o entre microservicios
 * Generalmente incluye atributos, constructores, getter y setter, pero no metodos complejos
 * */
@Data
public class ProductoDTO {
	private long codigoBarras; 
	private String nombre;
	private double precio;
	private int stock;
	private int descuento;
	private int categoriaId;
	private int proveedorId;
}
