package com.mx.Veterinarias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class VeterinariasApplication {

	public static void main(String[] args) {
		SpringApplication.run(VeterinariasApplication.class, args);
	}

}
