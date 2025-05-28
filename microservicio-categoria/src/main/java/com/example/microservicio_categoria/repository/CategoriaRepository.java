package com.example.microservicio_categoria.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.microservicio_categoria.models.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, Long>{

}
