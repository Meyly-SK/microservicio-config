package com.microservicio_inventario_live.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.microservicio_inventario_live.models.MovimientoInventario;

import reactor.core.publisher.Flux;

@Service
public class MovimientoService {

	private final WebClient webclient;
	
	public MovimientoService(WebClient.Builder builder) {
		// TODO Auto-generated constructor stub
		this.webclient = builder.baseUrl("htttp://microservicio-movimiento").build();
	}
	
	public Flux<MovimientoInventario> obtenerMovimientos(){
		return webclient.get()
				.uri("/movimientos")
				.retrieve()
				.bodyToFlux(MovimientoInventario.class);
	}
}
