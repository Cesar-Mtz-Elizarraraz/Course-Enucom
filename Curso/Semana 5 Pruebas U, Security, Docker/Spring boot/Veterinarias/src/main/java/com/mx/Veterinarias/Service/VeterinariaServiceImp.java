package com.mx.Veterinarias.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.Veterinarias.Entity.Veterinaria;
import com.mx.Veterinarias.Repository.IVeterinariaRepository;

@Service
public class VeterinariaServiceImp implements IVeterinariaService {
	@Autowired
	private IVeterinariaRepository dao;
	
	@Override
	public List<Veterinaria> listar() {
		
		return dao.findAll(Sort.by(Sort.Direction.ASC, "idVeterinaria"));
	}

	@Override
	public void guardar(Veterinaria veterinaria) {
		dao.save(veterinaria);
		
	}

	@Override
	public void editar(Veterinaria veterinaria) {
		dao.save(veterinaria);
		
	}

	@Override
	public Veterinaria buscar(Integer idVeterinaria) {

		return dao.findById(idVeterinaria).orElse(null);
	}

	@Override
	public void eliminar(Integer idVeterinaria) {
		dao.deleteById(idVeterinaria);
		
	}
	
	public boolean telefonoExistente(Long telefono) {
		return dao.existsByTelefono(telefono);
	}
	
	public boolean telefonoExistenteEditar(Long telefono, Integer idVeterinaria) {
		return dao.existsByTelefonoAndIdVeterinariaNot(telefono, idVeterinaria);
	}
}
