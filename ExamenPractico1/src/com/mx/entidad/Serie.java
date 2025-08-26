package com.mx.entidad;

import java.util.List;

public class Serie extends Multimedia  {
	int numeroTemporadas;
	String creador;
	
	public Serie() {
		super();
		this.numeroTemporadas = 3;
		this.entregado = false;
	}
	
	public Serie(String titulo, String creador) {
		super(titulo);
		this.creador = creador;
		this.numeroTemporadas = 3;
		this.entregado = false;
		this.genero = "Sin género";
	}

	public Serie(String titulo, String genero, int numeroTemporadas, String creador) {
		super(titulo, genero);
		this.numeroTemporadas = numeroTemporadas;
		this.creador = creador;
	}
	
	@Override
	public String toString() {
		return "Serie => [Título:" + titulo + ", Género:" + genero + ", Número de temporadas:" + numeroTemporadas + 
		", Creador:" + creador + ", Entregado:" + (entregado ? "Si" : "No") + "]\n";
	}

	public int getNumeroTemporadas() {
		return numeroTemporadas;
	}

	public void setNumeroTemporadas(int numeroTemporadas) {
		this.numeroTemporadas = numeroTemporadas;
	}

	public String getCreador() {
		return creador;
	}

	public void setCreador(String creador) {
		this.creador = creador;
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
		List<Serie> listaSeries = (List<Serie>) obj;

		if(listaSeries.isEmpty()) {
	        System.out.println("No hay series registradas");	
	    } else {
	    	Serie serieMasTemporadas = null;
	       for(Serie s: listaSeries) {
	           if(serieMasTemporadas == null) {
	        	   serieMasTemporadas = s;
	           } else if(s.getNumeroTemporadas() > serieMasTemporadas.getNumeroTemporadas()) {
	        	   serieMasTemporadas = s; 
	           }
	       }
	       
	       System.out.println("La serie con más temporadas es:\n" + serieMasTemporadas.toString());
	    }

	}
	
	
	
}
