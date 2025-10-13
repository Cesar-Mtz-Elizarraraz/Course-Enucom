package com.mx.Ventas.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "VENTAS")
public class Venta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVenta;
	private String folio;
	private LocalDate fecha;
	private int cantidad;
	private double total;
	private String metodoPago;
	private int clienteId;
	private int empleadoId;
	private Long codigoBarras;
	
	@PrePersist
	public void prePersist() {
		this.fecha = LocalDate.now();
	}
}
