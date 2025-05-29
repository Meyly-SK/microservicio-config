package com.microservicio_inventario_live.models;


public class Producto {


	private Long id;
	private String nombre;
	private String descripcion;
	private int stockActual;

	private Categoria categoria;
	
	private Proveedor proveedor;    
 
	private double precioUnitario;

	public Producto(Long id, String nombre, String descripcion, int stockActual, Categoria categoria,
			Proveedor proveedor, double precioUnitario) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.stockActual = stockActual;
		this.categoria = categoria;
		this.proveedor = proveedor;
		this.precioUnitario = precioUnitario;
	}
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getStockActual() {
		return stockActual;
	}

	public void setStockActual(int stockActual) {
		this.stockActual = stockActual;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	
	
}
