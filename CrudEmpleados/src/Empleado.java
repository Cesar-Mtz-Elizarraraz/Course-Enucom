
public class Empleado {
	// Atributos
	int numero;
	String nombre;
	String apellido;
	int edad;
	String genero;
	String puesto;
	String ciudad;
	
	public Empleado() {
	}

	public Empleado(int numero, String nombre, String apellido, int edad, String genero, String puesto, String ciudad) {
		this.numero = numero;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.genero = genero;
		this.puesto = puesto;
		this.ciudad = ciudad;
	}

	@Override
	public String toString() {
		return "Empleado => [Número:" + numero + ", Nombre:" + nombre + ", Apellido:" + apellido + ", Edad:" + edad + ", Género:" + genero + ","
				+ " Puesto:" + puesto +  ", Ciudad:" + ciudad + "]\n";
	}

	// GET's y SET's
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

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

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	
	
}
