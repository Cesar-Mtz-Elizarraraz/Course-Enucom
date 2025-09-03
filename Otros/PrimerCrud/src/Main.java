import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
		String modelo;
		String marca;
		int ram;
		int almacenamiento;
		String color;
		
		int indice,menu;
		Celular celular = new Celular();
		List<Celular>listaCelulares = new ArrayList<Celular>();
		Scanner entrada;
		
		do {
		    System.out.println("\nMenu principal");
		    System.out.println("1.-Alta");
		    System.out.println("2.-Editar");
		    System.out.println("3.-Buscar");
		    System.out.println("4.-Eliminar");
		    System.out.println("5.-Mostrar todos los celulares");
		    System.out.println("6.-Salir");
		    entrada = new Scanner(System.in);
		    menu = entrada.nextInt();
		    switch (menu) {
			case 1:
				System.out.println("Ingresa el modelo");
				entrada = new Scanner(System.in);
				modelo = entrada.nextLine();
				
				System.out.println("Ingresa la marca");
				entrada = new Scanner(System.in);
				marca = entrada.nextLine();
				
				System.out.println("Ingresa la ram");
				entrada = new Scanner(System.in);
				ram = entrada.nextInt();
				
				System.out.println("Ingresa el almacenamiento");
				entrada = new Scanner(System.in);
				almacenamiento = entrada.nextInt();
				
				System.out.println("Ingresa el color");
				entrada = new Scanner( System.in);
				color = entrada.nextLine();
				celular = new Celular(marca, modelo, ram, almacenamiento, color);
				listaCelulares.add(celular);
				break;
			case 2:
				System.out.println("Ingresa el indice del celular a editar");
				entrada = new Scanner(System.in);
				indice = entrada.nextInt();
				celular = listaCelulares.get(indice);
				
				int eleccion;
				
				do {
					
					System.out.println("\n1.-Todos sus datos");
				    System.out.println("2.-Datos específicos");
				    System.out.println("0.-Regresar");
				    System.out.println("Ingresa que deseas editar: ");
					entrada = new Scanner(System.in);
					eleccion = entrada.nextInt();
					
					switch(eleccion) {
						case 1: 
							System.out.println("Ingresa el modelo nuevo");
							entrada = new Scanner(System.in);
							modelo = entrada.nextLine();
							celular.setModelo(modelo);
							
							System.out.println("Ingresa la marca nueva");
							entrada = new Scanner(System.in);
							marca = entrada.nextLine();
							celular.setMarca(marca);
							
							System.out.println("Ingresa la ram nueva");
							entrada = new Scanner(System.in);
							ram = entrada.nextInt();
							celular.setRam(ram);
							
							System.out.println("Ingresa el almacenamiento nuevo");
							entrada = new Scanner(System.in);
							almacenamiento = entrada.nextInt();
							celular.setAlmacenamiento(almacenamiento);
							
							System.out.println("Ingresa el color nuevo");
							entrada = new Scanner(System.in);
							color = entrada.nextLine();
							celular.setColor(color);
							listaCelulares.set(indice, celular);
							break;
						case 2:
							editSpecificData(listaCelulares, celular, indice);
							break;
						case 0:
							System.out.println("Regresando...");
							break;
						default: 
							System.out.println("Opción no válida");
							break;
					}
				} while (eleccion != 0);

				break;
			case 3:
				System.out.println("Ingresa el indice del celular a buscar");
				entrada = new Scanner(System.in);
				indice = entrada.nextInt();
				celular = listaCelulares.get(indice);
				System.out.println("El celular ha sido encontrado\n"+celular);
				break;
			case 4:
				System.out.println("Ingresa el indice del celular a eliminar");
				entrada = new Scanner(System.in);
				indice = entrada.nextInt();
				listaCelulares.remove(indice);
				break;
			case 5:
				System.out.println(listaCelulares);
				break;
			case 6:
				System.out.println("Saliendo del programa");
				break;
			default:
				System.out.println("Opcion invalida intenta de nuevo");
				break;
			}
		} while (menu != 6);
	}
    
    private static void editSpecificData(List<Celular>listaCelulares, Celular celular, int indice) {
    	String[] opciones = {"Modelo", "Marca", "Ram", "Almacenamiento", "Color"};
		Scanner entrada;
		int eleccion;
		
		do {
			System.out.println("0.- Salir");
			for(int i = 0; i < opciones.length; i++){
				System.out.println((i + 1) + ".- " + opciones[i]);
			}
			System.out.println("Ingresa que deseas editar: ");
			entrada = new Scanner(System.in);
			eleccion = entrada.nextInt();
			
			switch(eleccion) {
				case 1:  
					System.out.println("Ingresa el modelo nuevo");
					entrada = new Scanner(System.in);
					String modelo = entrada.nextLine();
					celular.setModelo(modelo);
					break;
				case 2: 
					System.out.println("Ingresa la marca nueva");
					entrada = new Scanner(System.in);
					String marca = entrada.nextLine();
					celular.setMarca(marca);
					break;
				case 3: 
					System.out.println("Ingresa la ram nueva");
					entrada = new Scanner(System.in);
					int ram = entrada.nextInt();
					celular.setRam(ram);
					break;
				case 4: 
					System.out.println("Ingresa el almacenamiento nuevo");
					entrada = new Scanner(System.in);
					int almacenamiento = entrada.nextInt();
					celular.setAlmacenamiento(almacenamiento);
					break;
				case 5:
					System.out.println("Ingresa el color nuevo");
					entrada = new Scanner(System.in);
					String color = entrada.nextLine();
					celular.setColor(color);
					break;
				case 0:
					System.out.println("Saliendo...");
					listaCelulares.set(indice, celular);
					break;
				default:
					System.out.println("Opción no válida");
					break;
			}
			if(eleccion > 0 && eleccion < 6) System.out.println("Datos actualizados\n"); 
    	} while (eleccion != 0);
    }
}
