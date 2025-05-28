package com.example.microservicio_producto.service;

import java.util.List;

import com.example.commons.service.CommonService;
import com.example.microservicio_producto.models.Categoria;
import com.example.microservicio_producto.models.Producto;
import com.example.microservicio_producto.models.Proveedor;

public interface ProductoService extends CommonService<Producto>{

	public List<Producto> obtenerProductosPorCategoria(Long categoriaId);
	
	public List<Producto> obtenerProductosPorProveedor(Long proveedorId);
	
	
	public Iterable<Categoria> obtenerCategorias();
	
	public Categoria obtenerCategoriaPorId(Long categoriaId);
	
	public Proveedor obtenerProveedoraPorId(Long proveedorId);
	
	
}
