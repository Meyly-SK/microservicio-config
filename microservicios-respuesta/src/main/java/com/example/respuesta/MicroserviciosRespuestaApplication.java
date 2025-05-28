package com.example.respuesta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@EntityScan({"com.example.respuesta.models",
			 "com.example.commons_alumno.models",
			 "com.example.common_examen.model"})
public class MicroserviciosRespuestaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosRespuestaApplication.class, args);
	}

}
