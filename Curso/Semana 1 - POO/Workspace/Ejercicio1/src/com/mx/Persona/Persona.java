package com.mx.Persona;

public class Persona {
	// Declaración de los atributos: Son las variables que representan el estado del objeto
	private String nombre;
	private String apellido;
	private int edad;
	private String nacionalidad;
	
	// Declaración de los métodos: Son las funciones que describen el comportamiento de los objetos
	
	// Constructor por defecto(defautl) o conocido como vacío: inicializa el objeto
	public Persona() {
	}
	
	// Constructor parametrizado: Inicializa el objeto con los parámetros(atributos) específicos
	public Persona(String nombre, String apellido, int edad, String nacionalidad) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.nacionalidad = nacionalidad;
	}
	
	// Métodos GET y SET: En algún momento yo voy a querer acceder a los atributos, pero al ser declarados en private no se
	// puede acceder desde otra clase
	
	// GET: Permiten obtener el valor del atributo
	
	public String getNombre() {
		return nombre;
	}
	
	// SET: Permiten modificar el valor del atributo con validaciones
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	
}
