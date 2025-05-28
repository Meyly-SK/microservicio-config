package com.example.microservicio_venta.service;

import com.example.commons.service.CommonService;
import com.example.microservicio_venta.models.DetalleVenta;
import com.example.microservicio_venta.models.MovimientoInventario;
import com.example.microservicio_venta.models.Producto;

public interface DetalleVentaService extends CommonService<DetalleVenta>{

	public MovimientoInventario guardarInventario(MovimientoInventario movimiento);
	
	public Producto obtenerInventario(Long id);
}
