package com.example.microservicio_compra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@ComponentScan({"com.example.commons.exceptions","com.example.microservicio_compra"})
@EntityScan({"com.example.microservicio_compra.models"})
public class MicroservicioCompraApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioCompraApplication.class, args);
	}

}
