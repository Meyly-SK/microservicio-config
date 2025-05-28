package com.example.microservicio_movimiento.service;

import java.util.List;

import com.example.commons.service.CommonService;
import com.example.microservicio_movimiento.models.MovimientoInventario;
import com.example.microservicio_movimiento.models.Producto;

public interface MovimientoInventarioService extends CommonService<MovimientoInventario>{

	public Producto guardarProducto (Producto producto);
	
	public Producto obtenerProductoPorId(Long id);
	
	public List<MovimientoInventario> obtenerMovimientosPorProductoId(Long productoId);
}
