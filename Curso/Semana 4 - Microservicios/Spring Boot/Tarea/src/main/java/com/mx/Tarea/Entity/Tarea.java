package com.mx.Tarea.Entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
public class Tarea {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String titulo;
	private String descripcion;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaCreacion;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaVencimiento;
	// La anotación @Enumerated indica que el campo 'estado' es un valor enumerado (enum) y le dice a JPA cómo debe guardar ese valor en la base de datos
	// En este caso, se indica que guarde el valor del enum como una cadena de texto String
	// @Enumerated(EnumType.STRING)
	private String estado;
	
	@PrePersist
	public void prePersist() {
		this.fechaCreacion = LocalDate.now();
	}
	
	
}
