package com.mx.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mx.entidad.Empresa;
import com.mx.metodos.MetodosEmpresa;

public class EmpresaServicio implements MetodosEmpresa {
    List<Empresa> listaEmpresas = new ArrayList<Empresa>();
    
	@Override
	public void guardar(Empresa empresa) {
	    boolean bandera = false;
		for(Empresa e:listaEmpresas) {
	        if(e.getRfc().equalsIgnoreCase(empresa.getRfc())) {
	            System.out.println("La empresa no se agrego por que el rfc ya existe");	
	            bandera = true;
	            break;
	        }
	        if(e.getNombre().equalsIgnoreCase(empresa.getNombre())) {
	            System.out.println("La empresa no se agrego por que su nombre ya existe");
	            bandera = true;
	            break;
	        }
	    }
		if(bandera != true ) {
		    listaEmpresas.add(empresa);
		    System.out.println("La empresa ha sido registrada exitosamente");
		}
	}

	@Override
	public void editar(Empresa empresa, int indice) {
	    Scanner entrada;
	    int menu;
	    do {
		    System.out.println("\nMenu Editar Empresa");
		    System.out.println("1.-Nombre");
		    System.out.println("2.-Pais");
		    System.out.println("3.-Capital");
		    System.out.println("4.-Rubro");
		    System.out.println("5.-Salir del menu editar");
		    entrada = new Scanner(System.in);
		    menu = entrada.nextInt();
		    switch (menu) {
			case 1:
				System.out.println("Ingresa el nombre nuevo de la empresa");
				entrada = new Scanner(System.in);
				String nombre = entrada.nextLine();
				empresa.setNombre(nombre);
				break;
			case 2:
				System.out.println("Ingresa el pais nuevo");
				entrada = new Scanner(System.in);
				String pais = entrada.nextLine();
				empresa.setPais(pais);
				break;
			case 3:
				System.out.println("Ingresa el capital nuevo");
				entrada = new Scanner(System.in);
				double capital = entrada.nextDouble();
				empresa.setCapital(capital);
				break;
			case 4:
				System.out.println("Ingresa el nuevo rubro");
				entrada = new Scanner(System.in);
				String rubro = entrada.nextLine();
				empresa.setRubro(rubro);
				break;
			case 5:
				System.out.println("Saliendo del menu editar");
				break;
			default:
				System.out.println("Opcion invalida intenta de nuevo");
				break;
			}
		    listaEmpresas.set(indice, empresa);
		} while (menu != 5);
	}

	@Override
	public void eliminar(int indice) {
	    if(listaEmpresas.size() > indice) {
	        Empresa empresa = listaEmpresas.get(indice);
	        listaEmpresas.remove(indice);
	        System.out.println("La siguiente empresa ha sido eliminada\n"+empresa);
	    }else {
	        System.out.println("El indice de la empresa no existe");   
	    }	
	}

	@Override
	public Empresa buscar(int indice) {
		if(listaEmpresas.size() > indice) {
		    Empresa empresa = listaEmpresas.get(indice);
		    return empresa;
		}
		return null;	
	}

	@Override
	public void mostrar() {
		if(listaEmpresas.isEmpty()) {
		    System.out.println("No hay empresas que mostrar");
		}else {
		    System.out.println(listaEmpresas);
		}	
	}
	
	public void listar() {
		if(listaEmpresas.size() == 0) {
		    System.out.println("No hay empresas que listar");	
		}else {
			for(Empresa e: listaEmpresas) {
				System.out.println("["+listaEmpresas.indexOf(e)+"]=>"+e.getRfc()+" "+e.getNombre()+" "+e.getPais());	
			}
		    	
		}
	}
}
