package com.example.examen.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.common_examen.model.Asignatura;
import com.example.common_examen.model.Examen;
import com.example.commons.service.CommonServiceImpl;
import com.example.examen.repository.AsignaturaRepository;
import com.example.examen.repository.ExamenRepository;
@Service
public class ExamenServiceImpl extends CommonServiceImpl<Examen, ExamenRepository> implements ExamenService {

	@Autowired
	private AsignaturaRepository asignaturaRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Examen> findByNombre(String term) {
		// TODO Auto-generated method stub
		return repository.findByNombre(term);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Asignatura> findAllAsignaturas() {
		// TODO Auto-generated method stub
		return asignaturaRepository.findAll();
	}



}
