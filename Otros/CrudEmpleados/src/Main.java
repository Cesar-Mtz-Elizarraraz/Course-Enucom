import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
		int numero;
		String nombre;
		String apellido;
		int edad;
		String genero;
		String puesto;
		String ciudad;
		
		int indice,menu;
		Empleado empleado = new Empleado();
		List<Empleado>listaEmpleados = new ArrayList<Empleado>();
		Scanner entrada;
		
		do {
		    System.out.println("\nMenú principal");
		    System.out.println("1.-Alta");
		    System.out.println("2.-Editar");
		    System.out.println("3.-Buscar");
		    System.out.println("4.-Eliminar");
		    System.out.println("5.-Mostrar todos los empleados");
		    System.out.println("6.-Salir");
		    entrada = new Scanner(System.in);
		    menu = entrada.nextInt();
		    switch (menu) {
			case 1:
				System.out.println("Ingresa el número");
				entrada = new Scanner(System.in);
				numero = entrada.nextInt();
				
				System.out.println("Ingresa la nombre");
				entrada = new Scanner(System.in);
				nombre = entrada.nextLine();
				
				System.out.println("Ingresa el apellido");
				entrada = new Scanner(System.in);
				apellido = entrada.nextLine();
				
				System.out.println("Ingresa la edad");
				entrada = new Scanner(System.in);
				edad = entrada.nextInt();
				
				System.out.println("Ingresa el género");
				entrada = new Scanner(System.in);
				genero = entrada.nextLine();
				
				System.out.println("Ingresa el puesto");
				entrada = new Scanner(System.in);
				puesto = entrada.nextLine();
				
				System.out.println("Ingresa la ciudad");
				entrada = new Scanner(System.in);
				ciudad = entrada.nextLine();
				
				empleado = new Empleado(numero, nombre, apellido, edad, genero, puesto, ciudad);
				listaEmpleados.add(empleado);
				break;
			case 2:
				System.out.println("Ingresa el índice del empleado a editar");
				entrada = new Scanner(System.in);
				indice = entrada.nextInt();
				empleado = listaEmpleados.get(indice);
				
				int eleccion;
				
				do {
					System.out.println("\nMenú de edición");
					System.out.println("1.-Todos sus datos");
				    System.out.println("2.-Datos específicos");
				    System.out.println("0.-Regresar");
				    System.out.println("Ingresa que deseas editar: ");
					entrada = new Scanner(System.in);
					eleccion = entrada.nextInt();
					
					switch(eleccion) {
						case 1: 
							System.out.println("Ingresa el número");
							entrada = new Scanner(System.in);
							numero = entrada.nextInt();
							empleado.setNumero(numero);
							
							System.out.println("Ingresa la nombre");
							entrada = new Scanner(System.in);
							nombre = entrada.nextLine();
							empleado.setNombre(nombre);
							
							System.out.println("Ingresa el apellido");
							entrada = new Scanner(System.in);
							apellido = entrada.nextLine();
							empleado.setApellido(apellido);
							
							System.out.println("Ingresa la edad");
							entrada = new Scanner(System.in);
							edad = entrada.nextInt();
							empleado.setEdad(edad);
							
							System.out.println("Ingresa el género");
							entrada = new Scanner(System.in);
							genero = entrada.nextLine();
							empleado.setGenero(genero);
							
							System.out.println("Ingresa el puesto");
							entrada = new Scanner(System.in);
							puesto = entrada.nextLine();
							empleado.setPuesto(puesto);
							
							System.out.println("Ingresa la ciudad");
							entrada = new Scanner(System.in);
							ciudad = entrada.nextLine();
							empleado.setCiudad(ciudad);
							
							listaEmpleados.set(indice, empleado);
							break;
						case 2:
							editSpecificData(listaEmpleados, empleado, indice);
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
				System.out.println("Ingresa el indice del empleado a buscar");
				entrada = new Scanner(System.in);
				indice = entrada.nextInt();
				empleado = listaEmpleados.get(indice);
				System.out.println("El empleado ha sido encontrado\n" + empleado);
				break;
			case 4:
				System.out.println("Ingresa el indice del empleado a eliminar");
				entrada = new Scanner(System.in);
				indice = entrada.nextInt();
				listaEmpleados.remove(indice);
				break;
			case 5:
				System.out.println(listaEmpleados);
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
    
    private static void editSpecificData(List<Empleado>listaEmpleados, Empleado empleado, int indice) {
    	String[] opciones = {"Número", "Nombre", "Apellido", "Edad", "Género", "Puesto", "Ciudad"};
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
					System.out.println("Ingresa el número");
					entrada = new Scanner(System.in);
					int numero = entrada.nextInt();
					empleado.setNumero(numero);
					break;
				case 2: 
					System.out.println("Ingresa la nombre");
					entrada = new Scanner(System.in);
					String nombre = entrada.nextLine();
					empleado.setNombre(nombre);
					break;
				case 3: 
					System.out.println("Ingresa el apellido");
					entrada = new Scanner(System.in);
					String apellido = entrada.nextLine();
					empleado.setApellido(apellido);
					break;
				case 4: 
					System.out.println("Ingresa la edad");
					entrada = new Scanner(System.in);
					int edad = entrada.nextInt();
					empleado.setEdad(edad);
					break;
				case 5:
					System.out.println("Ingresa el género");
					entrada = new Scanner(System.in);
					String genero = entrada.nextLine();
					empleado.setGenero(genero);
					break;
				case 6:
					System.out.println("Ingresa el puesto");
					entrada = new Scanner(System.in);
					String puesto = entrada.nextLine();
					empleado.setPuesto(puesto);
					break;
				case 7:
					System.out.println("Ingresa la ciudad");
					entrada = new Scanner(System.in);
					String ciudad = entrada.nextLine();
					empleado.setCiudad(ciudad);
					break;
				case 0:
					System.out.println("Saliendo...");
					listaEmpleados.set(indice, empleado);
					break;
				default:
					System.out.println("Opción no válida");
					break;
			}
			if(eleccion > 0 && eleccion < 6) System.out.println("Datos actualizados\n"); 
    	} while (eleccion != 0);
    }
}
