package com.mx.Responsables.Service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mx.Responsables.DTOs.ResponsableVeterinariaDTO;
import com.mx.Responsables.DTOs.VeterinariaDTO;
import com.mx.Responsables.Entity.Responsable;
import com.mx.Responsables.Repository.IResponsableRepository;

@Service
public class ResponsableServiceImp implements IResponsableService{
	@Autowired
	private IResponsableRepository dao;
	
	@Override
	public List<Responsable> listar() {
		
		return dao.findAll(Sort.by(Sort.Direction.ASC, "idResponsable"));
	}

	@Override
	public void guardar(Responsable responsable) {
		dao.save(responsable);
		
	}

	@Override
	public void editar(Responsable responsable) {
		dao.save(responsable);
		
	}

	@Override
	public Responsable buscar(Integer idResponsable) {

		return dao.findById(idResponsable).orElse(null);
	}

	@Override
	public void eliminar(Integer idResponsable) {
		dao.deleteById(idResponsable);
		
	}
	
	public boolean contactoExistente(Long contacto) {
		return dao.existsByContacto(contacto);
	}
	
	public boolean contactoExistenteEditar(Long contacto, Integer idResponsable) {
		return dao.existsByContactoAndIdResponsableNot(contacto, idResponsable);
	}
	
	@Autowired
	private RestTemplate restTemplate;
	
	public List<ResponsableVeterinariaDTO> obtenerResponsablesConVeterinaria() {
		List<ResponsableVeterinariaDTO> responsablesDTO = new ArrayList<ResponsableVeterinariaDTO>();
		List<Responsable> responsables = dao.findAll();
		
		if(responsables.isEmpty()) return responsablesDTO;
		
		// Microservicio de listar veterinaria
		VeterinariaDTO[] veterinariaArray = restTemplate.getForObject("http://localhost:8013/veterinaria", VeterinariaDTO[].class);
		HashMap<Integer, VeterinariaDTO> hashVeterinarias = new HashMap<Integer, VeterinariaDTO>();
		
		for (VeterinariaDTO v : veterinariaArray) {
		    hashVeterinarias.put(v.getIdVeterinaria(), v);
		}
		
		for (Responsable r : responsables) {
			ResponsableVeterinariaDTO rvDTO = new ResponsableVeterinariaDTO();
			rvDTO.setIdResponsable(r.getIdResponsable());
			rvDTO.setNombre(r.getNombre());
			rvDTO.setContacto(r.getContacto());
			rvDTO.setVeterinaria(hashVeterinarias.get(r.getVeterinariaId()));
			
			responsablesDTO.add(rvDTO);
		}
		
		return responsablesDTO;
	}

}
