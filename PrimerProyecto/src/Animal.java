
public class Animal {
    //Atributos
	String nombre; //Esta es una variable y un objeto
	int edad;      //Esta es una variable pero no es un objeto
	String sexo;
	String especie;
	String color;
	double altura;
	
	//Constructores
	public Animal() {
	} 
	
	public Animal(String nombre,int edad,String sexo,String especie,String color,double altura) {
	    this.nombre = nombre;
	    this.edad = edad;
	    this.sexo = sexo;
	    this.especie = especie;
	    this.color = color;
	    this.altura = altura;
	}
	
	//toString
	@Override
	public String toString() {
		return "Animal =>[Nombre:"+nombre+",Edad:"+edad+",Sexo:"+sexo+",Especie:"+especie+","
				+ "Color:"+color+",Altura:"+altura+"]\n";
	}
	
	//Encapsulamiento
	public String getNombre() {
	    return nombre;
	}
	
	public void setNombre(String nombre) {
	    this.nombre	= nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	

}
