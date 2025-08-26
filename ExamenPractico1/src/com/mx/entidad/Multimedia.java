package com.mx.entidad;

import com.mx.metodos.Entregable;

public abstract class Multimedia implements Entregable {
	String titulo;
	boolean entregado;
	String genero;
	
	public Multimedia() {
	}
	
	public Multimedia(String titulo) {
		this.titulo = titulo;
	}
	
	public Multimedia(String titulo, String genero) {
		this.titulo = titulo;
		this.genero = genero;
	}
	
	public Multimedia(String titulo, boolean entregado, String genero) {
		this.titulo = titulo;
		this.entregado = entregado;
		this.genero = genero;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/*public boolean isEntregado() {
		return entregado;
	}

	public void setEntregado(boolean entregado) {
		this.entregado = entregado;
	}*/

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	
}
