package com.example.curso.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.curso.model.Curso;

public interface CursoRepository extends CrudRepository<Curso, Long>{

	@Query("select c from Curso c join fetch c.alumnos a where a.id = ?1")
	public Curso findCursoByAlumnoId(Long id);
}
