package com.mx.Entidades;

import com.mx.Metodos.IMetodos;

public class SerieDocumental implements IMetodos {
	private String titulo;
	private int numeroEpisodios;
	private boolean disponible;
	private String categoria;
	private String productor;
	
	public SerieDocumental() {
		
	}
	
	public SerieDocumental(String titulo, String categoria) {
		this.titulo = titulo;
		this.categoria = categoria;
		this.numeroEpisodios = 5;
		this.disponible = true;
		this.productor = "Sin productor";
		
	}

	public SerieDocumental(String titulo, int numeroEpisodios, String categoria, String productor) {
		this.titulo = titulo;
		this.numeroEpisodios = numeroEpisodios;
		this.categoria = categoria;
		this.productor = productor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getNumeroEpisodios() {
		return numeroEpisodios;
	}

	public void setNumeroEpisodios(int numeroEpisodios) {
		this.numeroEpisodios = numeroEpisodios;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getProductor() {
		return productor;
	}

	public void setProductor(String productor) {
		this.productor = productor;
	}

	@Override
	public String toString() {
		return "SerieDocumental [titulo=" + titulo + ", numeroEpisodios=" + numeroEpisodios + ", disponible="
				+ disponible + ", categoria=" + categoria + ", productor=" + productor + "]\n";
	}

	@Override
	public void ocupar() {
		this.disponible = false;
		
	}

	@Override
	public void liberar() {
		this.disponible = true;
		
	}

	@Override
	public boolean isDisponible() {
		return disponible;
	}
	
	
}
