package com.example.examen.service;

import java.util.List;

import com.example.common_examen.model.Asignatura;
import com.example.common_examen.model.Examen;
import com.example.commons.service.CommonService;

public interface ExamenService extends CommonService<Examen>{

	public List<Examen> findByNombre(String term);
	
	public Iterable<Asignatura> findAllAsignaturas();
}
