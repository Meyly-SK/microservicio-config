package com.example.microservicio_cliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan({"com.example.commons.exceptions","com.example.microservicio_cliente"})
@EntityScan({"com.example.microservicio_cliente.models"})
public class MicroservicioClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioClienteApplication.class, args);
	}

}
