package com.example.microservicio.proveedor.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.microservicio.proveedor.model.Proveedor;

public interface ProveedorRepository extends CrudRepository<Proveedor, Long>{

}
