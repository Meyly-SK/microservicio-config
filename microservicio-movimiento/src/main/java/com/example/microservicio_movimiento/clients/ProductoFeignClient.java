package com.example.microservicio_movimiento.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.microservicio_movimiento.models.Producto;

@FeignClient(name = "microservicio-producto")
public interface ProductoFeignClient {

	@GetMapping("/{id}")
	public Producto obtenerProductoPorId(@PathVariable Long id);
	
	@PostMapping()
	public Producto guardarProducto (@RequestBody Producto producto);
	
}
