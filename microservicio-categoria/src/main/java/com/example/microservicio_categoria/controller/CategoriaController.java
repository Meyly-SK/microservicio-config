package com.example.microservicio_categoria.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.commons.controller.CommonController;
import com.example.commons.exceptions.NotFoundException;
import com.example.microservicio_categoria.models.Categoria;
import com.example.microservicio_categoria.service.CategoriaService;

import jakarta.validation.Valid;


@RestController
public class CategoriaController extends CommonController<Categoria, CategoriaService>{

	@PostMapping("/{id}")
	public ResponseEntity<?> testEditar(@Valid @RequestBody Categoria categoria,BindingResult result, @PathVariable Long id ) {
	    
		if(result.hasErrors()) {
			return this.validar(result);
		}
	    
	    Categoria dbCategoria = this.service.findById(id)
	        .orElseThrow(() -> new NotFoundException("Categoria con ID " + id + " no encontrada"));
	    
	    dbCategoria.setNombre(categoria.getNombre());
	    dbCategoria.setDescripcion(categoria.getDescripcion());
	    
	    return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbCategoria));
	}

}
