package com.mx.EnviarCliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EnviarClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnviarClienteApplication.class, args);
	}

}
