package com.example.microservicio_categoria.service;
import com.example.microservicio_categoria.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import com.example.commons.service.CommonServiceImpl;
import com.example.microservicio_categoria.models.Categoria;

@Service
public class CategoriaServiceImpl extends CommonServiceImpl<Categoria, CategoriaRepository> implements CategoriaService{


}
