package com.mx.Tarea.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.Tarea.Entity.Tarea;
import com.mx.Tarea.Repository.ITareaRepository;

@Service
public class TareaServiceImp implements ITareaService{
	
	@Autowired
	private ITareaRepository dao;

	@Override
	public void guardar(Tarea tarea) {
		dao.save(tarea);
		
	}

	@Override
	public void editar(Tarea tarea) {
		dao.save(tarea);
		
	}

	@Override
	public void eliminar(int idTarea) {
		dao.deleteById(idTarea);
		
	}

	@Override
	public Tarea buscar(int idTarea) {
		
		return dao.findById(idTarea).orElse(null);
	}

	@Override
	public List<Tarea> listar() {
		
		return dao.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}
	
}
