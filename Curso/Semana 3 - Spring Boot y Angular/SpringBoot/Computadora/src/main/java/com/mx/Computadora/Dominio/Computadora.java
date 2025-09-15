package com.mx.Computadora.Dominio;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
@Entity // es de DataJPA e indica que la clase sera la representacion de una entidad en la BD
@Table(name = "COMPUTADORA") // es de DataJPA e indica la tabla que estoy representando en la clase
// mapea dentro de la BD y busca dentro de la conexión si el nombre de la tabla coincide y realiza la conexión
public class Computadora {
	@Id // es de DataJPA y es para especificar que el atributo que sigue despues de esta anotación es el identificador de mi clase
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Le indico a Spring que el identificador se generará automaticamente
	// ID_COMPU usar CamelCase
	private int idCompu;
	@Column(name = "MARCA", columnDefinition = "NVARCHAR2(100)") //DataJPA: es para mapear el nombre de la columna en la BD del atributo
	private String marca;
	@Column(name = "MODELO", columnDefinition = "NVARCHAR2(100)")
	private String modelo;
	@Column(name = "PROCESADOR", columnDefinition = "NVARCHAR2(100)")
	private String procesador;
	@Column(name = "RAM", columnDefinition = "NUMBER")
	private String ram;
	@Column(name = "CAPACIDAD", columnDefinition = "NVARCHAR2(10)")
	private String capacidad;
	@Column(name = "COLOR", columnDefinition = "NVARCHAR2(100)")
	private String color;
	@Column(name = "PRECIO", columnDefinition = "NUMBER")
	private int precio;
	
	public Computadora() {
		
	}

	public Computadora(int idCompu, String marca, String modelo, String procesador, String ram, String capacidad,
			String color, int precio) {
		super();
		this.idCompu = idCompu;
		this.marca = marca;
		this.modelo = modelo;
		this.procesador = procesador;
		this.ram = ram;
		this.capacidad = capacidad;
		this.color = color;
		this.precio = precio;
	}

	public int getIdCompu() {
		return idCompu;
	}

	public void setIdCompu(int idCompu) {
		this.idCompu = idCompu;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getProcesador() {
		return procesador;
	}

	public void setProcesador(String procesador) {
		this.procesador = procesador;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	
}
