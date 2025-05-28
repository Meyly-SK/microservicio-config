package com.example.microservicio_producto.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.microservicio_producto.models.Proveedor;

@FeignClient(name = "microservicio-proveedor")
public interface ProveedorFeignClient {

	@GetMapping("/")
	public Iterable<Proveedor> obtenerProveedores();
	
	@GetMapping("/{id}")
	public Proveedor obtenerProveedorPorId(@PathVariable Long id);
}
