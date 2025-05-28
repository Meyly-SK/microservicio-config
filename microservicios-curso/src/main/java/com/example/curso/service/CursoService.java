package com.example.curso.service;

import com.example.commons.service.CommonService;
import com.example.curso.model.Curso;

public interface CursoService extends CommonService<Curso>{

	public Curso findCursoByAlumnoId(Long id);
	
	public Iterable<Long> obtenerExamenesIdsConRespuestasAlumno( Long alumnoId);
}
