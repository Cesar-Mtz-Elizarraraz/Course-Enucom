package com.mx.service;

import java.util.ArrayList;
import java.util.List;

import com.mx.entidad.Persona;
import com.mx.metodos.MetodosPersona;

public class PersonaService implements MetodosPersona {
    List<Persona>personas = new ArrayList<Persona>();
	@Override
	public void guardar(Persona persona) {
	    int bandera = 0;
		for(Persona p:personas) {
	        if(persona.getNombre().equalsIgnoreCase(p.getNombre()) && 
	           persona.getApellido().equalsIgnoreCase(p.getApellido())) {
	            System.out.println("La persona no se agrego por que ya existe");
	            bandera = 1;
	            break;
	        }
	    }
		if(bandera == 0) {
		    personas.add(persona);
		    System.out.println("Se agrego la persona a la lista");
		}
	}

	@Override
	public void editar(Persona persona, int indice) {
		personas.set(indice, persona);
		
	}

	@Override
	public void eliminar(int indice) {
        if(indice < personas.size()) {
            personas.remove(indice);
            System.out.println("La persona ha sido eliminada");
        }else {
            System.out.println("No existe el indice que tratas de eliminar");
        }
	}

	@Override
	public Persona buscar(int indice) {
		if(indice < personas.size()) {
		    Persona persona = personas.get(indice);
		    return persona;
		}else {
		    return null;	
		}
	}

	@Override
	public void mostrar() {
		if(personas.isEmpty()) {
		    System.out.println("No hay personas en la lista");
		}else {
		    System.out.println(personas);
		}
		
	}

}
