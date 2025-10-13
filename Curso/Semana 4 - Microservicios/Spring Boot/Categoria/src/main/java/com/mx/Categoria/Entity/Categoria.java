package com.mx.Categoria.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/* H2 DataBase o base de datos embebida: ES una base de datos de código abierto. Puede integrarse en aplicaciones Java o ejecutarse
 * en modo cliente-servidor. 
 * Principalmente puede configurarse para ejecutarse como una base de datos en memoria, lo que significa que los datos no persistiran en el disco */

@Entity
@Table
@Data
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCategoria;
	private String nombre;
	private String descripcion;
}
