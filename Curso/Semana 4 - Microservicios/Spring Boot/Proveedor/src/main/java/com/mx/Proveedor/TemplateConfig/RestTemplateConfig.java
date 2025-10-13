package com.mx.Proveedor.TemplateConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Bean;

@Configuration // Define que la clase contiene una configuración para la aplicación y debe definir uno o más beans
public class RestTemplateConfig {
	@Bean
	// RestTemplate es una clase de Spring que permite consumir Servicios Rest desde la propia aplicación
	RestTemplate restTemplate () {
		return new RestTemplate();
	}
}
