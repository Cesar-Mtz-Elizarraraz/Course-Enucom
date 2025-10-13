package com.mx.PadreHijo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc // COnfigura MockMvc para probar controladores
public class TestMockController {
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void pruebaMockitoMensajePredeterminado() throws Exception{
		this.mockMvc.perform(get("/")) // Simular la solicitud http GET
			.andDo(print()) // Imprimir la respuesta HTTP para la depuración
			.andExpect(status().isOk()) // Status esperado
			.andExpect(content().string(containsString("Hola Mundo"))); // Respuesta esperada
	}
}
