package com.example.examen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@EntityScan({"com.example.common_examen.model"})
public class MicroserviciosExamenApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosExamenApplication.class, args);
	}

}
