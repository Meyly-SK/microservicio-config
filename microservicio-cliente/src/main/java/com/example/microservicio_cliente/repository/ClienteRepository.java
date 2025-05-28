package com.example.microservicio_cliente.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.microservicio_cliente.models.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long>{

}
