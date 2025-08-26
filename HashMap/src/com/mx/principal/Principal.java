package com.mx.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.mx.entidad.Empleado;
import com.mx.entidad.Empresa;
import com.mx.service.EmpleadoServicio;
import com.mx.service.EmpresaServicio;

public class Principal {
    public static void main(String[] args) {
	    String rfc,curp,nombre,apellido,ciudad,genero,puesto,pais,rubro;
	    int edad;
	    double capital,sueldo;
	    
	    EmpresaServicio empresaServicio = new EmpresaServicio();
	    EmpleadoServicio empleadoServicio = new EmpleadoServicio();
	    Empresa empresa = new Empresa();
	    Empleado empleado = new Empleado();
	    int indice,menu,menuEmpleado,menuEmpresa;
	    Scanner entrada;
	    
	    do {
		    System.out.println("\nMenu principal");
		    System.out.println("1.-Empresas");
		    System.out.println("2.-Empleados");
		    System.out.println("3.-Salir");
		    try {
			    entrada = new Scanner(System.in);
			    menu = entrada.nextInt();
			    switch (menu) {
				case 1:
					do {
						System.out.println("\nMenu empresas");
						System.out.println("1.-Alta");
						System.out.println("2.-Editar");
						System.out.println("3.-Buscar");
						System.out.println("4.-Eliminar");
						System.out.println("5.-Mostrar todas las empresas");
						System.out.println("6.-Listar por indice");
						System.out.println("7.-Regresar al menu principal");
						entrada = new Scanner(System.in);
						menuEmpresa = entrada.nextInt();
						switch (menuEmpresa) {
						case 1:
							System.out.println("Ingresa el rfc de la empresa");
							entrada = new Scanner(System.in);
							rfc = entrada.nextLine();
							
							System.out.println("Ingresa el nombre de la empresa");
							entrada = new Scanner(System.in);
							nombre = entrada.nextLine();
							
							System.out.println("Ingresa el nombre del pais");
							entrada = new Scanner(System.in);
							pais = entrada.nextLine();
							
							System.out.println("Ingresa el capital");
							entrada = new Scanner(System.in);
							capital = entrada.nextDouble();
							
							System.out.println("Ingresa el rubro");
							entrada = new Scanner(System.in);
							rubro = entrada.nextLine();
							empresa = new Empresa(rfc, nombre, pais, capital, rubro, new ArrayList<Empleado>());
							empleadoServicio.guardar(empleado);
							break;
						case 2:
							System.out.println("Ingrese el indice de la empresa a editar");
							entrada = new Scanner(System.in);
							indice = entrada.nextInt();
							empresa = empresaServicio.buscar(indice);
							if(empresa == null) {
							    System.out.println("La empresa que tratas de editar no existe");
							}else {
							    empresaServicio.editar(empresa, indice);
							}
							break;
						case 3:
							System.out.println("Ingresa el indice de la empresa a buscar");
							entrada = new Scanner(System.in);
							indice = entrada.nextInt();
							empresa = empresaServicio.buscar(indice);
							if(empresa != null) {
							    System.out.println("La empresa ha sido encontrada\n"+empresa);
							}else {
							    System.out.println("La empresa que tratas de buscar no existe");
							}
							break;
						case 4:
							System.out.println("Ingresa el indice de la empresa a eliminar");
							entrada = new Scanner(System.in);
							indice = entrada.nextInt();
							empresaServicio.eliminar(indice);
							break;
						case 5:
							empresaServicio.mostrar();
							break;
						case 6:
							empresaServicio.listar();
							break;
						case 7:
							System.out.println("Regresando al menu principal");
							break;
						default:
							System.out.println("Opcion invalida intenta de nuevo");
							break;
						}
					} while (menuEmpresa != 7);
					break;
				case 2:
					do {
						System.out.println("\nMenu Empleados");
						System.out.println("1.-Alta");
						System.out.println("2.-Editar");
						System.out.println("3.-Buscar");
						System.out.println("4.-Eliminar");
						System.out.println("5.-Mostrar a todos lo empleados");
						System.out.println("6.-Listar a los empleados");
						System.out.println("7.-Salir");
						entrada = new Scanner(System.in);
						menuEmpleado = entrada.nextInt();
						switch (menuEmpleado) {
						case 1:
							System.out.println("Ingresa el curp");
							entrada = new Scanner(System.in);
							curp = entrada.nextLine();
							
							System.out.println("Ingresa el nombre del empleado");
							entrada = new Scanner(System.in);
							nombre = entrada.nextLine();
							
							System.out.println("Ingresa el apellido");
							entrada = new Scanner(System.in);
							apellido = entrada.nextLine();
							
							System.out.println("Ingresa la edad");
							entrada = new Scanner(System.in);
							edad = entrada.nextInt();
							
							System.out.println("Ingresa la ciudad");
							entrada = new Scanner(System.in);
							ciudad = entrada.nextLine();
							
							System.out.println("Ingresa el genero");
							entrada = new Scanner(System.in);
							genero = entrada.nextLine();
							
							System.out.println("Ingresa el pueso");
							entrada = new Scanner(System.in);
							puesto = entrada.nextLine();
							
							System.out.println("Ingresa el sueldo");
							entrada = new Scanner(System.in);
							sueldo = entrada.nextDouble();
							empleado = new Empleado(curp, nombre, apellido, edad, ciudad, genero, puesto, sueldo);
							empleadoServicio.guardar(empleado);
							break;
						case 2:
							System.out.println("Ingresa el curp de la empleado a editar");
							entrada = new Scanner(System.in);
							curp = entrada.nextLine();
							empleado = new Empleado(curp,null,null,0,null,null,null,0);
							empleado = empleadoServicio.buscar(empleado);
							if(empleado == null) {
							    System.out.println("El empleado que tratas de editar no existe");
							}else {
							    empleadoServicio.editar(empleado);
							}
							break;
						case 3:
							System.out.println("Ingresa el curp del empleado a buscar");
							entrada = new Scanner(System.in);
							curp = entrada.nextLine();
							empleado.setCurp(curp);
							empleado = empleadoServicio.buscar(empleado);
							if(empleado == null) {
							    System.out.println("El empleado no existe");
							}else {
							    System.out.println("El empleado ha sido encontrado\n"+empleado);
							}
							break;
						case 4:
							System.out.println("Ingrese el curp de la persona a eliminar");
							entrada = new Scanner(System.in);
							curp = entrada.nextLine();
							empleado = new Empleado(curp);
							empleadoServicio.eliminar(empleado);
							break;
						case 5:
							empleadoServicio.mostrar();
							break;
						case 6:
							empleadoServicio.listar();
							break;
						case 7:
							System.out.println("Regresando al menu principal");
							break;
						default:
							System.out.println("Opcion invalida intenta de nuevo");
							break;
						}
					} while (menuEmpleado != 7);
					break;
				case 3:
					System.out.println("Saliendo del programa");
					break;
				default:
					System.out.println("Opcion invalida intenta de nuevo");
					break;
				}
			} catch (Exception e) {
				menu = 4;
				for(StackTraceElement s: e.getStackTrace()) {
				    System.out.println("Clase:"+s.getClassName());	
				    System.out.println("Metodo: "+s.getMethodName());
				    System.out.println("Linea: "+s.getLineNumber());
				}
			}
		} while (menu != 3);
	}
}
