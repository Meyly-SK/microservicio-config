package com.example.microservicio_venta.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.microservicio_venta.models.Venta;

public interface VentaRepository extends CrudRepository<Venta, Long>{

}
