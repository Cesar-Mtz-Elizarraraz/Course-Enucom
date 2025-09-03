
public class Paciente extends Persona {
	// Atributos
	
	int numeroSeguro;
	String ciudad;
	String padecimiento;
	String alergia;
	String estadoCivil;
	
	public Paciente() {
		super();
	}
	
	public Paciente(String nombre, String apellido, int edad, String genero, int numeroSeguro, String ciudad, String padecimiento, String alergia, String estadoCivil) {
		super(nombre, apellido, edad, genero);
		this.numeroSeguro = numeroSeguro;
		this.ciudad = ciudad;
		this.padecimiento = padecimiento;
		this.alergia = alergia;
		this.estadoCivil = estadoCivil;
	}
	
	@Override
	public String toString() {
		return "Paciente =>[Nombre:" + nombre + ", Apellido:" + apellido + ", Edad:" + edad + ", Género:" + genero + ", Número de seguro:"
				+ numeroSeguro + "," + " Ciudad:" + ciudad + ", Padecimiento:" + padecimiento + ", Alergía:" + alergia + ", Estado Civil:" + estadoCivil + "\n";
	}
	
	public int getNumeroSeguro() {
		return numeroSeguro;
	}
	
	public void setNumeroSeguro(int numeroSeguro) {
		this.numeroSeguro = numeroSeguro;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPadecimiento() {
		return padecimiento;
	}

	public void setPadecimiento(String padecimiento) {
		this.padecimiento = padecimiento;
	}

	public String getAlergia() {
		return alergia;
	}

	public void setAlergia(String alergia) {
		this.alergia = alergia;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	
}
