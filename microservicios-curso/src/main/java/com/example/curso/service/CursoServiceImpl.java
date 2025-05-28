package com.example.curso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.commons.service.CommonServiceImpl;
import com.example.curso.clients.RespuestaFeignClient;
import com.example.curso.model.Curso;
import com.example.curso.repository.CursoRepository;

@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso, CursoRepository>  implements CursoService{

	@Autowired
	private RespuestaFeignClient client;
	
	@Override
	@Transactional(readOnly = true)
	public Curso findCursoByAlumnoId(Long id) {
		// TODO Auto-generated method stub
		return repository.findCursoByAlumnoId(id);
	}

	@Override
	public Iterable<Long> obtenerExamenesIdsConRespuestasAlumno(Long alumnoId) {
		// TODO Auto-generated method stub
		return client.obtenerExamenesIdsConRespuestasAlumno(alumnoId);
	}



}
