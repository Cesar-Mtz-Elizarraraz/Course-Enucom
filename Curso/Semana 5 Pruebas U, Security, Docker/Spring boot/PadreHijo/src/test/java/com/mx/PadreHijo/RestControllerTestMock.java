package com.mx.PadreHijo;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mx.PadreHijo.Controller.PadreWS;
import com.mx.PadreHijo.Dominio.Padre;
import com.mx.PadreHijo.Service.PadreServiceImp;

@WebMvcTest(PadreWS.class)
public class RestControllerTestMock {
	@Autowired
	private MockMvc mockMvc;
	
	@MockitoBean
	private  PadreServiceImp service;
	
	@Test
	void PadreMensajeMock() throws Exception{
		// Crear algunos registros de prueba
		Padre padre1 = new Padre(1, "Juan", "Martinez", 45, "Carpintero");
		Padre padre2 = new Padre(2, "Pedro", "Fernandez", 23, "Mesero");
		List<Padre> lista = List.of(padre1, padre2);
		
		// Simulacion: EL servicio devuelve una lista de padre
		when(service.listar()).thenReturn(lista);
		
		// COnvertir la lista de padres en JSON 
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonResponse = objectMapper.writeValueAsString(lista);
	
		// Realizar la solicitud GET al endpoint listar
		this.mockMvc.perform(get("/api/Padre/listar"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().json(jsonResponse));
	}
	
	@Test
	void PadreBuscarMock() throws Exception{
		Padre padre = new Padre(1, "Juan", "Martinez", 45, "Carpintero");
		
		when(service.buscar(padre.getIdPadre())).thenReturn(padre);
		
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonRequest = objectMapper.writeValueAsString(padre);
		String jsonResponse = objectMapper.writeValueAsString(padre);
	
		// Realizar la solicitud POST al endpoint listar
		this.mockMvc.perform(post("/api/Padre/buscar")
			.contentType("application/json") // Se esta enviando un JSON
	        .content(jsonRequest)) // Cuerpo del JSON enviado
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().json(jsonResponse));
	}
	
	@Test
	void PadreEliminarMock() throws Exception{
		Padre padre = new Padre(1, "Juan", "Martinez", 45, "Carpintero");
		
		doNothing() // No hacer nada (útil para métodos void)
			.when(service) // Aplica la configuración al mock service
			.eliminar(padre.getIdPadre()); // Método interceptado en el mock
		
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonRequest = objectMapper.writeValueAsString(padre);
	
		// Realizar la solicitud DELETE al endpoint listar
		this.mockMvc.perform(delete("/api/Padre/eliminar")
			.contentType("application/json") // Se esta enviando un JSON
	        .content(jsonRequest)) // Cuerpo del JSON enviado
		.andDo(print())
		.andExpect(status().isOk());
	}
	
	@Test
	void PadreGuardarMock() throws Exception{
		Padre padre = new Padre(1, "Juan", "Martinez", 45, "Carpintero");
		
		doNothing() // No hacer nada (útil para métodos void)
			.when(service) // Aplica la configuración al mock service
			.guardar(padre); // Método interceptado en el mock
		
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonRequest = objectMapper.writeValueAsString(padre);
	
		// Realizar la solicitud POST al endpoint listar
		this.mockMvc.perform(post("/api/Padre/guardar")
			.contentType("application/json") // Se esta enviando un JSON
	        .content(jsonRequest)) // Cuerpo del JSON enviado
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("El padre " + padre.getNombre() + " se guardo correctamente")));
	}
	
	@Test
	void PadreEditarMock() throws Exception{
		Padre padre = new Padre(1, "Juan", "Martinez", 45, "Carpintero");
		
		doNothing() // No hacer nada (útil para métodos void)
			.when(service) // Aplica la configuración al mock service
			.editar(padre); // Método interceptado en el mock
		
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonRequest = objectMapper.writeValueAsString(padre);
	
		// Realizar la solicitud POST al endpoint listar
		this.mockMvc.perform(post("/api/Padre/editar")
			.contentType("application/json") // Se esta enviando un JSON
	        .content(jsonRequest)) // Cuerpo del JSON enviado
		.andDo(print())
		.andExpect(status().isOk());
	}
}
