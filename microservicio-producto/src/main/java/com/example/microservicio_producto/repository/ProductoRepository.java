package com.example.microservicio_producto.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.microservicio_producto.models.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long>{

	List<Producto> findByCategoriaId(Long id);
	
	List<Producto> findByProveedorId(Long id);
}
