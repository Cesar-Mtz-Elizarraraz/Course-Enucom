import java.util.List;

public class Persona extends Individuo {
	String apellido;
	String ciudad;
	String estadoCivil;
	List<Mascota> mascotas;

	public Persona() {
		super();
	}

	public Persona(String nombre, int edad, String sexo, String apellido, String ciudad, String estadoCivil,
			List<Mascota> mascotas) {
		super(nombre, edad, sexo);
		this.apellido = apellido;
		this.ciudad = ciudad;
		this.estadoCivil = estadoCivil;
		this.mascotas = mascotas;
	}

	@Override
	public String toString() {
		return "Persona =>[Nombre:" + nombre + ", Apellido:" + apellido + ", Edad:" + edad + ", Sexo:" + sexo
				+ ", Ciudad:" + ciudad + "," + " EstadoCivil:" + estadoCivil + "\n Mascotas:\n" + mascotas + "]\n";
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public List<Mascota> getMascotas() {
		return mascotas;
	}

	public void setMascotas(List<Mascota> mascotas) {
		this.mascotas = mascotas;
	}

}
