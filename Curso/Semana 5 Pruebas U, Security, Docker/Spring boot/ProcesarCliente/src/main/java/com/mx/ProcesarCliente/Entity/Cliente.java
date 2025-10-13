package com.mx.ProcesarCliente.Entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table
@Data
@RequiredArgsConstructor
public class Cliente {
	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull(message = "El ID del cliente no puede ser nulo")
	@Positive(message = "El ID debe ser un número positivo")
	private Long idClienteDigital;
	@NotBlank(message = "El nombre no puede estar vacío")
	@Pattern(regexp = "^[A-Za-zÁÉÍÓÚÑáéíóúñ ]+$", message = "El nombre solo puede contener letras y espacios")
	private String nombre;
	@NotBlank(message = "El apellido paterno no puede estar vacío")
	@Pattern(regexp = "^[A-Za-zÁÉÍÓÚÑáéíóúñ ]+$", message = "El apellido paterno solo puede contener letras y espacios")
	private String apellidoPaterno;
	@NotBlank(message = "El apellido materno no puede estar vacío")
	@Pattern(regexp = "^[A-Za-zÁÉÍÓÚÑáéíóúñ ]+$", message = "El apellido materno solo puede contener letras y espacios")
	private String apellidoMaterno;
	@Pattern(regexp = "^(M|F)?$", message = "El género debe ser M, F")
	private String genero;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate fechaNacimiento;
	@NotBlank(message = "El curp no puede estar vacío")
	private String curp;
	
	@Valid
	@OneToOne(cascade = CascadeType.ALL) // Todas las operaciones que hagas sobre esa entidad principal también deben aplicarse a la entidad relacionada
    @JoinColumn(name = "contactoId", referencedColumnName = "idContacto")
    private Contacto contacto;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "domicilioId", referencedColumnName = "idDomicilio")
    private Domicilio domicilio;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "documentacionId", referencedColumnName = "idDocumentacion")
    private Documentacion documentacion;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "beneficiarioId", referencedColumnName = "idBeneficiario")
    private Beneficiario beneficiario;

    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contratoId", referencedColumnName = "idContrato")
    private Contrato contrato;

    @Valid
    // Cada cliente pertenece a un solo producto
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productoId")
    private Producto productoId;
}
