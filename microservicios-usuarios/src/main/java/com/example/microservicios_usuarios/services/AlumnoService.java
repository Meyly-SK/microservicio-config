package com.example.microservicios_usuarios.services;

import java.util.List;

import com.example.commons.service.CommonService;
import com.example.commons_alumno.models.Alumno;

public interface AlumnoService extends CommonService<Alumno> {

	public List<Alumno> findByNombreOrApellido(String term);
}
