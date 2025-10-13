package com.mx.Veterinarias.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "VETERINARIAS")
@Data
@RequiredArgsConstructor
public class Veterinaria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVeterinaria;
	private String nombre;
	private String direccion;
	private Long telefono;
}
