package com.example.microservicio_movimiento.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.microservicio_movimiento.models.MovimientoInventario;

public interface MovimientoInventarioRepository extends CrudRepository<MovimientoInventario, Long>{

	List<MovimientoInventario> findByProductoId(Long productoId);
}
