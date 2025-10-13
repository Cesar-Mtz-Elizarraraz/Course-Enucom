package com.mx.UsuarioRol.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.UsuarioRol.Dao.IUsuarioDao;
import com.mx.UsuarioRol.Dominio.Usuario;

@Service
public class UsuarioServiceImp implements IUsuarioService {

	@Autowired
	private IUsuarioDao dao;
	
	@Override
	public void guardar(Usuario usuario) {
		dao.save(usuario);
		
	}

	@Override
	public void editar(Usuario usuario) {
		dao.save(usuario);
		
	}

	@Override
	public void eliminar(int idUsuario) {
		dao.deleteById(idUsuario);
		
	}

	@Override
	public Usuario buscar(int idUsuario) {
	
		return dao.findById(idUsuario).orElse(null);
	}

	@Override
	public List<Usuario> listar() {
		
		return (List<Usuario>) dao.findAll(Sort.by(Sort.Direction.ASC, "idUsuario"));
	}
	
	// MÉTODO PERSONALIZADO
	public Usuario buscarPorCorreo(String correo) {
		return dao.findByCorreo(correo).orElse(null);
	}

}
