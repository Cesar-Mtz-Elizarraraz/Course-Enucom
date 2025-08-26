package com.mx.entidad;

import java.util.List;

public class Videojuego extends Multimedia{
	int horasEstimadas;
	String compania;
	
	public Videojuego() {
		super();
		this.horasEstimadas = 10;
		this.entregado = false;
	}
	
	public Videojuego(String titulo, int horasEstimadas) {
		super(titulo);
		this.horasEstimadas = horasEstimadas;
		this.entregado = false;
		this.genero = "Sin género";
		this.compania = "Sin compañía";
	}
	
	public Videojuego(String titulo, String genero, int horasEstimadas, String compania) {
		super(titulo, genero);
		this.horasEstimadas = horasEstimadas;
		this.compania = compania;
	}
	
	@Override
	public String toString() {
		return "Videojuego => [Título:" + titulo + ", Género:" + genero + ", Horas estimadas:" + horasEstimadas + 
		", Compañia:" + compania + ", Entregado:" + (entregado ? "Si" : "No") + "]\n";
	}

	public int getHorasEstimadas() {
		return horasEstimadas;
	}

	public void setHorasEstimadas(int horasEstimadas) {
		this.horasEstimadas = horasEstimadas;
	}

	public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}

	@Override
	public void entregar() {
		this.entregado = true;
	}

	@Override
	public void devolver() {
		this.entregado = false;
	}

	@Override
	public boolean isEntregado() {
		return entregado;
	}

	@Override
	public void compareTo(Object obj) {
		List<Videojuego> listaVideojuegos = (List<Videojuego>)obj;

		if(listaVideojuegos.isEmpty()) {
	        System.out.println("No hay videojuegos registrados");	
	    } else {
	    	Videojuego videojuegoMasHoras = null;
	       for(Videojuego v: listaVideojuegos) {
	           if(videojuegoMasHoras == null) {
	        	   videojuegoMasHoras = v;
	           } else if(v.getHorasEstimadas() > videojuegoMasHoras.getHorasEstimadas()) {
	        	   videojuegoMasHoras = v; 
	           }
	       }
	       
	       System.out.println("El videojuego con más horas estimadas es:\n" + videojuegoMasHoras.toString());
	    }
	}
}
