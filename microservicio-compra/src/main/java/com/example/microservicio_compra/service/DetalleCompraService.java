package com.example.microservicio_compra.service;



import com.example.commons.service.CommonService;
import com.example.microservicio_compra.models.DetalleCompra;
import com.example.microservicio_compra.models.MovimientoInventario;
import com.example.microservicio_compra.models.Producto;

public interface DetalleCompraService extends CommonService<DetalleCompra>{

	public MovimientoInventario guardarInventario (MovimientoInventario movimiento);
	
	public Producto obtenerInventario ( Long id);
}
