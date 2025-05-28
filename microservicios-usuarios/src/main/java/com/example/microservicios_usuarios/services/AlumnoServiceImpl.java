package com.example.microservicios_usuarios.services;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.commons.service.CommonServiceImpl;
import com.example.commons_alumno.models.Alumno;
import com.example.microservicios_usuarios.repository.AlumnoRepository;

@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno, AlumnoRepository> implements AlumnoService{

	@Override
	@Transactional(readOnly = true)
	public List<Alumno> findByNombreOrApellido(String term) {
		// TODO Auto-generated method stub
		return repository.findByNombreOrApellido(term);
	}

	
}
