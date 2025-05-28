package com.example.respuesta.services;


import com.example.respuesta.models.Respuesta;

public interface RespuestaService {

	public Iterable<Respuesta> saveAll(Iterable<Respuesta> respuestas);
	
	public Iterable<Respuesta> findRespuestaByAlumnoByExamen(Long alumnoId, Long examenId);
	
	public Iterable<Long> findExamenesIdsConRespuestasByAlumno(Long alumnoId);
	
	public Iterable<Long> obtenerExamenesIdsConRespuestasAlumno( Long alumnoId);
}
