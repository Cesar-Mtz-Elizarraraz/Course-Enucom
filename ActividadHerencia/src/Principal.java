import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// Atributos CLASE PADRE
		String nombre;
		String apellido;
		int edad;
		String genero;
		
		// Atributos CLASE PACIENTE
		int numeroSeguro;
		String ciudad;
		String padecimiento;
		String alergia;
		String estadoCivil;
		
		// Atributos CLASE MÉDICO
		String especialidad;
		String area;
		List<Paciente> pacientes = new ArrayList<>();
		
		List<Medico> listaMedicos = new ArrayList<Medico>();
	    List<Paciente> listaPacientes = new ArrayList<Paciente>();
	    Medico medico = new Medico();
	    Paciente paciente = new Paciente();
	    int indice, menu, menuMedico, menuPaciente, submenu, submenuPaciente;
	    Scanner entrada;
	    
	    do {
		    System.out.println("\nMenú principal");
		    System.out.println("1.-Médicos");
		    System.out.println("2.-Pacientes");
		    System.out.println("3.-Salir");
		    entrada = new Scanner(System.in);
		    menu = entrada.nextInt();
		    switch (menu) {
			case 1:
				do {
					System.out.println("\nMenú médicos");
				    System.out.println("1.-Alta");
				    System.out.println("2.-Editar");
				    System.out.println("3.-Buscar");
				    System.out.println("4.-Eliminar");
				    System.out.println("5.-Mostrar a todos los médicos");
				    System.out.println("6.-Listar médico por índice");
				    System.out.println("7.-Listar pacientes del médico por índice");
				    System.out.println("8.-Regresar al menú principal");
				    entrada = new Scanner(System.in);
				    menuMedico = entrada.nextInt();
				    switch (menuMedico) {
					case 1:
						System.out.println("Ingrese el nombre del médico");
						entrada = new Scanner(System.in);
						nombre = entrada.nextLine();
						
						System.out.println("Ingrese el apellido del médico");
						entrada = new Scanner(System.in);
						apellido = entrada.nextLine();
						
						System.out.println("Ingrese la edad del médico");
						entrada = new Scanner(System.in);
						edad = entrada.nextInt();
						
						System.out.println("Ingrese el género del médico");
						entrada = new Scanner(System.in);
						genero = entrada.nextLine();
						
						System.out.println("Ingrese la especialidad del médico");
						entrada = new Scanner(System.in);
						especialidad = entrada.nextLine();
						
						System.out.println("Ingrese el área del médico");
						entrada = new Scanner(System.in);
						area = entrada.nextLine();
						
						medico = new Medico(nombre, apellido, edad, genero, especialidad, area, new ArrayList<Paciente>());
						pacientes = new ArrayList<>();
						listaMedicos.add(medico);
						
						break;
					case 2:
						if(listaMedicos.isEmpty()) {
						    System.out.println("No hay médicos para editar");    	
						} else {
							System.out.println("Ingresa el índice del médico a editar");
							entrada = new Scanner(System.in);
							indice = entrada.nextInt();
							if(indice < listaMedicos.size()) {
								medico = listaMedicos.get(indice);
								do {
								    System.out.println("\nMenú editar médico");
								    System.out.println("1.-Nombre");
								    System.out.println("2.-Apellido");
								    System.out.println("3.-Edad");
								    System.out.println("4.-Género");
								    System.out.println("5.-Especialidad");
								    System.out.println("6.-Área");
								    System.out.println("7.-Pacientes");
								    System.out.println("8.-Salir del menú editar");
								    entrada = new Scanner(System.in);
								    submenu = entrada.nextInt();
								    switch (submenu) {
									case 1:
										System.out.println("Ingrese el nuevo nombre del médico");
										entrada = new Scanner(System.in);
										nombre = entrada.nextLine();
										medico.setNombre(nombre);
										break;
									case 2:
										System.out.println("Ingrese el nuevo apellido del médico");
										entrada = new Scanner(System.in);
										apellido = entrada.nextLine();
										medico.setApellido(apellido);
										break;
									case 3:
										System.out.println("Ingrese la nueva edad del médico");
										entrada = new Scanner(System.in);
										edad = entrada.nextInt();
										medico.setEdad(edad);
										break;
									case 4:
										System.out.println("Ingrese el nuevo género del médico");
										entrada = new Scanner(System.in);
										genero = entrada.nextLine();
										medico.setGenero(genero);
										break;
									case 5:
										System.out.println("Ingrese la nueva especialidad del médico");
										entrada = new Scanner(System.in);
										especialidad = entrada.nextLine();
										medico.setEspecialidad(especialidad);
										break;
									case 6:
										System.out.println("Ingrese la nueva área del médico");
										entrada = new Scanner(System.in);
										area = entrada.nextLine();
										medico.setArea(area);
										break;
									case 7:
										if(listaPacientes.isEmpty()) {
										    System.out.println("No hay pacientes por el momento");    	
										} else {
											pacientes = medico.getPacientes();
											do {
												System.out.println("[0] => Salir");
												for(int i = 0; i < listaPacientes.size(); i++) {
											        System.out.println("["+(i + 1)+"] => "+listaPacientes.get(i).getNombre()+" "+listaPacientes.get(i).getApellido());
											    }
											    System.out.println("Ingresa el índice del paciente a asignar");
												entrada = new Scanner(System.in);
												submenuPaciente = entrada.nextInt();
												if(submenuPaciente == 0) {
													System.out.println("Terminando la asignación");
												} else if(submenuPaciente <= listaPacientes.size()) {
												    paciente = listaPacientes.get(submenuPaciente - 1);
												    int bandera = 0;
													for(Paciente p : pacientes) {
													    if(p.getNumeroSeguro() == paciente.getNumeroSeguro()) {
													        System.out.println("El paciente ya fue asignado");
													        bandera = 1;
													        break;
													    }
													}
													if(bandera == 0) {
													    pacientes.add(paciente);
													    System.out.println("El paciente ha sido asignado al médico");
													}
												    
												} else {
												    System.out.println("El índice proporcionado no existe");
												}
											} while(submenuPaciente != 0);
										    
										}
										medico.setPacientes(pacientes);
										break;
									case 8:
										System.out.println("Saliendo del menú editar...");
										break;
									default:
										System.out.println("Opción inválida intenta más tarde");
										break;
									}
								    listaMedicos.set(indice, medico);
								} while (submenu != 8);
							} else {
							    System.out.println("El médico que tratas de editar no existe");	
							}
						}
						break;
					case 3:
						if(listaMedicos.isEmpty()) {
						    System.out.println("No hay médicos para buscar");    	
						} else {
							System.out.println("Ingresa el índice del médico a buscar");
							entrada = new Scanner(System.in);
							indice = entrada.nextInt();
							if(indice < listaMedicos.size()) {
							    medico = listaMedicos.get(indice);
							    System.out.println("El médico ha sido encontrado\n" + medico);
							} else {
							    System.out.println("El índice proporcionado no existe");
							}
						}
						break;
					case 4:
						if(listaMedicos.isEmpty()) {
						    System.out.println("No hay médicos para eliminar");    	
						} else {
							System.out.println("Ingresa el índice del médico a eliminar");
							entrada = new Scanner(System.in);
							indice = entrada.nextInt();
							if(indice < listaMedicos.size()) {
							    System.out.println("El médico ha sido eliminado");
							    listaMedicos.remove(indice);
							} else {
							    System.out.println("El médico que trata de eliminar no existe");
							}
						}
						break;
					case 5:
						if(listaMedicos.isEmpty()) {
						    System.out.println("No hay médicos que listar");    	
						} else {
						    System.out.println(listaMedicos);
						      
						}
						break;
					case 6:
						if(listaMedicos.isEmpty()) {
						    System.out.println("No hay médicos para escoger");    	
						} else {
						    for(int i = 0; i < listaMedicos.size(); i++) {
						        System.out.println("["+i+"] => "+listaMedicos.get(i).getNombre()+" "+listaMedicos.get(i).getApellido());
						    }   
						}
						break;
					case 7:
						if(listaMedicos.isEmpty()) {
						    System.out.println("No hay médicos para escoger");    	
						} else {
							System.out.println("Ingresa el índice del médico para ver sus pacientes");
							entrada = new Scanner(System.in);
							indice = entrada.nextInt();
							if(indice < listaMedicos.size()) {
							    medico = listaMedicos.get(indice);
							    pacientes = medico.getPacientes();
							    if(pacientes.isEmpty()) {
							    	System.out.println("El médico " + medico.getNombre() + " no tiene pacientes asignados");
							    } else {
							    	System.out.println("El médico " + medico.getNombre() + " tiene asignados a los pacientes:\n" + pacientes);
							    }
							    
							} else {
							    System.out.println("El índice proporcionado no existe");
							}  
						}
						break;
					case 8:
						System.out.println("Regresando...");
						break;
					default:
						System.out.println("Opción inválida");
						break;
				    }
			    } while (menuMedico != 8);
				break;
			case 2:
				do {
					System.out.println("\nMenú pacientes");
				    System.out.println("1.-Alta");
				    System.out.println("2.-Editar");
				    System.out.println("3.-Buscar");
				    System.out.println("4.-Eliminar");
				    System.out.println("5.-Mostrar a todos los pacientes");
				    System.out.println("6.-Listar paciente por índice");
				    System.out.println("7.-Regresar al menú principal");
				    entrada = new Scanner(System.in);
				    menuMedico = entrada.nextInt();
				    switch (menuMedico) {
					case 1:
						System.out.println("Ingrese el nombre del paciente");
						entrada = new Scanner(System.in);
						nombre = entrada.nextLine();
						
						System.out.println("Ingrese el apellido del paciente");
						entrada = new Scanner(System.in);
						apellido = entrada.nextLine();
						
						System.out.println("Ingrese la edad del paciente");
						entrada = new Scanner(System.in);
						edad = entrada.nextInt();
						
						System.out.println("Ingrese el género del paciente");
						entrada = new Scanner(System.in);
						genero = entrada.nextLine();
						
						System.out.println("Ingrese el número de seguro del paciente");
						entrada = new Scanner(System.in);
						numeroSeguro = entrada.nextInt();
						
						System.out.println("Ingrese la ciudad del paciente");
						entrada = new Scanner(System.in);
						ciudad = entrada.nextLine();
						
						System.out.println("Ingrese el padecimiento del paciente");
						entrada = new Scanner(System.in);
						padecimiento = entrada.nextLine();
						
						System.out.println("Ingrese la alergía del paciente");
						entrada = new Scanner(System.in);
						alergia = entrada.nextLine();
						
						System.out.println("Ingrese el estado civil del paciente");
						entrada = new Scanner(System.in);
						estadoCivil = entrada.nextLine();
						
						paciente = new Paciente(nombre, apellido, edad, genero, numeroSeguro, ciudad, padecimiento, alergia, estadoCivil);
						
						listaPacientes.add(paciente);
						
						break;
					case 2:
						if(listaPacientes.isEmpty()) {
						    System.out.println("No hay pacientes para editar");    	
						} else {
							System.out.println("Ingresa el índice del paciente a editar");
							entrada = new Scanner(System.in);
							indice = entrada.nextInt();
							if(indice < listaPacientes.size()) {
								paciente = listaPacientes.get(indice);
								do {
								    System.out.println("\nMenú editar paciente");
								    System.out.println("1.-Nombre");
								    System.out.println("2.-Apellido");
								    System.out.println("3.-Edad");
								    System.out.println("4.-Género");
								    System.out.println("5.-Número de seguro");
								    System.out.println("6.-Ciudad");
								    System.out.println("7.-Padecimiento");
								    System.out.println("8.-Alergía");
								    System.out.println("9.-Estado Civil");
								    System.out.println("10.-Salir del menú editar");
								    entrada = new Scanner(System.in);
								    submenu = entrada.nextInt();
								    switch (submenu) {
									case 1:
										System.out.println("Ingrese el nuevo nombre del paciente");
										entrada = new Scanner(System.in);
										nombre = entrada.nextLine();
										paciente.setNombre(nombre);
										break;
									case 2:
										System.out.println("Ingrese el nuevo apellido del paciente");
										entrada = new Scanner(System.in);
										apellido = entrada.nextLine();
										paciente.setApellido(apellido);
										break;
									case 3:
										System.out.println("Ingrese la nueva edad del paciente");
										entrada = new Scanner(System.in);
										edad = entrada.nextInt();
										paciente.setEdad(edad);
										break;
									case 4:
										System.out.println("Ingrese el nuevo género del paciente");
										entrada = new Scanner(System.in);
										genero = entrada.nextLine();
										paciente.setGenero(genero);
										break;
									case 5:
										System.out.println("Ingrese el nuevo número de seguro del paciente");
										entrada = new Scanner(System.in);
										numeroSeguro = entrada.nextInt();
										paciente.setNumeroSeguro(numeroSeguro);
										break;
									case 6:
										System.out.println("Ingrese la nueva ciudad del paciente");
										entrada = new Scanner(System.in);
										ciudad = entrada.nextLine();
										paciente.setCiudad(ciudad);
										break;
									case 7:
										System.out.println("Ingrese el nuevo padecimiento del paciente");
										entrada = new Scanner(System.in);
										padecimiento = entrada.nextLine();
										paciente.setPadecimiento(padecimiento);
										break;
									case 8:
										System.out.println("Ingrese la nueva alergía del paciente");
										entrada = new Scanner(System.in);
										alergia = entrada.nextLine();
										paciente.setAlergia(alergia);
										break;
									case 9:
										System.out.println("Ingrese el nuevo estado civil del paciente");
										entrada = new Scanner(System.in);
										estadoCivil = entrada.nextLine();
										paciente.setEstadoCivil(estadoCivil);
										break;
									case 10:
										System.out.println("Saliendo del menú editar...");
										break;
									default:
										System.out.println("Opcion invalida intenta mas tarde");
										break;
									}
								    listaPacientes.set(indice, paciente);
								} while (submenu != 10);
							} else {
							    System.out.println("El paciente que tratas de editar no existe");	
							}
						}
						break;
					case 3:
						if(listaPacientes.isEmpty()) {
						    System.out.println("No hay pacientes para buscar");    	
						} else {
							System.out.println("Ingresa el índice del paciente a buscar");
							entrada = new Scanner(System.in);
							indice = entrada.nextInt();
							if(indice < listaPacientes.size()) {
							    paciente = listaPacientes.get(indice);
							    System.out.println("El paciente ha sido encontrado\n" + paciente);
							} else {
							    System.out.println("El índice proporcionado no existe");
							}
						}
						break;
					case 4:
						if(listaPacientes.isEmpty()) {
						    System.out.println("No hay pacientes para eliminar");    	
						} else {
							System.out.println("Ingresa el índice del paciente a eliminar");
							entrada = new Scanner(System.in);
							indice = entrada.nextInt();
							if(indice < listaPacientes.size()) {
							    System.out.println("El paciente ha sido eliminado");
							    listaPacientes.remove(indice);
							} else {
							    System.out.println("El paciente que trata de eliminar no existe");
							}
						}
						break;
					case 5:
						if(listaPacientes.isEmpty()) {
						    System.out.println("No hay pacientes que listar");    	
						} else {
						    System.out.println(listaPacientes); 
						}
						break;
					case 6:
						if(listaPacientes.isEmpty()) {
						    System.out.println("No hay pacientes para escoger");    	
						} else {
						    for(int i = 0; i < listaPacientes.size(); i++) {
						        System.out.println("["+i+"] => "+listaPacientes.get(i).getNombre()+" "+listaPacientes.get(i).getApellido());
						    }   
						}
						break;
					case 7:
						System.out.println("Regresando...");
						break;
					default:
						System.out.println("Opción inválida");
						break;
				    }
			    } while (menuMedico != 7);
				break;
			case 3:
				System.out.println("Saliendo del programa...");
				break;
			default:
				System.out.println("Opción inválida");
				break;
		    }
	    } while (menu != 3);
		
	}
	
	private static void menuMedicos() {
		Scanner entrada;
		int menuMedico;
		
	}
	
	private static void menuPacientes() {
		
	}

}
