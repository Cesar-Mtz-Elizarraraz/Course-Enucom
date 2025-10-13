package com.mx.Empleado.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.Empleado.Entity.Empleado;
import com.mx.Empleado.Repository.IEmpleadoDao;

@Service
public class EmpleadoServiceImp implements IEmpleadoService{
	@Autowired
	private IEmpleadoDao dao;
	
	@Override
	public void guardar(Empleado empleado) {
		dao.save(empleado);
		
	}

	@Override
	public void editar(Empleado empleado) {
		dao.save(empleado);
		
	}

	@Override
	public void eliminar(int idEmpleado) {
		dao.deleteById(idEmpleado);
		
	}

	@Override
	public Empleado buscar(int idEmpleado) {
		
		return dao.findById(idEmpleado).orElse(null);
	}

	@Override
	public List<Empleado> listar() {
		
		return dao.findAll(Sort.by(Sort.Direction.ASC, "idEmpleado"));
	}
	
	public boolean existeEmpleado(String nombre, String apellido) {
		return dao.existsByNombreAndApellidoIgnoreCase(nombre, apellido);
	}
	
	public boolean existeTelefono(Long telefono) {
		return dao.existsByTelefono(telefono);
	}
	
	
}
