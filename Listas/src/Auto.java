
public class Auto {
	// Atributos
	String matricula;
	String modelo;
	String marca;
	int anio;
	int cilindros;
	int numeroPuertas;

	// Constructores
	public Auto() {
	}

	public Auto(String matricula, String modelo, String marca, int anio, int cilindros, int numeroPuertas) {
		this.matricula = matricula;
		this.modelo = modelo;
		this.marca = marca;
		this.anio = anio;
		this.cilindros = cilindros;
		this.numeroPuertas = numeroPuertas;
	}

	@Override
	public String toString() {
		return "Auto => [Matricula:" + matricula + ", Modelo:" + modelo + ", Marca:" + marca + ", Año:" + anio + ","
				+ " Cilindros:" + cilindros + ", NumeroPuertas:" + numeroPuertas + "]\n";
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public int getCilindros() {
		return cilindros;
	}

	public void setCilindros(int cilindros) {
		this.cilindros = cilindros;
	}

	public int getNumeroPuertas() {
		return numeroPuertas;
	}

	public void setNumeroPuertas(int numeroPuertas) {
		this.numeroPuertas = numeroPuertas;
	}

}
