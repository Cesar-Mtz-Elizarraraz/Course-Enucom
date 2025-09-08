package com.mx.Entidades;

import java.util.List;

import com.mx.Metodos.Entregable;

public class Videojuego implements Entregable{
	private String titulo;
	private int horasEstimadas;
	private boolean entregado;
	private String genero;
	private String compania;
	
	public Videojuego() {
		
	}
	
	public Videojuego(String titulo, int horasEstimadas) {
		this.titulo = titulo;
		this.horasEstimadas = horasEstimadas;
		this.genero = "Sin género";
		this.compania = "Sin compañia";
		this.entregado = false;
	}

	public Videojuego(String titulo, int horasEstimadas, String genero, String compania) {
		this.titulo = titulo;
		this.horasEstimadas = horasEstimadas;
		this.genero = genero;
		this.compania = compania;
		this.entregado = false;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getHorasEstimadas() {
		return horasEstimadas;
	}

	public void setHorasEstimadas(int horasEstimadas) {
		this.horasEstimadas = horasEstimadas;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}

	@Override
	public String toString() {
		return "Videojuego [titulo=" + titulo + ", horasEstimadas=" + horasEstimadas + ", entregado=" + entregado
				+ ", genero=" + genero + ", compania=" + compania + "]";
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
	public void compareTo(Object a) {
		Videojuego[] videojuegos = (Videojuego[]) a;

		if(videojuegos.length == 0) {
	        System.out.println("No hay videojuegos registrados");	
	    } else {
	    	Videojuego videojuegoMasHoras = null;
	       for(Videojuego v: videojuegos) {
	           if(videojuegoMasHoras == null) {
	        	   videojuegoMasHoras = v;
	           } else if(v.getHorasEstimadas() > videojuegoMasHoras.getHorasEstimadas()) {
	        	   videojuegoMasHoras = v; 
	           }
	       }
	       
	       System.out.println("El videojuego con más horas estimadas es:\n" + videojuegoMasHoras + "\n");
	    }
		
	}
	
	
}
