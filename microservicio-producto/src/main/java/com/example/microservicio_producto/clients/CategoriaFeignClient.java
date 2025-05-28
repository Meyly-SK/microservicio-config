package com.example.microservicio_producto.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.microservicio_producto.models.Categoria;

import jakarta.ws.rs.Path;

@FeignClient(name = "microservicio-categoria")
public interface CategoriaFeignClient {

	@GetMapping("/")
	public Iterable<Categoria> obtenerCategorias();
	
	@GetMapping("/{id}")
	public Categoria obtenerCategoriaPorId(@PathVariable Long  id);
}
