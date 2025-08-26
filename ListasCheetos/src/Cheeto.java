
public class Cheeto {
	// Atributos
	String  nombre;
	String  marca;
	double  gramaje;
	double precio;
	String  caducidad;
	boolean promocion;
	
	// Constructor vacío
	public Cheeto() {
	}
	
	// Constructor con parametros
	public Cheeto(String nombre, String marca, double gramaje, double precio, String caducidad, boolean promocion) {
		this.nombre = nombre;
		this.marca = marca;
		this.gramaje = gramaje;
		this.precio = precio;
		this.caducidad = caducidad;
		this.promocion = promocion;
	}
	
	@Override
	public String toString() {
		return "Cheetos => [Nombre:" + nombre + ", Marca:" + marca + ", Gramaje:" + gramaje + ", Precio:$" + precio + ", Caducidad:" + caducidad + ","
				+ " Promoción:" + (promocion ? "Activa" : "Inactiva") + "]\n";
	}

	// GET's y SET's
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getGramaje() {
		return gramaje;
	}

	public void setGramaje(double gramaje) {
		this.gramaje = gramaje;
	}
	
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getCaducidad() {
		return caducidad;
	}

	public void setCaducidad(String caducidad) {
		this.caducidad = caducidad;
	}

	public boolean isPromocion() {
		return promocion;
	}

	public void setPromocion(boolean promocion) {
		this.promocion = promocion;
	}
	
	
}

