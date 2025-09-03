
public class Celular {
	// Atributos
	String marca;
	String modelo;
	int ram;
	int almacenamiento;
	String color;

	//constructores
	public Celular() {
	}

	public Celular(String marca, String modelo, int ram, int almacenamiento, String color) {
		this.marca = marca;
		this.modelo = modelo;
		this.ram = ram;
		this.almacenamiento = almacenamiento;
		this.color = color;
	}

	//toString
	@Override
	public String toString() {
		return "Celular=>[Marca:" + marca + ", Modelo:" + modelo + ", Ram:" + ram + ", Almacenamiento:" + almacenamiento
				+ "," + "Color:" + color + "]\n";
	}

	//Encapsulamiento
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

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public int getAlmacenamiento() {
		return almacenamiento;
	}

	public void setAlmacenamiento(int almacenamiento) {
		this.almacenamiento = almacenamiento;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
