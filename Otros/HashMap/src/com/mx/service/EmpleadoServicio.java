package com.mx.service;

import java.util.HashMap;
import java.util.Scanner;
import com.mx.entidad.Empleado;
import com.mx.metodos.MetodosEmpleado;

public class EmpleadoServicio implements MetodosEmpleado {
	HashMap<String, Empleado> hashEmpleados = new HashMap<String, Empleado>();

	@Override
	public void guardar(Empleado empleado) {
		if (hashEmpleados.containsKey(empleado.getCurp())) {
			System.out.println("El empleado no se agrego por que su curp ya existe");
		} else {
			Empleado empleado_aux;
			int bandera = 0;
			for (String key : hashEmpleados.keySet()) {
				empleado_aux = hashEmpleados.get(key);
				if (empleado_aux.getNombre().equalsIgnoreCase(empleado.getNombre())
						&& empleado_aux.getApellido().equalsIgnoreCase(empleado.getApellido())) {
					System.out.println("El empleado no se agrego por que ya existe");
					bandera = 1;
					break;
				}
			}
			if (bandera == 0) {
				hashEmpleados.put(empleado.getCurp(), empleado);
				System.out.println("El empleado ha sido agregado");
			}
		}
	}

	@Override
	public void editar(Empleado empleado) {
		Scanner entrada;
		int menu;
		do {
			System.out.println("\nMenu editar Empleado");
			System.out.println("1.-Nombre");
			System.out.println("2.-Apellido");
			System.out.println("3.-Edad");
			System.out.println("4.-Ciudad");
			System.out.println("5.-Genero");
			System.out.println("6.-Puesto");
			System.out.println("7.-Sueldo");
			System.out.println("8.-Salir del menu editar");
			entrada = new Scanner(System.in);
			menu = entrada.nextInt();
			switch (menu) {
			case 1:
				System.out.println("Ingresa el nuevo nombre");
				entrada = new Scanner(System.in);
				String nombre = entrada.nextLine();
				empleado.setNombre(nombre);
				break;
			case 2:
				System.out.println("Ingresa el apellido nuevo");
				entrada = new Scanner(System.in);
				String apellido = entrada.nextLine();
				empleado.setApellido(apellido);
				break;
			case 3:
				System.out.println("Ingresa la edad nueva");
				entrada = new Scanner(System.in);
				int edad = entrada.nextInt();
				empleado.setEdad(edad);
				break;
			case 4:
				System.out.println("Ingresa la ciudad nueva");
				entrada = new Scanner(System.in);
				String ciudad = entrada.nextLine();
				empleado.setCiudad(ciudad);
				break;
			case 5:
				System.out.println("Ingresa el genero nuevo");
				entrada = new Scanner(System.in);
				String genero = entrada.nextLine();
				empleado.setGenero(genero);
				break;
			case 6:
				System.out.println("Ingresa el puesto nuevo");
				entrada = new Scanner(System.in);
				String puesto = entrada.nextLine();
				empleado.setPuesto(puesto);
				break;
			case 7:
				System.out.println("Ingresa el sueldo nuevo");
				entrada = new Scanner(System.in);
				double sueldo = entrada.nextDouble();
				empleado.setSueldo(sueldo);
				break;
			case 8:
				System.out.println("Saliendo del menu editar");
				break;
			default:
				System.out.println("Opcion invalida intenta de nuevo");
				break;
			}
			hashEmpleados.put(empleado.getCurp(), empleado);
		} while (menu != 8);
	}

	@Override
	public void eliminar(Empleado empleado) {
	    if(hashEmpleados.containsKey(empleado.getCurp())){
	        empleado = hashEmpleados.get(empleado.getCurp());	
	        hashEmpleados.remove(empleado.getCurp());
	        System.out.println("El empleado ha sido eliminado\n"+empleado);
	    }else {
	        System.out.println("El empleado que tratas de buscar no existe");
	    }
	}

	@Override
	public Empleado buscar(Empleado empleado) {
		if(hashEmpleados.containsKey(empleado.getCurp())) {
		    empleado = hashEmpleados.get(empleado.getCurp());
		    return empleado;
		}
		return null;
	}

	@Override
	public void mostrar() {
		if(hashEmpleados.isEmpty()) {
		    System.out.println("No hay empleados que mostrar");	
		}else {
		    System.out.println(hashEmpleados);
		}
	}
	
	public void listar() {
	    if(hashEmpleados.size() == 0) {
	        System.out.println("No hay empleados que listar");	
	    }else {
	       Empleado empleado;
	       for(String key: hashEmpleados.keySet()) {
	           empleado = hashEmpleados.get(key);
	           System.out.println("["+key+"]=>"+empleado.getNombre()+" "+empleado.getApellido());
	       }
	    }
	}
	

}
