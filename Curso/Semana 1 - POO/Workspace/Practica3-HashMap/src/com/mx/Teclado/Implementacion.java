package com.mx.Teclado;

import java.util.HashMap;

public class Implementacion implements IMetodos {
	
	HashMap<Long, Teclado> hashTeclados = new HashMap<Long, Teclado>();

	@Override
	public void guardar(Teclado teclado) {
		hashTeclados.put(teclado.getCodigoBarras(), teclado);
		
	}

	@Override
	public Teclado buscar(Teclado teclado) {

		return hashTeclados.get(teclado.getCodigoBarras());
	}

	@Override
	public void editar(Teclado teclado) {
		hashTeclados.replace(teclado.getCodigoBarras(), teclado);
		
	}

	@Override
	public void eliminar(Teclado teclado) {
		hashTeclados.remove(teclado.getCodigoBarras());
		
	}

	@Override
	public void mostrar() {
		System.out.println(hashTeclados);
		
	}
	
	// MÉTODO PERSONALIZADO
	public void contar() {
		System.out.println("El hash contiene " + hashTeclados.size() + " teclados registrados");
	}

}
