
public class Main {
    public static void main(String[] args) {
	    //Instanciar un objeto
    	Animal animal;
    	
    	//Instanciar e inicializar un objeto con el contructor vacio
    	Animal animal0 = new Animal();
    	
    	//Inicializar los atributos de un objeto
    	animal0.nombre = "Copito";
    	animal0.edad = 5;
    	animal0.color = "Blanco";
    	animal0.altura = 35.2;
    	animal0.especie = "Perro";
    	animal0.sexo = "Macho";
    	
    	//Mostrar el contenido de un objeto
    	System.out.println(animal0);
    	
    	//Instanciar e inicilizar un objeto con el contructor de todos los parametros
    	Animal animal1 = new Animal("Cheems", 5, "Hembra", "Perro", "Naranja", 40.2);
    	System.out.println(animal1);
    	
    	//Mostrar la informacion de un objeto usando las funciones get
    	System.out.println("\nNombre: "+animal0.getNombre());
    	System.out.println("Edad: "+animal0.getEdad());
    	System.out.println("Sexo: "+animal0.getSexo());
    	System.out.println("Especie: "+animal0.getEspecie());
    	System.out.println("Color: "+animal0.getColor());
    	System.out.println("Altura: "+animal0.getAltura());
    	
    	//Editar un objeto usando los set
    	animal1.setEdad(10);
    	System.out.println(animal1);
    	
    	
	}
}
