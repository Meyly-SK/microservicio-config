package com.microservicio_inventario_live.models;

import java.util.Date;


public class MovimientoInventario {

	private Long id;
	private Producto producto;
	private Date fecha;
	private int cantidad;
	private String tipoMovimiento;
    private String origen;
    private Long referenciaId; 
	private String descripcion;
	
	public MovimientoInventario(Long id, Producto producto, Date fecha, int cantidad, String tipoMovimiento,
			String origen, Long referenciaId, String descripcion) {
		this.id = id;
		this.producto = producto;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.tipoMovimiento = tipoMovimiento;
		this.origen = origen;
		this.referenciaId = referenciaId;
		this.descripcion = descripcion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public Long getReferenciaId() {
		return referenciaId;
	}

	public void setReferenciaId(Long referenciaId) {
		this.referenciaId = referenciaId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
