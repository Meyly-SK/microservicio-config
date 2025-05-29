package com.example.microservicio_venta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan({"com.example.commons.exceptions","com.example.microservicio_venta"})
@EntityScan({"com.example.microservicio_venta.models"})
public class MicroservicioVentaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioVentaApplication.class, args);
	}

}
