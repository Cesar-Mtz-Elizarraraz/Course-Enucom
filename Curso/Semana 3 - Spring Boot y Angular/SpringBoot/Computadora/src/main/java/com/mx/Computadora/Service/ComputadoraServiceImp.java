package com.mx.Computadora.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.Computadora.Dao.IComputadoraDao;
import com.mx.Computadora.Dominio.Computadora;
@Service // Indica que esta clase sera gestionada por el contenedor de beans de Spring y debera ser inyectado en otra clase.
// Indice que esta clase provee un conjunto de funcionalidades que pueden ser utilizadas en otra clase

public class ComputadoraServiceImp implements IComputadoraService {
	@Autowired // Indica la inyeccion de una dependencia para permitir que la aplicación sea escalable(Se inyectará el Dao para poder utilizar el CrudRepository)
	/*
	 * Inyección de dependencias es un patron de diseño del tipo de inversión de control(IoC)
	 * en lugar de que una clase cree sus objetos  de forma indirecta. Spring se encarga de inyectarlos automaticamente
	 * */
	
	private IComputadoraDao dao;
	
	@Override
	public void guardar(Computadora computadora) {
		dao.save(computadora);
		
	}

	@Override
	public void editar(Computadora computadora) {
		dao.save(computadora);
		// NO existe un método especifico que edite o remplace la información
		// pero al guardar la información con un mismo ID, reemplaza la informacion el save
	}

	@Override
	public void eliminar(Computadora computadora) {
		dao.delete(computadora);
		
	}

	@Override
	public Computadora buscar(Computadora computadora) {
		
		return dao.findById(computadora.getIdCompu()).orElse(null);
	}

	@Override
	public List<Computadora> listar() {

		return (List<Computadora>) dao.findAll();
	}

}
