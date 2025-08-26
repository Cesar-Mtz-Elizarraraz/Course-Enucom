package com.mx.service;

import java.util.ArrayList;
import java.util.List;

import com.mx.entidad.Auto;
import com.mx.metodos.MetodosAuto;

public class AutoServicio implements MetodosAuto {
    List<Auto> autos = new ArrayList<Auto>();
    
	@Override
	public void guardar(Auto auto) {
		int bandera = 0;
		for(Auto a:autos) {
		    if(auto.getModelo().equalsIgnoreCase(a.getModelo()) && auto.getMarca().equalsIgnoreCase(a.getMarca())) {
		        if(auto.getColor().equalsIgnoreCase(a.getColor())) {
		            System.out.println("El auto no se agrego por que ya existe en la lista");	
		            bandera = 1;
		            break;
		        }
		    }
		}
		if(bandera == 0) {
		    autos.add(auto);
		    System.out.println("Se ha agregado el auto a la lista");
		}
	}

	@Override
	public void editar(Auto auto, int indice) {
	    autos.set(indice, auto);			
	}

	@Override
	public void eliminar(int indice) {
	    if(indice < autos.size()) {
	    	Auto auto = autos.get(indice);
	        autos.remove(indice);
	        System.out.println("El siguiente auto ha sido eliminado\n"+auto);
	    } else {
	        System.out.println("El indice para eliminar proporcionado no existe");
	    }  
	}

	@Override
	public Auto buscar(int indice) {
		if(indice < autos.size()) {
		    Auto auto = autos.get(indice);
		    return auto;
		}else {
			return null;	
		}	
	}

	@Override
	public void mostrar() {
		if(autos.size() == 0) {
		    System.out.println("No ahy autos en la lista");
		}else {
		    System.out.println(autos);
		}		
	}
	
	public void listar() {
	    if(autos.isEmpty()) {
	        System.out.println("No hay autos que listar");
	    }else {
	    	for(Auto a: autos) {
	    	    System.out.println("["+autos.indexOf(a)+"]=>"+a.getModelo()+" "+a.getMarca()+" "+a.getColor());	
	    	}
	    }
	}

}
