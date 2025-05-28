package com.example.microservicio_compra.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.microservicio_compra.models.DetalleCompra;

public interface CompraDetalleRepository extends CrudRepository<DetalleCompra, Long>{

}
