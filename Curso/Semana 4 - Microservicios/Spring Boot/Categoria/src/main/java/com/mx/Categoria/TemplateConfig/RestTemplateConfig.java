package com.mx.Categoria.TemplateConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Bean;

@Configuration // Define que la clase contiene una configuración para la aplicación y debe definir uno o más beans
public class RestTemplateConfig {
	@Bean
	RestTemplate restTemplate () {
		return new RestTemplate();
	}
	
	// RestTemplate es una clase de Spring que permite consumir Servicios Rest desde la propia aplicación
	// basicamente es un cliente HTTP integrado en Spring, el cual permite hacer llamadas a otros servicios WEB y recibir
	// la respuesta directamente como objetos Java,
	// En este caso se va a enviar una petición GET al microservicio de Producto
	// @GetMapping("buscarPorCategoria/{categoriaId}") <- Petición a ese controlador
	// Esto devolverá un JSON con la lista de productos
	// A ESTO SE LE LLAMA "COMUNICACIÓN SÍNCRONA ENTRE MICROSERVICIOS USANDO REST"
	// Sincrona -> EL microservicio CAtegoria espera la respuesta del servicio Producto antes de continuar
	// REST/HTTP -> Se esta usando HTTP para solicitar la informacion y los datos se transfieren en formato JSON
	
	// Cada microservicio sigue siendo independiente, pero se comunican a traves de endpoints expuestos
}
