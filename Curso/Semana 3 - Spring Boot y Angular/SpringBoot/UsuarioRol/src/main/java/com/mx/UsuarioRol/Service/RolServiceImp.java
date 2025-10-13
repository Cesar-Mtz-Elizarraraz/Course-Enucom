package com.mx.UsuarioRol.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.UsuarioRol.Dao.IRolDao;
import com.mx.UsuarioRol.Dominio.Rol;

@Service
public class RolServiceImp implements IRolService {

	@Autowired
	private IRolDao dao;
	
	@Override
	public void guardar(Rol rol) {
		dao.save(rol);
		
	}

	@Override
	public void editar(Rol rol) {
		dao.save(rol);
		
	}

	@Override
	public void eliminar(int idRol) {
		dao.deleteById(idRol);
		
	}

	@Override
	public Rol buscar(int idRol) {
		
		return dao.findById(idRol).orElse(null);
	}

	@Override
	public List<Rol> listar() {
		
		return (List<Rol>) dao.findAll(Sort.by(Sort.Direction.ASC, "idRol"));
	}
	
	// MÉTODO PERSONALIZADO
	public Rol buscarPorPrivilegio(String correo) {
		return dao.findByPrivilegio(correo).orElse(null);
	}

}
