package com.example.microservicio_venta.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.microservicio_venta.models.DetalleVenta;

public interface DetalleVentaRepository extends CrudRepository<DetalleVenta, Long>{

}
