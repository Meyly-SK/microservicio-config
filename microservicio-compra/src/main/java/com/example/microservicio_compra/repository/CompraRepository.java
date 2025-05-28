package com.example.microservicio_compra.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.example.microservicio_compra.models.Compra;

public interface CompraRepository extends CrudRepository<Compra, Long>{

}
