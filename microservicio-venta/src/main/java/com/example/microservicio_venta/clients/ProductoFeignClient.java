package com.example.microservicio_venta.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.microservicio_venta.models.Producto;


@FeignClient(name = "microservicio-producto")
public interface ProductoFeignClient {

	@GetMapping("/{id}")
	public Producto obtenerInventario (@PathVariable Long id);
}
