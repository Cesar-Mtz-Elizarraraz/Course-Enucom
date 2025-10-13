package com.mx.Dinero.Entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "DINERO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dinero {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDinero;
	private String tipo;
	private int cantidad;
	private BigDecimal denominacion;
}
