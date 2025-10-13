package com.mx.ProcesarCliente.Entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table
@Data
@RequiredArgsConstructor
public class Producto {
	
	@Id
	@NotNull(message = "El ID del producto no puede ser nulo")
	private String idProducto;
	
	// Un producto puede tener muchos clientes
	@OneToMany(mappedBy = "productoId", cascade = CascadeType.ALL)
	@JsonIgnore
    List<Cliente> clientes = new ArrayList<>(); // La relación se hace con Cliente
}
