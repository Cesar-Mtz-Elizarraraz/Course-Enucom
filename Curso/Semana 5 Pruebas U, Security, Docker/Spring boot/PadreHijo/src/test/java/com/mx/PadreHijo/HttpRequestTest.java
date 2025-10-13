package com.mx.PadreHijo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) // Indica el servidor Spring en un puerto aleatorio para evitar conflicto
// Esta anotación crea un contexto de prueba completo para la aplicación
public class HttpRequestTest {
	@LocalServerPort // Inyecta el puerto asignado cuando se contruya el URL
	private int port;
	
	@Autowired
	TestRestTemplate restTemplate; // Permitir enviar solicitudes http simuladas y obtener respuestas
	
	@Test
	void pruebaControllerMensajePredeterminado() throws Exception{
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
				String.class)).contains("Hola Mundo");
	}
}
