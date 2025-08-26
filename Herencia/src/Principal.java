import java.beans.Encoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
	    //Atributos de la clase padre
    	String nombre;
	    int edad;
	    String sexo;
	    
	    //Atributos de la clase Mascota
	    String especie;
	    String raza;
	    double altura;
	    double peso;
	    
	    //Atributos de la clase persona
	    String apellido;
	    String ciudad;
	    String estadoCivil;
	    
	    List<Persona> listaPersonas = new ArrayList<Persona>();
	    List<Mascota> listaMascotas = new ArrayList<Mascota>();
	    Mascota mascota = new Mascota();
	    Persona persona = new Persona();
	    int indice,menu,menuMascota,menuPersona,submenu;
	    Scanner entrada;
	    
	    do {
		    System.out.println("\nMenú principal");
		    System.out.println("1.-Mascotas");
		    System.out.println("2.-Personas");
		    System.out.println("3.-Salir");
		    entrada = new Scanner(System.in);
		    menu = entrada.nextInt();
		    switch (menu) {
			case 1:
				do {
				    System.out.println("\nMenú mascotas");
				    System.out.println("1.-Alta");
				    System.out.println("2.-Editar");
				    System.out.println("3.-Buscar");
				    System.out.println("4.-Eliminar");
				    System.out.println("5.-Mostrar a todas las mascotas");
				    System.out.println("6.-Listar mascotas por indice");
				    System.out.println("7.-Regresar al menú principal");
				    entrada = new Scanner(System.in);
				    menuMascota = entrada.nextInt();
				    switch (menuMascota) {
					case 1:
						System.out.println("Ingrese el nombre de la mascota");
						entrada = new Scanner(System.in);
						nombre = entrada.nextLine();
						
						System.out.println("Ingresa la especie de la mascota");
						entrada = new Scanner(System.in);
						especie = entrada.nextLine();
						
						System.out.println("Ingresa el sexo de la mascota");
						entrada = new Scanner(System.in);
						sexo = entrada.nextLine();
						
						System.out.println("Ingresa la raza de la mascota");
						entrada = new Scanner(System.in);
						raza = entrada.nextLine();
						
						System.out.println("Ingresa la edad de la mascota");
						entrada = new Scanner(System.in);
						edad = entrada.nextInt();
						
						System.out.println("Ingresa la altura de la mascota");
						entrada = new Scanner(System.in);
						altura = entrada.nextDouble();
						
						System.out.println("Ingresa el peso de la mascota");
						entrada = new Scanner(System.in);
						peso = entrada.nextDouble();
						mascota = new Mascota(nombre, edad, sexo, especie, raza, peso, altura);
						int bandera = 0;
						for(Mascota m:listaMascotas) {
						    if(m.getNombre().equalsIgnoreCase(nombre)) {
						        System.out.println("La mascota no se agrego porque su nombre ya existe");
						        bandera = 1;
						        break;
						    }
						}
						if(bandera == 0) {
						    listaMascotas.add(mascota);
						    System.out.println("La mascota ha sido agregada");
						}
						break;
					case 2:
						System.out.println("Ingresa el índice de la mascota a editar");
						entrada = new Scanner(System.in);
						indice = entrada.nextInt();
						if(indice < listaMascotas.size()) {
							mascota = listaMascotas.get(indice);
							do {
							    System.out.println("\nMenú editar mascota");
							    System.out.println("1.-Nombre");
							    System.out.println("2.-Especie");
							    System.out.println("3.-Raza");
							    System.out.println("4.-Sexo");
							    System.out.println("5.-Altura");
							    System.out.println("6.-Peso");
							    System.out.println("7.-Salir del menú editar");
							    entrada = new Scanner(System.in);
							    submenu = entrada.nextInt();
							    switch (submenu) {
								case 1:
									System.out.println("Ingresa el nombre nuevo");
									entrada = new Scanner(System.in);
									nombre = entrada.nextLine();
									mascota.setNombre(nombre);
									break;
								case 2:
									System.out.println("Ingresa la especie nueva");
									entrada = new Scanner(System.in);
									especie = entrada.nextLine();
									mascota.setEspecie(especie);
									break;
								case 3:
									System.out.println("Ingresa la raza nueva");
									entrada = new Scanner(System.in);
									raza = entrada.nextLine();
									mascota.setRaza(raza);
									break;
								case 4:
									System.out.println("Ingresa el nuevo sexo de la mascota");
									entrada = new Scanner(System.in);
									sexo = entrada.nextLine();
									mascota.setSexo(sexo);
									break;
								case 5:
									System.out.println("Ingresa la altura nueva");
									entrada = new Scanner(System.in);
									altura = entrada.nextDouble();
									mascota.setAltura(altura);
									break;
								case 6:
									System.out.println("Ingresa el peso nuevo");
									entrada = new Scanner(System.in);
									peso = entrada.nextDouble();
									mascota.setPeso(peso);
									break;
								case 7:
									System.out.println("Saliendo del menú editar...");
									break;
								default:
									System.out.println("Opcion invalida intenta mas tarde");
									break;
								}
							    listaMascotas.set(indice, mascota);
							} while (submenu != 7);
						}else {
						    System.out.println("La mascota que tratas de editar no existe");	
						}
						break;
					case 3:
						//Una Excepción es un error que ocurre durante la ejecución de una 
						//aplicación y por lo regular para el programa de manera abrupta
						System.out.println("Ingresa el índice de la mascota a buscar");
						entrada = new Scanner(System.in);
						indice = entrada.nextInt();
						if(indice < listaMascotas.size()) {
						    mascota = listaMascotas.get(indice);
						    System.out.println("La mascota ha sido encontrada\n"+mascota);
						}else {
						    System.out.println("El índice proporcionado no existe");
						}
						break;
					case 4:
						System.out.println("Ingresa el índice de la mascota a eliminar");
						entrada = new Scanner(System.in);
						indice = entrada.nextInt();
						if(indice < listaMascotas.size()) {
						    System.out.println("La mascota ha sido eliminada");
						    listaMascotas.remove(indice);
						}else {
						    System.out.println("La mascota que tratas de eliminar no existe");
						}
						break;
					case 5:
						if(listaMascotas.size() == 0) {
						    System.out.println("No hay ninguna mascota registrada");	
						}else {
						    System.out.println(listaMascotas);
						}
						break;
					case 6:
						if(listaMascotas.isEmpty()) {
						    System.out.println("No hay mascotas que listar");    	
						}else {
						    for(int i = 0; i < listaMascotas.size(); i++) {
						        System.out.println("["+i+"]=>"+listaMascotas.get(i).getNombre()+" "+listaMascotas.get(i).getEspecie());
						    }   
						}
						break;
					case 7:
						System.out.println("Regresando al menú principal...");
						break;
					default:
						System.out.println("Opción inválida intenta de nuevo");
						break;
					}
				} while (menuMascota != 7);
				break;
			case 2:
				do {
				    System.out.println("\nMenú de persona");
				    System.out.println("1.-Alta");
				    System.out.println("2.-Editar");
				    System.out.println("3.-Buscar");
				    System.out.println("4.-Eliminar");
				    System.out.println("5.-Mostrar a todas las personas");
				    System.out.println("6.-Listar personas por índice");
				    System.out.println("7.-Regresar al menú principal");
				    entrada = new Scanner(System.in);
				    menuPersona = entrada.nextInt();
				    switch (menuPersona) {
					case 1:
						System.out.println("Ingresa el nombre de la persona");
						entrada = new Scanner(System.in);
						nombre = entrada.nextLine();
						
						System.out.println("Ingresa el apellido");
						entrada = new Scanner(System.in);
						apellido = entrada.nextLine();
						
						System.out.println("Ingresa la edad de la persona");
						entrada = new Scanner(System.in);
						edad = entrada.nextInt();
						
						System.out.println("Ingresa el sexo de la persona");
						entrada = new Scanner(System.in);
						sexo = entrada.nextLine();
						
						System.out.println("Ingresa la ciudad de residencia");
						entrada = new Scanner(System.in);
						ciudad = entrada.nextLine();
						
						System.out.println("Ingresa el estado civil");
						entrada = new Scanner(System.in);
						estadoCivil = entrada.nextLine();
						persona = new Persona(nombre, edad, sexo, apellido, ciudad, estadoCivil, new ArrayList<Mascota>());
						if(listaPersonas.isEmpty()) {
						    listaPersonas.add(persona);
						    System.out.println("La persona ha sido agregada");
						}else {
							boolean bandera = false;
						    for(Persona p : listaPersonas) {
						        if(p.getNombre().equalsIgnoreCase(persona.getNombre()) && p.getApellido().equalsIgnoreCase(persona.getApellido())) {
						            System.out.println("La persona no se agrego porque ya existe");
						            bandera = true;
						            break;
						        }
						    }
						    if(bandera != true) {
						        listaPersonas.add(persona);
						        System.out.println("La persona ha sido agregada");
						    }
						}
						break;
					case 2:
						break;
					case 3:
						System.out.println("Ingresa el índice de la persona a buscar");
						entrada = new Scanner(System.in);
						indice = entrada.nextInt();
						if(indice < listaPersonas.size()) {
							persona = listaPersonas.get(indice);
							System.out.println("La persona ha sido encontrada\n"+persona);
						}else {
						    System.out.println("La persona que tratas de buscar no existe");
						}
						break;
					case 4:
						System.out.println("Ingresa el índice de la persona a eliminar");
						entrada = new Scanner(System.in);
						indice = entrada.nextInt();
						if(indice < listaPersonas.size()) {
							listaPersonas.remove(indice);
							System.out.println("La persona ha sido eliminada");
						}else {
						    System.out.println("La persona que tratas de eliminar no existe");
						}
						break;
					case 5:
						if(listaPersonas.isEmpty()) {
						    System.out.println("No hay persona que mostrar");
						}else {
						    System.out.println(listaPersonas);
						}
					    break;
					case 6:
						if(listaPersonas.isEmpty()) {
							System.out.println("No hay personas que listar");
						}else {
						    for(int i = 0; i< listaPersonas.size(); i++) {
						        System.out.println("["+i+"]=>"+listaPersonas.get(i).getNombre()+" "+listaPersonas.get(i).getApellido());
						    }
						}
						break;
					case 7:
						break;
					default:
						System.out.println("Opción inválida intenta de nuevo");
						break;
					}
				} while (menuPersona != 7);
				break;
			case 3:
				break;
			default:
				System.out.println("Opción inválida intenta de nuevo");
				break;
			}
		} while (menu != 3);
	    
	}
}
