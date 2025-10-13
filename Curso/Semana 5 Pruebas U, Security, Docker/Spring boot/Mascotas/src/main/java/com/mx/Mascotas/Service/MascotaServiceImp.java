package com.mx.Mascotas.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.Mascotas.DTOs.*;
import com.mx.Mascotas.Entity.Mascota;
import com.mx.Mascotas.FeignClient.ClienteFeignClient;
import com.mx.Mascotas.FeignClient.ResponsableFeignClient;
import com.mx.Mascotas.FeignClient.VeterinariaFeignClient;
import com.mx.Mascotas.Repository.IMascotaRepository;

@Service
public class MascotaServiceImp implements IMascotaService{
	@Autowired
	private IMascotaRepository dao;
	
	@Override
	public List<Mascota> listar() {

		return dao.findAll(Sort.by(Sort.Direction.ASC, "idMascota"));
	}

	@Override
	public void guardar(Mascota mascota) {
		dao.save(mascota);
		
	}

	@Override
	public void editar(Mascota mascota) {
		dao.save(mascota);
		
	}

	@Override
	public Mascota buscar(Integer idMascota) {
		
		return dao.findById(idMascota).orElse(null);
	}

	@Override
	public void eliminar(Integer idMascota) {
		dao.deleteById(idMascota);
		
	}
	
	@Autowired
	private ClienteFeignClient clienteFC;
	
	@Autowired
	private ResponsableFeignClient responsableFC;
	
	@Autowired
	private VeterinariaFeignClient veterinariaFC;
	
	public List<MascotaCliRespVetDTO> obtenerMascotasConCliRespVet(){
		List<MascotaCliRespVetDTO> mascotasDTO = new ArrayList<MascotaCliRespVetDTO>();
		List<Mascota> mascotas = dao.findAll();
		
		if(mascotas.isEmpty()) return mascotasDTO;
		
		List<ClienteDTO> clientes = clienteFC.listar();
		List<ResponsableDTO> responsables = responsableFC.listar();
		List<VeterinariaDTO> veterinarias = veterinariaFC.listar();
		
		HashMap<Integer, ClienteDTO> hashClientes = (HashMap<Integer, ClienteDTO>) clientes.stream()
		    .collect(Collectors.toMap(ClienteDTO::getIdCliente, Function.identity()));
		HashMap<Integer, ResponsableDTO> hashResponsables = (HashMap<Integer, ResponsableDTO>) responsables.stream()
			    .collect(Collectors.toMap(ResponsableDTO::getIdResponsable, Function.identity()));
		HashMap<Integer, VeterinariaDTO> hashVeterinarias = (HashMap<Integer, VeterinariaDTO>) veterinarias.stream()
			    .collect(Collectors.toMap(VeterinariaDTO::getIdVeterinaria, Function.identity()));
		
		for(Mascota m : mascotas) {
			MascotaCliRespVetDTO dto = new MascotaCliRespVetDTO(
				m.getIdMascota(),
				m.getNombre(),
				m.getRaza(),
				m.getEdad(),
				m.getRazonCita(),
				hashClientes.get(m.getClienteId()),
				hashResponsables.get(m.getResponsableId()),
				hashVeterinarias.get(m.getVeterinariaId())
			);
			mascotasDTO.add(dto);
		}
		
		return mascotasDTO;
	}

}
