package com.mx.Producto.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "PRODUCTOS") // Mapea dentro de la base de datos la tabla que se esta representando
// Si el nombre de la clase no coincide con la tabla de la BD, se debe especificar la tabla a mapear
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
// @Data simplifica todas las anotaciones anteriores
public class Producto {
	@Id
	private long codigoBarras; 
	private String nombre;
	private double precio;
	private int stock;
	private int descuento;
	private int categoriaId;
	private int proveedorId;
}
