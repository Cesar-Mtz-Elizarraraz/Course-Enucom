package com.mx.Entidades;

import java.util.List;

import com.mx.Metodos.Entregable;

public class Serie implements Entregable{
	private String titulo;
	private int numeroTemporadas;
	private boolean entregado;
	private String genero;
	private String creador;
	
	public Serie() {
		
	}
	
	public Serie(String titulo, String creador) {
		this.titulo = titulo;
		this.creador = creador;
		this.numeroTemporadas = 3;
		this.entregado = false;
		this.genero = "Sin genero";
		
	}

	public Serie(String titulo, int numeroTemporadas, String genero, String creador) {
		this.titulo = titulo;
		this.numeroTemporadas = numeroTemporadas;
		this.genero = genero;
		this.creador = creador;
		this.entregado = false;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getNumeroTemporadas() {
		return numeroTemporadas;
	}

	public void setNumeroTemporadas(int numeroTemporadas) {
		this.numeroTemporadas = numeroTemporadas;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCreador() {
		return creador;
	}

	public void setCreador(String creador) {
		this.creador = creador;
	}

	@Override
	public String toString() {
		return "Serie [titulo=" + titulo + ", numeroTemporadas=" + numeroTemporadas + ", entregado=" + entregado
				+ ", genero=" + genero + ", creador=" + creador + "]";
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
		Serie[] series = (Serie[]) a;

		if(series.length == 0) {
	        System.out.println("No hay series registradas");	
	    } else {
	    	Serie serieMasTemporadas = null;
	       for(Serie s: series) {
	           if(serieMasTemporadas == null) {
	        	   serieMasTemporadas = s;
	           } else if(s.getNumeroTemporadas() > serieMasTemporadas.getNumeroTemporadas()) {
	        	   serieMasTemporadas = s; 
	           }
	       }
	       
	       System.out.println("La serie con más temporadas es:\n" + serieMasTemporadas + "\n");
	    }
		
	}
	
	
	
	
}
