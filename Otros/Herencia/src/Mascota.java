
public class Mascota extends Individuo {
	String especie;
	String raza;
	double peso;
	double altura;

	public Mascota() {
		super();
	}

	public Mascota(String nombre, int edad, String sexo, String especie, String raza, double peso, double altura) {
		super(nombre, edad, sexo);
		this.especie = especie;
		this.raza = raza;
		this.peso = peso;
		this.altura = altura;
	}

	@Override
	public String toString() {
		return "Mascota =>[Nombre:" + nombre + ", Especie:" + especie + ", Raza:" + raza + ", Edad:" + edad + ", Sexo:"
				+ sexo + "," + " Peso:" + peso + ", Altura:" + altura + "]\n";
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

}
